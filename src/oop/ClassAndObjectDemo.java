package oop;

public class ClassAndObjectDemo {
    public static void main(String[] args) {
        // JS/TS: const user = { name: "Alex", age: 28 };
        // Java: 先定义 class，再通过 new 创建对象。
        User user = new User();
        user.name = "Alex";
        user.age = 28;

        user.sayHello();
        System.out.println("user.name = " + user.name);
        System.out.println("user.age = " + user.age);
    }
}

class User {
    String name;
    int age;

    void sayHello() {
        System.out.println("Hello, I am " + name);
    }
}

