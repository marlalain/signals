from diagrams import Diagram, Cluster, Edge
from diagrams.onprem.ci import GithubActions
from diagrams.onprem.client import Users
from diagrams.onprem.container import Docker
from diagrams.onprem.vcs import Github
from diagrams.programming.framework import Spring

graph_attr = {
    "fontsize": "25",
    "bgcolor": "white"
}

with Diagram("Project Overview", graph_attr=graph_attr):
    user = Users("Users")
    gateway = Spring("Gateway")
    discovery = Spring("Eureka Discovery")
    notification = Docker("notification-service")

    with Cluster("Services"):
        security = Docker("security-service")
        posts = Docker("posts-service")
        followers = Docker("followers-service")
        etc = Docker("[...]")
        services = [security, posts, followers, etc]

    with Cluster("CD/CI"):
        cdci_group = Github() >> Edge(label="push") >> GithubActions("GitHub Actions")

    notification >> user
    user >> Edge() << gateway >> Edge() << discovery >> Edge() << services

    Edge() >> cdci_group
