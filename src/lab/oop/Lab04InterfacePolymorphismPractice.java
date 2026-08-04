package lab.oop;

public class Lab04InterfacePolymorphismPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：接口、多态。
         *
         * 1. 创建 EmailSender 和 SmsSender。
         * 2. 用 MessageSender 接口类型接收它们（接口引用指向实现类对象）。
         * 3. 调用 sendMessage 方法分别发送消息（面向接口编程）。
         * 4. 数组 + 循环统一处理，体现"新增实现不用改循环"。
         */

        // 接口类型引用指向实现类对象：编译看左边（MessageSender），运行看右边（具体实现）。
        MessageSender email = new EmailSender();
        MessageSender sms = new SmsSender();

        // sendMessage 的参数是接口类型，所以任何 MessageSender 实现都能传进来。
        sendMessage(email, "123");
        sendMessage(sms, "123");

        // 多态的真正威力：用数组 + 循环统一处理，一个循环服务所有实现。
        MessageSender[] senders = {new EmailSender(), new SmsSender()};
        for (MessageSender sender : senders) {
            sender.send("Broadcast");   // 同一行代码，各跑各的实现
        }
        // 以后新增 PushSender，只需往数组里加一项，上面的循环一行不用改。
    }

    static void sendMessage(MessageSender sender, String message) {
        sender.send(message);   // 运行期根据实际对象决定调用哪个实现
    }
}

interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

