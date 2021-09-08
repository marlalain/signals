from diagrams import Diagram, Cluster, Edge
from diagrams.onprem.client import User
from diagrams.onprem.inmemory import Redis
from diagrams.programming.framework import Spring

with Diagram("\nHow Notifications Work"):
    creator = User("Notification Creator")
    posts_service = Spring("Posts Service")
    receiver = User("Notification Receiver")

    with Cluster("Notification System"):
        notification_service = Spring("Notification Service")
        notification_db = Redis("Notification Database")
        notification_system = [notification_service >> Edge() << notification_db]

    creator >> Edge(label="replies to post") >> posts_service >> Edge(label="fires event") >> notification_service
    notification_service >> Edge(label="websocket", color="red") << receiver
