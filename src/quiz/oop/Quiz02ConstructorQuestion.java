package quiz.oop;

public class Quiz02ConstructorQuestion {
    public static void main(String[] args) {
        QuizProduct product = new QuizProduct("Keyboard", 299);
        product.printInfo();

        /*
         * 问题：
         * 1. 构造方法什么时候执行？
         * 2. this.name = name 中两个 name 分别指什么？
         * 3. 如果删除构造方法，还能用当前方式 new 对象吗？
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

