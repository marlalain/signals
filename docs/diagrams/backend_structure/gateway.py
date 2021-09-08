from diagrams import Diagram, Cluster
from diagrams.generic.database import SQL
from diagrams.generic.os import LinuxGeneral
from diagrams.onprem.client import User
from diagrams.onprem.container import Docker
from diagrams.programming.framework import Spring

graph_attr = {
    "fontsize": "25",
    "bgcolor": "white"
}

with Diagram("Gateway and Service Discovery", graph_attr=graph_attr):
    user = User("User")
    gateway = Spring("Gateway")
    discovery = Spring("Discovery Server")

    with Cluster("Sample Service"):
        sample_service = Docker("service-container")
        sample_service - [SQL("service-database"), LinuxGeneral("service-api")]

    with Cluster("Other Service"):
        other_service = Docker("service-container")
        other_service - [SQL("service-database"), LinuxGeneral("service-api")]

    user >> gateway
    gateway - [discovery]
    discovery >> [sample_service, other_service] >> discovery
