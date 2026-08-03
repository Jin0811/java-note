package exception;

public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            createOrder(0);
        } catch (BusinessException e) {
            System.out.println("业务异常 code = " + e.getCode());
            System.out.println("业务异常 message = " + e.getMessage());
        }
    }

    static void createOrder(int stock) {
        if (stock <= 0) {
            throw new BusinessException("OUT_OF_STOCK", "库存不足，无法创建订单");
        }
        System.out.println("订单创建成功");
    }
}

class BusinessException extends RuntimeException {
    private String code;

    BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

