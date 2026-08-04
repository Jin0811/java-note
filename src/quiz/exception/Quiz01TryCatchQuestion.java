package quiz.exception;

public class Quiz01TryCatchQuestion {
    public static void main(String[] args) {
        try {
            int number = Integer.parseInt("abc");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("catch");
        }

        System.out.println("end");

        /*
         * 问题：
         * 1. 代码会不会崩溃？
         * 不会崩溃，因为使用了try catch
         *
         * 2. 控制台会输出哪些内容？
         * catch end
         *
         * 3. catch 中的 e 代表什么？
         * 代表错误实例，类型为NumberFormatException，从其中可以获取到message
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：代码会不会崩溃？
         * 答：不会崩溃。
         *     Integer.parseInt("abc") 会抛 NumberFormatException，
         *     但被 catch (NumberFormatException e) 精确接住并处理了，
         *     异常被"消化"，程序继续往下走。
         *     对比：如果没有 try-catch，异常会一路抛到 JVM，
         *     打印红色堆栈、程序终止——那才叫"崩溃"。
         *
         * 问题 2：控制台会输出哪些内容？
         * 答：先输出 catch，再输出 end。
         *     执行流程：
         *       parseInt("abc") 抛异常 → number 的打印被跳过（根本没执行到）
         *       → 进入 catch，打印 "catch"
         *       → try-catch 结束，继续执行后面的 println("end")。
         *     注意：try 里抛异常点之后的代码全部跳过，
         *       但 try-catch 之后的代码照常执行——这正是"程序没崩"的体现。
         *
         * 问题 3：catch 中的 e 代表什么？
         * 答：e 是"被捕获的那个异常对象"（类型为 NumberFormatException）。
         *     JVM 抛异常时会创建一个异常实例，catch 把它接进变量 e，
         *     之后可以读取它的信息：
         *       e.getMessage()    具体原因，如 For input string: "abc"
         *       e.getClass()      异常的实际类型
         *       e.printStackTrace() 完整堆栈（定位异常发生的位置）
         *     这也是为什么 catch 要写成 (异常类型 变量名) 的形式。
         */
    }
}

