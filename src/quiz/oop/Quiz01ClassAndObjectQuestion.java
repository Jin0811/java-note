package quiz.oop;

public class Quiz01ClassAndObjectQuestion {
    public static void main(String[] args) {
        /*
         * 题目 1：阅读代码，先判断输出，再运行验证。
         */
        QuizUser user = new QuizUser();
        user.name = "Alex";
        user.age = 28;

        user.sayHello();

        /*
         * 问题：
         * 1. new QuizUser() 做了什么？
         * 创建了一个QuizUser的实例
         *
         * 2. user.name 和 user.age 属于类还是对象？
         * name和age属于对象，因为这个属性不是static的
         *
         * 3. sayHello 方法里为什么可以直接访问 name？
         * sayHello方法没有加static，表明这个方法是非静态的，每个对象都会拥有这个方法
         * 内部可以访问static属性和非static属性
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际运行输出：Alex / 28
         *
         * 问题 1：new QuizUser() 做了什么？
         * 答："创建实例"只是笼统说法，完整过程是 4 步：
         *     1. 在【堆内存】中为对象分配空间；
         *     2. 字段自动初始化为默认值（name -> null，age -> 0）；
         *     3. 执行构造方法（本题没定义构造方法，用的是编译器默认送的无参构造）；
         *     4. 返回对象的引用，赋给变量 user（变量在栈上，对象在堆上）。
         *     所以 user.name = "Alex" 之前，name 其实是 null。
         *
         * 问题 2：user.name 和 user.age 属于类还是对象？
         * 答：属于对象（实例字段）。
         *     不带 static 的字段是"实例字段"：new 出几个对象就有几份，
         *     各自独立——改 user.name 不会影响别的 QuizUser 对象。
         *     对照：加了 static 才是"类字段"，全类共享一份（见 StaticDemo 的 count）。
         *
         * 问题 3：sayHello 方法里为什么可以直接访问 name？
         * 答：核心是"隐式 this"。
         *     sayHello 是实例方法（非 static），实例方法被调用时，
         *     内部总有一个隐含的 this，指向"调用它的那个对象"。
         *     方法里写的 name，实际上是 this.name —— 当前对象自己的字段：
         *       user.sayHello();   // this 就是 user，读的是 user.name
         *     这也解释了 StaticDemo 里"static 方法不能直接访问 name"：
         *       static 方法属于类，调用时可能还没有任何对象，没有 this 可用。
         *     记忆：实例方法有 this，所以实例/静态成员都能碰；
         *           静态方法没 this，只能碰静态成员。
         */
    }
}

class QuizUser {
    String name;
    int age;

    void sayHello() {
        System.out.println(name + " / " + age);
    }
}

