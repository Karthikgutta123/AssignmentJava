//   Implement the Factory Design Pattern for creating different types of notifications (Email, SMS, Push).


package main;

interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("sending an EMAIL notificn");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("sending an SMS notificn");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("sending a PUSH notificn");
    }
}

class factoryNotification {
    public Notification createNotificn(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}

public class factoryDesign {
    public static void main(String[] args) {
        factoryNotification factory = new factoryNotification();

        Notification email = factory.createNotificn("EMAIL");
        email.notifyUser();

        Notification sms = factory.createNotificn("SMS");
        sms.notifyUser();

        Notification push = factory.createNotificn("PUSH");
        push.notifyUser();
    }
}