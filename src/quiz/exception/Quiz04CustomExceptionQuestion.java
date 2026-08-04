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
         * RuntimeException是全部错误的基类，继承这个基类可以获取很多方法
         *
         * 2. super(message) 的作用是什么？
         * 调用父类的构造函数，保存message属性
         *
         * 3. code 和 message 分别适合表达什么？
         * code是自定义的业务码，如1001,1002，适合作为业务错误枚举值，方便开发人员排查问题
         * message当中存放的是具体的错误提示，如：库存不足、年龄不符合等，适合展示给用户
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际运行输出（pay(0) 触发异常）：
         * INVALID_AMOUNT
         * amount must be greater than 0
         *
         * 问题 1：PayException 为什么要继承 RuntimeException？
         * 答：为了成为"非受检异常"（unchecked）——这才是核心原因。
         *     继承 RuntimeException 后：调用方不被强制 try-catch，
         *     方法签名也不用写 throws，业务代码可以随手 throw，
         *     异常交给上层的 try-catch 或全局异常处理器统一处理。
         *     反面：如果 extends Exception（受检异常），
         *     每一处调用都必须 try-catch 或继续 throws，代码立刻臃肿。
         *     ⚠️ 顺带纠偏：RuntimeException 不是"全部错误的基类"，
         *       所有异常的根基类是 Throwable；继承也不是为了"获取方法"。
         *
         * 问题 2：super(message) 的作用是什么？
         * 答：调用父类（RuntimeException → ... → Throwable）的构造方法，
         *     把 message 存进 Throwable 内部的 message 字段。
         *     之后 e.getMessage() 才能读到它。
         *     如果不调 super(message)，getMessage() 会返回 null，
         *     你自定义的异常就丢失了错误描述。
         *
         * 问题 3：code 和 message 分别适合表达什么？
         * 答：code —— 机器可读的"业务错误标识"（如 INVALID_AMOUNT、1001）：
         *       · 给【程序】用的：前端按 code 分支处理、监控系统按 code 统计告警、
         *         日志系统按 code 检索，稳定不变（改文案不影响 code）；
         *       · 通常做成枚举统一管理。
         *     message —— 人可读的"错误描述"（如"金额必须大于 0"）：
         *       · 给【人】看的，直接展示给用户或开发人员；
         *       · 文案可以随时调整，程序逻辑不依赖它。
         *     一句话：code 给机器判断，message 给人阅读。
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

