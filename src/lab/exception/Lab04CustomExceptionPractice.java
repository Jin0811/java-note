package lab.exception;

public class Lab04CustomExceptionPractice {
    /*
     * 练习目标：自定义业务异常。
     *
     * 业务设计：
     * 1. totalStock 是商品/系统持有的"总库存"状态，不由调用者传入。
     * 2. createOrder 接收"订单数量"，用订单数量和总库存比较。
     * 3. 订单数量超过总库存 -> 库存不足，抛出 OrderException。
     * 4. main 中捕获异常并输出 code 和 message。
     */

    // 总库存：商品/系统自身持有的"状态"，不由调用者每次传入。
    public static int totalStock = 18;

    public static void main(String[] args) {
        try {
            createOrder(20);   // 买 20 超过库存 18 → 触发"库存不足"
        } catch (OrderException e) {
            System.out.println("code = " + e.getCode() + ", message = " + e.getMessage());
        }
    }

    // 参数是"订单数量"，拿它和总库存比较，语义就顺了。
    static void createOrder(int orderQuantity) {
        if (orderQuantity > totalStock) {
            throw new OrderException("100", "库存不足，剩余库存=" + totalStock + ", 欲购=" + orderQuantity);
        }
        System.out.println("订单创建成功，购买 " + orderQuantity + " 件");
    }
}

class OrderException extends RuntimeException {
    private String code;

    OrderException(String code, String message) {
        // 调用父类构造方法保存 message，并保存 code。
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

