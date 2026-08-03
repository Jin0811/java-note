package oop;

public class ConstructorDemo {
    public static void main(String[] args) {
        Product phone = new Product("iPhone", 6999.0);
        Product keyboard = new Product("Keyboard");

        phone.printInfo();
        keyboard.printInfo();
    }
}

class Product {
    String name;
    double price;

    // ===== 构造方法（Constructor）=====
    // 特点：没有返回值（连 void 都不能写），方法名必须和类名完全一致。
    // 作用：在 new 创建对象时第一个被调用，负责给字段赋初始值。
    // 类比 JS：相当于 class 里的 constructor() {}。
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // ===== 构造方法重载（Overloading）=====
    // 一个类可以写多个构造方法，靠"参数列表"互相区分，
    // 而不是只靠参数个数——包括：参数个数 + 参数类型 + 参数顺序。
    // 下面这个和上面那个，因为参数个数不同，就是两个不同的构造方法。
    // 调用时 new Product(...) 传什么参数，就匹配哪个构造方法（编译期决定）。
    //
    // 注意：
    // 1. 重载不能只靠"返回值不同"区分（构造方法本来也没返回值）。
    // 2. 一个构造方法都不写时，Java 自动送一个"无参构造"；
    //    但只要你自己写了任意一个构造方法，这个无参构造就消失了，
    //    此时 new Product() 会报错，除非手动补一个空的 Product() {}。
    Product(String name) {
        // this(...) 是"构造方法之间互相调用"的写法，可以把重复逻辑委托给另一个构造方法。
        // 注意：this(...) 必须放在构造方法的第一行。
        // 下面这句等价于把 name、price=0 交给 (String, double) 那个构造方法处理。
        this(name, 0);
    }

    void printInfo() {
        System.out.println(name + " price = " + price);
    }
}

