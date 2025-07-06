package LowLevelDesign.NotificationSystem;

import LowLevelDesign.NotificationSystem.NotificationContentType.NotificationContent;
import LowLevelDesign.NotificationSystem.NotificationContentType.QRCode;
import LowLevelDesign.NotificationSystem.NotificationContentType.TextMessage;
import LowLevelDesign.NotificationSystem.NotificationSender.NotificationViaEmail;
import LowLevelDesign.NotificationSystem.NotificationSender.NotificationViaSMS;
import LowLevelDesign.NotificationSystem.NotificationSender.NotificationViaWhatsapp;

public class Main {

    public static void main(String[] args){
        NotificationContent msg1 = new TextMessage(new NotificationViaSMS());
        NotificationContent msg2 = new QRCode(new NotificationViaWhatsapp());
        NotificationContent msg3 = new TextMessage(new NotificationViaEmail());

        msg1.sendMessage();
        msg2.sendMessage();
        msg3.sendMessage();
    }
}
