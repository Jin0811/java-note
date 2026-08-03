package oop;

/*
  ===== static（静态成员）=====

  static 修饰的成员"属于类本身"，而不属于某个具体对象。
  类比 TS：class 里的 static 字段/static 方法，概念完全一样。

  ┌────────────────┬──────────────────────────────┬─────────────────────────────┐
  │                │ 静态成员（static）            │ 实例成员（不加 static）       │
  ├────────────────┼──────────────────────────────┼─────────────────────────────┤
  │ 归属           │ 类（全类只有一份）            │ 每个对象各有一份               │
  │ 访问方式       │ 类名.成员                     │ 对象.成员                     │
  │ 生命周期       │ 类加载时就存在                │ new 对象时才有                │
  │ 典型用途       │ 常量、计数器、工具方法、main   │ 描述某个对象自己的状态/行为     │
  └────────────────┴──────────────────────────────┴─────────────────────────────┘

  四类静态成员：
    1. static 字段（类变量）：所有实例共享一份，如 companyName、count。
    2. static 常量（static final）：命名习惯全大写下划线，如 MAX_SALARY。
       已经见过：System.out、Math.PI 都是 static final。
    3. static 方法：不需要对象就能调，类名直接点。
       已经见过：Arrays.toString()、Math.random() 都是静态工具方法。
       main 本身也是 static——JVM 启动时还没有任何对象，入口必须属于类。
    4. static 初始化块 static { ... }：类首次加载时执行一次且仅一次，
       用于复杂的静态字段初始化。执行时机早于任何构造方法。

  核心规则："静态不能碰实例"
    static 方法里没有 this（可能还没有任何对象存在），
    所以不能直接访问实例字段/实例方法；反过来实例方法可以访问静态成员。

  常见用途：
    · 全局共享的状态：计数器、缓存、配置
    · 常量：static final Xxx CONFIG = ...
    · 工具类：类里全是静态方法（如 Math、Arrays），不需要 new
*/

public class StaticDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alex");
        Employee e2 = new Employee("Ben");

        e1.printInfo();   // 实例方法：通过对象调用
        e2.printInfo();

        // 静态字段：用"类名."访问（虽然 e1.count 也能编译，但规范写法是类名访问）
        System.out.println("Employee.count = " + Employee.count);
        System.out.println("Company name = " + Employee.companyName);
        System.out.println("MAX_SALARY = " + Employee.MAX_SALARY);

        // 静态方法：类名直接调用，不需要 new 对象
        System.out.println("getTotalCount() = " + Employee.getTotalCount());
        // 工具类的用法你早就天天在用了：Arrays.toString(...)、Math.random() 都是静态方法
    }
}

class Employee {
    // ===== 静态常量：static final，命名全大写下划线，不可再赋值 =====
    static final double MAX_SALARY = 50000;
    // MAX_SALARY = 60000;   // 编译错误：final 变量不能重新赋值

    // ===== 静态字段（类变量）：所有 Employee 实例共享同一份 =====
    static String companyName = "Demo Company";
    static int count = 0;   // 全局计数器：每 new 一个员工就 +1

    // ===== 静态初始化块：类首次加载时执行一次（早于任何构造方法）=====
    static {
        System.out.println("[static 块] Employee 类被加载，count 初始化为 0");
    }

    // ===== 实例字段：每个对象各有一份 =====
    String name;

    Employee(String name) {
        this.name = name;
        count++;   // 实例方法/构造方法里可以访问静态成员（实例"看得见"静态）
    }

    void printInfo() {
        System.out.println(name + " works at " + companyName);
    }

    // ===== 静态方法：属于类，Employee.getTotalCount() 直接调用 =====
    static int getTotalCount() {
        return count;
        // return name;   // 编译错误：静态方法里访问不到实例字段（没有 this）
    }
}

