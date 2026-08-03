package basic;

/*
  ===== Java 变量定义的关键字全列表 =====

  JS/TS 声明变量有一套关键字：var / let / const。
  Java 没有这么一套“声明关键字”，Java 的常规写法是【类型 + 变量名】，例如 int age = 28。
  真正参与“变量声明形态”的关键字只有两个：var 和 final。

  ┌──────────┬──────────────────────────────────────────────────────────────┐
  │ 方式      │ 说明                                                         │
  ├──────────┼──────────────────────────────────────────────────────────────┤
  │ 显式类型  │ Java 最基础的方式：类型 + 变量名。                            │
  │ (无关键字) │ 例：int age = 28;  相当于 TS 的 let age: number = 28;        │
  ├──────────┼──────────────────────────────────────────────────────────────┤
  │ var      │ Java 10+ 引入。让编译器根据右侧的值自动推断类型，              │
  │          │ 类似 TS 的类型推断。                                          │
  │          │ 限制：只能用在【局部变量】（方法内部），不能用于类的字段、      │
  │          │ 方法参数；且声明时必须立即赋初始值（因为要靠右边的值推断类型）。  │
  ├──────────┼──────────────────────────────────────────────────────────────┤
  │ final    │ 表示变量只能被赋值一次，对应 TS 中 const 的概念。               │
  │          │ 可以用来修饰局部变量、类的字段、方法参数。                       │
  │          │ 注意：对引用类型，final 只保证“引用不能再指向别的对象”，        │
  │          │ 不保证“对象内部的字段不能改”。                                  │
  └──────────┴──────────────────────────────────────────────────────────────┘

  补充：static / transient / volatile 也能出现在字段声明上，但它们是
  “作用域并发生命周期”层面的修饰符，不属于这里“怎么定义一个变量”的核心关键字，
  会在 oop / thread 目录再展开。
*/

/*
  ===== Java 的 8 种基本类型全列表（int、double 这类“内置类型关键字”）=====

  Java 的类型分两大类：【基本类型】和【引用类型】。
  基本类型一共 8 个，都是语言内置的关键字，内存大小固定、存的是“值本身”：
  其中 4 个整数 + 2 个浮点 + 1 个布尔 + 1 个字符。

  整数类型（4 个）：
    byte    8 位，范围 -128 ~ 127，默认值 0。省内存的小整数。
    short   16 位，范围约 -3.2 万 ~ 3.2 万，默认值 0。很少用。
    int     32 位，范围约 -21 亿 ~ 21 亿，默认值 0。★最常用的整数类型。
    long    64 位，范围极大，默认值 0L。字面量要加后缀 L，如 9000000000L。

  浮点类型（2 个）：
    float   32 位，单精度，默认值 0.0f。字面量要加后缀 F，如 3.14F。很少直接用。
    double  64 位，双精度，默认值 0.0d。★最常用的浮点类型，小数默认就是它。

  布尔类型（1 个）：
    boolean 只有 true / false，默认值 false。注意：不能像 JS 那样写 0/1 当布尔用。

  字符类型（1 个）：
    char    16 位 Unicode，存“单个字符”，用单引号，如 'A'、'中'。

  ⚠️ 重要区分：String 不是基本类型！它是引用类型（一个类），所以首字母大写。
     char 存单个字符，String 存一串字符。类比 TS：
     基本类型 ≈ TS 的 number / boolean / string 原始值；
     String / 数组 / 对象 ≈ TS 里的引用类型（都是“指向堆内存的引用”）。

  TS 对照速记：
     number  -> 在 Java 被拆成了 byte/short/int/long/float/double 六个，按需选。
     boolean -> boolean（一样）。
     string  -> char(单字符) + String(字符串)。

  基本类型有固定的“默认值”（局部变量则必须先赋值才能用）：
     数值型默认 0，float 是 0.0f，double 是 0.0d，boolean 是 false，char 是 '\u0000'。
*/

public class VariableAndType {
    public static void main(String[] args) {
        // ========== 1. 显式类型声明（Java 最基础的写法，无关键字） ==========
        // JS/TS: let age: number = 28;
        int age = 28;
        double salary = 18000.50;
        boolean isFrontendDeveloper = true;
        char level = 'A';
        String name = "Alex";

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("salary = " + salary);
        System.out.println("isFrontendDeveloper = " + isFrontendDeveloper);
        System.out.println("level = " + level);

        // ========== 2. var 关键字：局部变量类型推断（Java 10+） ==========
        // var 可以让 Java 根据右侧值推断局部变量类型，类似 TS 的类型推断。
        var city = "Shanghai";  // 推断为 String
        var years = 6;          // 推断为 int

        System.out.println("city = " + city);
        System.out.println("years = " + years);
        // city = 123;          // 报错：city 已被推断为 String，不能再赋 int（和 TS 推断一致）

        // ========== 3. final 关键字：只能赋值一次（对应 TS 的 const） ==========
        final String company = "ABC";   // 赋值后不可再重新赋值
        // company = "XYZ";             // 取消注释会编译报错：cannot assign a value to final variable

        System.out.println("company = " + company);

        // ========== 4. 八种基本类型逐个演示 ==========
        // 4 个整数类型
        byte smallNum = 100;             // 8 位
        short midNum = 30000;            // 16 位
        int bigNum = 2000000000;         // 32 位，最常用
        long hugeNum = 9000000000L;      // 64 位，字面量必须加 L

        // 2 个浮点类型
        float pi = 3.14F;                // 32 位，字面量必须加 F（否则默认当 double）
        double precise = 3.1415926535;   // 64 位，最常用，小数默认就是 double

        // 1 个布尔类型
        boolean isActive = true;         // 只能 true/false，不能写 0/1

        // 1 个字符类型（单字符用单引号）
        char gender = 'M';

        System.out.println("byte = " + smallNum);
        System.out.println("short = " + midNum);
        System.out.println("int = " + bigNum);
        System.out.println("long = " + hugeNum);
        System.out.println("float = " + pi);
        System.out.println("double = " + precise);
        System.out.println("boolean = " + isActive);
        System.out.println("char = " + gender);

        // String 是引用类型（类），不是基本类型，用双引号存一串字符
        String greeting = "你好，Java";
        System.out.println("String = " + greeting);
    }
}

