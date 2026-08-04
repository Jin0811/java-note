package quiz.oop;

public class Quiz02ConstructorQuestion {
    public static void main(String[] args) {
        QuizProduct product = new QuizProduct("Keyboard", 299);
        product.printInfo();

        /*
         * 问题：
         * 1. 构造方法什么时候执行？
         * 在实例化对象的时候执行
         *
         * 2. this.name = name 中两个 name 分别指什么？
         * this.name 这里是实例对象上的name属性
         * name 是 QuizProduct 构造函数的参数
         *
         * 3. 如果删除构造方法，还能用当前方式 new 对象吗？
         * 不能，没有写构造函数的话，会默认添加一个无参构造函数，不过name和price就不能被初始化赋值了
         * 当前是有参数的，编译会报错，去除之后，只能用无参数的形式
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际运行输出：Keyboard / 299.0
         *
         * 问题 1：构造方法什么时候执行？
         * 答：new 实例化对象的那一刻执行。
         *     精确时机：分配堆内存 → 字段填默认值 → 【执行构造方法】→ 返回引用。
         *     构造方法是对象"出生"时第一段被执行的代码，
         *     所以负责初始化字段、保证对象一出生状态就合法。
         *
         * 问题 2：this.name = name 中两个 name 分别指什么？
         * 答：this.name —— 实例字段（对象的属性）；
         *     name     —— 构造方法的形参（调用时传进来的值）。
         *     两者重名产生"遮蔽"，必须用 this. 区分，否则写成 name = name
         *     就是"参数赋给参数自己"，字段永远没被赋值——this 在这里不可省略。
         *
         * 问题 3：如果删除构造方法，还能用当前方式 new 对象吗？
         * 答：不能（注意题目问的是"当前方式" = 带参调用）。
         *     删掉自定义构造方法后，编译器只提供【无参】构造方法，
         *     new QuizProduct("Keyboard", 299) 会编译报错：找不到匹配的构造方法。
         *     此时只有 new QuizProduct()（不带参）能用，
         *     且字段保持默认值（name = null，price = 0.0），
         *     需要 product.name = "..." 手动补赋值——对象出生时是"空壳"。
         *     呼应 ConstructorDemo 的规则：默认无参构造只在
         *     "一个构造方法都没写"时才存在，写了任意一个它就消失。
         */
    }
}

class QuizProduct {
    String name;
    double price;

    QuizProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void printInfo() {
        System.out.println(name + " / " + price);
    }
}

