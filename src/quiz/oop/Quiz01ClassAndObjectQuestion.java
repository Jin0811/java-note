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
         * 2. user.name 和 user.age 属于类还是对象？
         * 3. sayHello 方法里为什么可以直接访问 name？
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

