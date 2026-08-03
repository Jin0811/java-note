package oop;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Notification email = new EmailNotification();
        Notification sms = new SmsNotification();

        send(email, "Your order has been paid");
        send(sms, "Your code is 123456");
    }

    static void send(Notification notification, String message) {
        notification.send(message);
    }
}

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Send email: " + message);
    }
}

class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("Send SMS: " + message);
    }
}

