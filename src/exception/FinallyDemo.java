package exception;

public class FinallyDemo {
    public static void main(String[] args) {
        try {
            System.out.println("开始执行");
            int result = 10 / 2;
            System.out.println("result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("发生数学异常");
        } finally {
            // finally 通常用于释放资源，比如关闭文件、关闭数据库连接。
            System.out.println("finally 一定会尝试执行");
        }
    }
}

