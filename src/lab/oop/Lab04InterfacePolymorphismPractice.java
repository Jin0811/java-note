package lab.oop;

public class Lab04InterfacePolymorphismPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：接口、多态。
         *
         * TODO:
         * 1. 创建 EmailSender 和 SmsSender。
         * 2. 用 MessageSender 类型接收它们。
         * 3. 调用 sendMessage 方法分别发送消息。
         */
    }

    static void sendMessage(MessageSender sender, String message) {
        // TODO: 调用 sender 的发送方法。
    }
}

interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender {
    public void send(String message) {
        // TODO: 输出邮件发送内容。
    }
}

class SmsSender implements MessageSender {
    public void send(String message) {
        // TODO: 输出短信发送内容。
    }
}

