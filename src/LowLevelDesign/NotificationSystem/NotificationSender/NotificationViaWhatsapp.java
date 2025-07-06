package LowLevelDesign.NotificationSystem.NotificationSender;

public class NotificationViaWhatsapp implements NotificationSenderChannel{
    @Override
    public void sentNotification() {
        System.out.println("Message is sent via Whatsapp");
    }
}
