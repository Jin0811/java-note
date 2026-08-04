package quiz.exception;

public class Quiz03ThrowQuestion {
    public static void main(String[] args) {
        try {
            checkAge(16);
            System.out.println("ok");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        /*
         * 问题：
         * 1. checkAge(16) 会发生什么？
         * 调用了checkAge方法，内部判断小于18，会抛出 IllegalArgumentException 错误
         *
         * 2. "ok" 会不会输出？
         * 不会，异常点之后的代码都不会执行
         *
         * 3. throw 和 throws 有什么区别？
         * throw用于抛出错误，throws用于标注一个方法可能抛出错误
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际运行输出：age must be greater than or equal to 18
         *
         * 问题 1：checkAge(16) 会发生什么？
         * 答：checkAge 内部判断 16 < 18 成立，执行
         *     throw new IllegalArgumentException(...)，主动抛出异常。
         *     抛出后方法立即终止，异常沿调用栈向上冒泡，
         *     最终被 main 里的 catch (IllegalArgumentException) 接住，
         *     打印 e.getMessage() = "age must be greater than or equal to 18"。
         *
         * 问题 2："ok" 会不会输出？
         * 答：不会。
         *     checkAge(16) 一抛异常，try 块里它之后的代码全部跳过，
         *     System.out.println("ok") 根本没执行到，控制流直接跳到 catch。
         *     （若想验证，把 16 改成 20：不抛异常，"ok" 和后续都正常输出。）
         *
         * 问题 3：throw 和 throws 有什么区别？
         * 答：两者都和异常有关，但位置和作用完全不同：
         *     throw  —— 【动作】写在方法体里，真正抛出一个异常对象。
         *              后面跟"对象"：throw new IllegalArgumentException("...");
         *     throws —— 【声明】写在方法签名上，声明"本方法可能抛哪些异常"，
         *              让调用者知情/处理。后面跟"类型"，可多个：
         *              void read() throws IOException, SQLException {...}
         *     记忆口诀：throw 抛"对象"（在体内），throws 声明"类型"（在签名）。
         *     补充：throws 只对"受检异常"是强制的；
         *       IllegalArgumentException 这类运行时异常不写 throws 也合法（本题就是）。
         */
    }

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("age must be greater than or equal to 18");
        }
    }
}

