package quiz.basic;

public class Quiz01VariableQuestion {
    public static void main(String[] args) {
        /*
         * 题目 1：阅读下面的变量声明，回答注释中的问题。
         */
        int age = 28;
        double price = 19.9;
        boolean active = true;
        char level = 'A';
        String name = "Alex";

        System.out.println(name + " / " + age + " / " + price + " / " + active + " / " + level);

        /*
         * 问题：
         * 1. int 和 double 有什么区别？
         * ini是整数，不带小数点，而double是双精度，可以携带小数点
         *
         * 2. char 和 String 有什么区别？
         * char只能存储单个字符串，如"A"一类的，而String可以存储文本
         *
         * 3. 如果把 int age = 28 改成 int age = 28.5，会发生什么？
         * 会编译失败，因为int类型不能存储带有小数点的28.5，应该使用double类型
         *
         * 4. Java 的 String 首字母为什么是大写？
         * 因为String不是一个关键字，而是一个类
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：int 和 double 有什么区别？
         * 答：都是数值类型。int 存整数（32 位，如 28、-5）；
         *     double 存双精度浮点数（64 位，能表示小数，如 19.9）。
         *     补充：int 运算精确；double 有精度问题（0.1 + 0.2 != 0.3），
         *     涉及金额实际开发要用 BigDecimal，不能只用 double。
         *
         * 问题 2：char 和 String 有什么区别？
         * 答：char 是基本类型，只能存【一个字符】，用单引号：char c = 'A';
         *     String 是类（引用类型），可以存一串文本，用双引号：String s = "Alex";
         *     注意："A"（双引号）不是 char，而是"只含一个字符的 String"！
         *
         * 问题 3：如果把 int age = 28 改成 int age = 28.5，会发生什么？
         * 答：编译失败，报错 incompatible types: possible lossy conversion
         *     from double to int。28.5 默认是 double 字面量，
         *     不能赋给 int（会丢小数部分）。
         *     体现 Java 特点：编译期就检查类型，不像 JS 要到运行时。
         *     两种修法：double age = 28.5; 或 int age = (int) 28.5;（强转截断成 28）
         *
         * 问题 4：Java 的 String 首字母为什么是大写？
         * 答：因为 String 不是基本类型、也不是关键字，而是一个类（java.lang.String）。
         *     Java 命名规范：类名用大驼峰 UpperCamelCase（String、ArrayList、HashMap）；
         *     基本类型/关键字全小写（int、double、boolean、char）。
         *     速记：首字母小写 = 基本类型，首字母大写 = 类（引用类型）。
         */
    }
}

