package lab.exception;

public class Lab04CustomExceptionPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：自定义业务异常。
         *
         * TODO:
         * 1. 补全 OrderException。
         * 2. 在 createOrder 中 stock <= 0 时抛出 OrderException。
         * 3. 在 main 中捕获异常并输出 code 和 message。
         */
    }

    static void createOrder(int stock) {
        // TODO: 库存不足时抛出 OrderException。
    }
}

class OrderException extends RuntimeException {
    private String code;

    OrderException(String code, String message) {
        // TODO: 调用父类构造方法保存 message，并保存 code。
    }

    public String getCode() {
        // TODO: 返回 code。
        return "";
    }
}

