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

    // 构造方法没有返回值，方法名必须和类名一致。
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Java 支持方法重载：方法名相同，参数列表不同。
    Product(String name) {
        this.name = name;
        this.price = 0;
    }

    void printInfo() {
        System.out.println(name + " price = " + price);
    }
}

