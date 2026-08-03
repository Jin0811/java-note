package exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        String input = "123a";

        try {
            int number = Integer.parseInt(input);
            System.out.println("number = " + number);
        } catch (NumberFormatException e) {
            System.out.println("转换失败：" + input + " 不是合法数字");
            System.out.println("error message = " + e.getMessage());
        }

        System.out.println("程序继续执行");
    }
}

