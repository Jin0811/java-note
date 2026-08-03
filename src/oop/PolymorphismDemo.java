package oop;

/*
  ===== 多态（Polymorphism）=====

  一句话定义：同一个方法调用，作用在不同对象上，表现出不同的行为。

  多态成立的三个条件（缺一不可）：
    1. 继承 / 实现       子类继承父类，或实现接口
    2. 方法重写          子类重写了父类/接口的方法
    3. 父类型引用指向子类对象  Notification n = new EmailNotification();
       （接口类型引用指向实现类对象，思路完全一样，后端项目更常见）

  执行规则："编译看左边，运行看右边"
    · 编译期：编译器只检查"声明类型"（左边的 Notification）有没有这个方法；
    · 运行期：实际执行的是"右边 new 出来的对象"的重写版本。

  多态的价值（为什么要用它）：
    · 调用方只依赖父类/接口，不关心具体实现 → 新增实现不用改调用代码。
      例如以后加 PushNotification，send() 和广播循环一行都不用动。
    · 不同实现可以放进数组/集合，用一个循环统一处理。
    · Spring 的"面向接口编程"、@Autowired 注入接口得到实现类，
      本质就是建立在这个机制上。
*/

public class PolymorphismDemo {
    public static void main(String[] args) {
        // ===== 1. 接口类型引用指向实现类对象（多态的核心写法）=====
        Notification email = new EmailNotification();
        Notification sms = new SmsNotification();

        // ===== 2. 同一个 send() 方法，不同对象不同行为 =====
        send(email, "Your order has been paid");
        send(sms, "Your code is 123456");

        // ===== 3. 数组 + 循环统一处理：多态最常用的实战场景 =====
        // 以后新增 PushNotification，只需往数组里加一项，下面的循环不用改。
        Notification[] notifications = {email, sms};
        for (Notification n : notifications) {
            n.send("Broadcast message");
        }

        // ===== 4. instanceof + 向下转型：需要调"子类特有方法"时 =====
        // 声明类型是 Notification，接口里没有 setCc()，
        // 必须先判断真实类型（instanceof），再强转成实现类才能调。
        Notification n = new EmailNotification();
        if (n instanceof EmailNotification) {
            EmailNotification real = (EmailNotification) n;   // 向下转型
            real.setCc("admin@example.com");
        }
        // Java 16+ 的模式匹配 instanceof：判断和转型合成一步（本项目 JDK 17 可用）
        if (n instanceof EmailNotification en) {
            en.setCc("ops@example.com");
        }
    }

    // 参数声明为接口类型：这个方法不关心传进来的到底是邮件还是短信，
    // 传什么就跑什么的 send() —— 这就是"面向接口编程"。
    static void send(Notification notification, String message) {
        notification.send(message);   // 运行期决定执行哪个实现类的 send()
    }
}

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    private String cc;

    @Override
    public void send(String message) {
        System.out.println("Send email: " + message);
    }

    // 实现类特有的方法：接口里没有，不能通过 Notification 引用直接调用，
    // 必须先用 instanceof 判断再向下转型（见 main 里第 4 段）。
    void setCc(String cc) {
        this.cc = cc;
        System.out.println("Email cc set to: " + cc);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Send SMS: " + message);
    }
}

