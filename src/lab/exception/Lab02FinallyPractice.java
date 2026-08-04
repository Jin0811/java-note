package lab.exception;

public class Lab02FinallyPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：finally 的执行时机。
         *
         * TODO:
         * 1. 在 try 中执行一个可能出错的除法。
         * 2. 在 catch 中输出错误提示。
         * 3. 在 finally 中输出 "释放资源"。
         * 4. 修改除数为 0 和非 0，观察 finally 是否执行。
         */
        try {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("错误：" + e.getMessage());
        } finally {
            System.out.println("释放资源");
        }
    }
}

