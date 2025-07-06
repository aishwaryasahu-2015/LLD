package LowLevelDesign.NotificationSystem.NotificationContentType;

import LowLevelDesign.NotificationSystem.NotificationSender.NotificationSenderChannel;

public class TextMessage extends NotificationContent{
    public TextMessage(NotificationSenderChannel notificationSenderChannel) {
        super(notificationSenderChannel);
    }

    @Override
    public void sendMessage() {
        this.notificationSenderChannel.sentNotification();
    }
}
