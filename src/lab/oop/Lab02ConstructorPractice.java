package lab.oop;

public class Lab02ConstructorPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：构造方法、this、方法重载。
         *
         * TODO:
         * 1. 补全 Course 的两个构造方法。
         * 2. 创建一个带 name 和 price 的课程对象。
         * 3. 创建一个只带 name 的课程对象。
         * 4. 调用 printInfo 方法观察输出。
         */
    }
}

class Course {
    String name;
    double price;

    Course(String name, double price) {
        // TODO: 给字段赋值。
    }

    Course(String name) {
        // TODO: 给字段赋值，price 默认为 0。
    }

    void printInfo() {
        System.out.println(name + " / " + price);
    }
}

