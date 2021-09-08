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
    security = Docker("security-service")
    posts = Docker("posts-service")
    followers = Docker("followers-service")
    notification = Docker("notification-service")
    etc = Docker("[...]")

    with Cluster("CD/CI"):
        cdci_group = Github() >> GithubActions("GitHub Actions")

    notification >> user
    user >> gateway >> discovery >> \
        [security, posts, followers, etc] >> discovery

    Edge() >> cdci_group
