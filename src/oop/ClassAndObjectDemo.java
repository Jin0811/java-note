package oop;

import java.util.Arrays;

public class ClassAndObjectDemo {
    public static void main(String[] args) {
        // JS/TS: const user = { name: "Alex", age: 28 };
        // Java: 先定义 class，再通过 new 创建对象。
        User user = new User();
        user.name = "Alex";
        user.age = 28;
        user.hobbies[0] = "篮球";
        user.hobbies[1] = "画画";
        user.hobbies[2] = "游戏";

        user.sayHello();
        System.out.println("user.name = " + user.name);
        System.out.println("user.age = " + user.age);
        System.out.println("user.hobbies = " + Arrays.toString(user.hobbies));
    }
}

class User {
    String name;
    int age;
    String[] hobbies = new String[3];

    void sayHello() {
        System.out.println("Hello, I am " + name);
    }
}

