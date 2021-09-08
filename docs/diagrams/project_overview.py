from diagrams import Diagram, Cluster, Edge
from diagrams.onprem.ci import GithubActions
from diagrams.onprem.client import Users
from diagrams.onprem.container import Docker
from diagrams.onprem.database import PostgreSQL
from diagrams.onprem.inmemory import Redis
from diagrams.onprem.vcs import Github

graph_attr = {
    "fontsize": "25",
    "bgcolor": "white"
}

with Diagram("Project Overview", graph_attr=graph_attr):
    user = Users("Users")
    gateway = Docker("Gateway")

    with Cluster("Security"):
        sec_group = Docker("security-service")
        sec_group - [PostgreSQL("users-db")]

    with Cluster("Posts"):
        posts_group = Docker("posts-service")
        posts_group - [PostgreSQL("posts-db")]

    with Cluster("Followers System"):
        followers_group = Docker("followers-service")
        followers_group - [PostgreSQL("followers-db")]

    with Cluster("Notifications"):
        notif_group = Docker("notification-service")
        notif_group - [Redis("notification-db")]

    with Cluster("CD/CI"):
        cdci_group = Github() >> GithubActions("GitHub Actions")

    notif_group - [user]
    user >> gateway >> sec_group
    gateway >> posts_group
    gateway >> followers_group

    Edge() >> cdci_group
