package LowLevelDesign.NotificationSystem.NotificationSender;

public class NotificationViaSMS implements NotificationSenderChannel{
    @Override
    public void sentNotification() {
        //Send message via text msg
        System.out.println("Message is sent via SMS");
    }
}
