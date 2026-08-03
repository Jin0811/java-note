package quiz.exception;

public class Quiz04CustomExceptionQuestion {
    public static void main(String[] args) {
        try {
            pay(0);
        } catch (PayException e) {
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        }

        /*
         * 问题：
         * 1. PayException 为什么要继承 RuntimeException？
         * 2. super(message) 的作用是什么？
         * 3. code 和 message 分别适合表达什么？
         */
    }

    static void pay(double amount) {
        if (amount <= 0) {
            throw new PayException("INVALID_AMOUNT", "amount must be greater than 0");
        }
    }
}

class PayException extends RuntimeException {
    private String code;

    PayException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

