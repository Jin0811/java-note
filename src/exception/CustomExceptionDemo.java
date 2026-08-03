package exception;

/*
  ===== 自定义异常（Custom Exception）=====

  Java 的异常是"类型"——可以自己定义新异常类，catch 时按类型精确捕获。
  这是比 JS 强的地方：JS 基本只有 Error 一种，靠 e.message 字符串区分；
  Java 靠类型 + 字段区分，类型安全、可维护。

  异常的继承体系（决定你要继承谁）：
    Throwable
    ├── Error                 系统级错误（OOM 等），不该捕获
    └── Exception             程序级异常
        ├── RuntimeException  "非受检异常"（unchecked）：不强制 try-catch，
        │                     如 NullPointerException。业务异常通常继承它。
        └── 其它 Exception    "受检异常"（checked）：编译器强制你
                              try-catch 或在方法签名上 throws 声明，
                              如 IOException、SQLException。

  自定义业务异常的三件套（本 demo 的 BusinessException 就是标准模板）：
    1. extends RuntimeException  -> 使用方不被强制 try-catch，灵活
    2. 私有错误码字段 code       -> 机器可读的错误标识，比 message 字符串可靠
    3. super(message) + getter   -> 人可读的提示信息 + 取错误码的入口

  后端典型用法（学 Spring 后落地）：
    业务代码里发现规则不满足就 throw new BusinessException("OUT_OF_STOCK", "...")，
    全局异常处理器（Spring @ExceptionHandler）统一接住，
    转成接口响应 { "code": "OUT_OF_STOCK", "message": "库存不足" } 返给前端。
    —— 整个项目不用到处写 try-catch + if 判断。

  注意区分两个关键字：
    throw e     在方法体里"抛出一个异常对象"（动词）
    throws Xxx  在方法签名上"声明本方法可能抛什么异常"（只对受检异常必须写）
*/

public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            createOrder(0);   // 传 0 触发"库存不足"，createOrder 内部会 throw
        } catch (BusinessException e) {
            // 按类型精确捕获：只接业务异常，其它异常（如 NPE）不会被这里接住
            System.out.println("业务异常 code = " + e.getCode());
            System.out.println("业务异常 message = " + e.getMessage());
        }
    }

    static void createOrder(int stock) {
        if (stock <= 0) {
            // throw：主动抛出异常，方法在这里立即终止，后面的代码不再执行。
            // 因为 BusinessException 是非受检异常，方法签名不需要写 throws。
            throw new BusinessException("OUT_OF_STOCK", "库存不足，无法创建订单");
        }
        System.out.println("订单创建成功");
    }
}

// ===== 自定义业务异常：标准模板 =====
// 继承 RuntimeException => 非受检异常，调用方可以选择不 catch，代码干净。
// （如果 extends Exception 就变成受检异常，所有调用处都被强制 try-catch/throws）
class BusinessException extends RuntimeException {
    private String code;   // 业务错误码：比"读 message 字符串"可靠的机器标识

    BusinessException(String code, String message) {
        super(message);       // message 交给父类存，e.getMessage() 才能读到
        this.code = code;     // code 是自己加的字段，父类没有，所以放自己这
    }

    public String getCode() {
        return code;          // 私有字段 + getter 封装（见 EncapsulationDemo）
    }
}

