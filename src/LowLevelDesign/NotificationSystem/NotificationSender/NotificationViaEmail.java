package LowLevelDesign.NotificationSystem.NotificationSender;

public class NotificationViaEmail implements NotificationSenderChannel{
    @Override
    public void sentNotification() {
        //Add a logic for Firing Email from here
        System.out.println("Message is sent via Email");
    }
}
