package oop;

/*
  ===== 接口（Interface）=====

  接口 = 一份"能力契约"：只规定"必须有哪些方法"，不管具体怎么实现。
  类比 TS：和 TS 的 interface 几乎一个思路——定义形状/契约，
  谁 implements 谁就必须提供这些成员的实现。

  接口的特点：
    · 接口里的方法默认就是 public abstract（可省略不写）。
    · 接口里的字段默认就是 public static final 常量（很少这么用）。
    · 接口不能被 new，只能被实现类 implements。
    · Java 8 起接口里可以写 default / static 方法（带方法体的），
      用于给所有实现类提供"默认实现"。

  接口 vs 类（继承）：
    · 类是"是什么"（is-a）：FrontendEngineer is an Engineer。
    · 接口是"能做什么"（can-do）：AlipayPayment "能支付"。
    · Java 是单继承（只能 extends 一个类），但可以 implements 多个接口：
        class AlipayPayment implements Payment, Refundable { ... }
      这是 Java 弥补单继承局限的主要手段。

  后端为什么到处都是接口：
    · Spring 的 Controller/Service 之间、@Autowired 注入，几乎都是接口类型。
    · 面向接口编程 + 多态（见 PolymorphismDemo）：调用方只依赖契约，
      实现可以随时替换/新增，代码不用改。
*/

public class InterfaceDemo {
    public static void main(String[] args) {
        // 接口类型引用指向实现类对象（多态，见 PolymorphismDemo）。
        // 不能写 new Payment()：接口本身不能被实例化。
        Payment alipay = new AlipayPayment();
        Payment wechat = new WechatPayment();

        // 同一个 pay()，不同实现类跑出不同行为 —— 多态。
        alipay.pay(100);
        wechat.pay(200);
    }
}

// 定义接口：只写方法签名，不写实现（JDK 9+ 也可以有 private 辅助方法，不常用）。
interface Payment {
    void pay(double amount);   // 省略了 public abstract，接口方法默认就是它
}

// implements：实现接口，必须把接口里的抽象方法全部实现（除非是抽象类）。
class AlipayPayment implements Payment {
    @Override   // 实现接口的方法也建议加 @Override 让编译器校验
    public void pay(double amount) {   // 注意：实现时必须写 public（不能比接口更严）
        System.out.println("Alipay paid " + amount);
    }
}

class WechatPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Wechat paid " + amount);
    }
}

