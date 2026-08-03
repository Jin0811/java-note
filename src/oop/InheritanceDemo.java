package oop;

/*
  ===== 继承（Inheritance）补充：重写、访问权限、多态 =====

  继承除了"子类拿到父类的方法"，还有几个必须掌握的点：

  1. 方法重写（Override）
     子类可以提供一个"和父类同名、同参数"的方法，覆盖父类的实现。
     调用时以"对象实际类型"的版本为准。
     加 @Override 注解让编译器帮你校验：方法名/参数写错了会立刻报错，
     避免"以为在重写、其实是新写了一个方法"的隐蔽 bug。

  2. super 的两个用法
     · super(...)     在构造方法第一行调用父类构造方法。
     · super.xxx(...) 在重写的方法里调用父类的原实现（先复用、再扩展）。

  3. 继承中的访问权限
     · private 成员：子类"看不到"，既不能直接用，也不能重写。
       （它仍然存在于对象内存里，只是对子类不可见；要访问得靠父类开 getter）
     · protected 成员：父类 + 子类可见，就是为"继承"准备的访问级别。
     · 子类能继承到的可见成员：public、protected、(同包的)默认。

  4. 多态（Polymorphism）—— 继承的真正价值所在
     父类类型的引用可以指向子类对象：Engineer e = new FrontendEngineer(...);
     调用被重写的方法时，运行的是"子类版本"。
     好处：写代码时可以面向父类编程，不用关心具体是哪个子类。

  5. Java 是单继承
     一个类只能 extends 一个父类（不能 extends A, B），
     想要"多方能力"靠接口 implements（interface 目录再讲）。
*/

public class InheritanceDemo {
    public static void main(String[] args) {
        FrontendEngineer frontend = new FrontendEngineer("Alex");
        BackendEngineer backend = new BackendEngineer("Ben");

        // 直接用子类对象：既能调继承来的父类方法，也能调自己的方法
        frontend.work();          // 调用被子类重写过的 work()
        frontend.buildPage();     // 子类自己的方法

        backend.work();
        backend.buildApi();

        // ===== 多态：父类引用指向子类对象 =====
        // 声明类型是 Engineer，实际 new 的是 FrontendEngineer。
        // 调用 work() 时，运行的是"子类重写后的版本"，而不是父类的。
        Engineer e = new FrontendEngineer("Cindy");
        e.work();                  // 输出前端版本（子类实现）
        System.out.println("salary = " + e.getSalary());
        // e.buildPage();          // 编译错误：e 的"声明类型"是 Engineer，找不到这个方法
    }
}

// ===== 父类 =====
class Engineer {
    String name;            // 默认(包私有)：同包子类可见
    private double salary;  // private：子类不能直接访问，也不能重写

    Engineer(String name) {
        this.name = name;
        this.salary = 20000;
    }

    // 这个方法会被子类"重写"。
    void work() {
        System.out.println(name + " is writing code");
    }

    // protected：专门给继承用的访问级别，父类 + 子类可见（跨包也行）。
    protected void clockIn() {
        System.out.println(name + " clocked in");
    }

    // private 方法：子类既不能用、也不能重写。
    private void calcBonus() {
        System.out.println("calculating bonus...");
    }

    // 子类想读 private 的 salary，得通过父类开放的 getter。
    double getSalary() {
        return salary;
    }
}

class FrontendEngineer extends Engineer {
    FrontendEngineer(String name) {
        super(name);   // super(...)：构造方法第一行调用父类构造方法
    }

    // ===== 方法重写 =====
    // @Override 让编译器校验这确实是重写（签名对不上会直接报错）。
    @Override
    void work() {
        super.work();   // super.xxx()：先调用父类的原实现（复用）
        System.out.println(name + " builds Vue pages");   // 再补充子类自己的逻辑
    }

    void buildPage() {
        clockIn();      // protected 方法：子类可以直接调用
        // calcBonus(); // 编译错误：父类 private 方法对子类不可见
        System.out.println(name + " builds Vue pages");
    }
}

class BackendEngineer extends Engineer {
    BackendEngineer(String name) {
        super(name);
    }

    // 重写：完全替换父类实现（不调 super.work()）
    @Override
    void work() {
        System.out.println(name + " builds Java APIs");
    }

    void buildApi() {
        System.out.println(name + " builds Java APIs");
    }
}

