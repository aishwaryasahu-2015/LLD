package LowLevelDesign.NotificationSystem.NotificationContentType;

import LowLevelDesign.NotificationSystem.NotificationSender.NotificationSenderChannel;

public class QRCode extends NotificationContent{

    public QRCode(NotificationSenderChannel notificationSenderChannel) {
        super(notificationSenderChannel);
    }

    @Override
    public void sendMessage() {
        this.notificationSenderChannel.sentNotification();
    }
}
