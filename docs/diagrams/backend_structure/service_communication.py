from diagrams import Diagram
from diagrams.onprem.container import Docker
from diagrams.programming.framework import Spring

graph_attr = {
    "fontsize": "25",
    "bgcolor": "white"
}

with Diagram("Services Communication", graph_attr=graph_attr):
    service = Docker("service-container")
    other_service = Docker("other-service-container")
    discovery = Spring("Discovery Server")

    service >> discovery >> other_service >> service
