package LowLevelDesign.NotificationSystem.NotificationContentType;

import LowLevelDesign.NotificationSystem.NotificationSender.NotificationSenderChannel;

public abstract class NotificationContent {
    NotificationSenderChannel notificationSenderChannel;

    public NotificationContent(NotificationSenderChannel notificationSenderChannel){
        this.notificationSenderChannel = notificationSenderChannel;
    }

    public abstract void sendMessage();
}
