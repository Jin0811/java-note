package lab.exception;

public class Lab01TryCatchPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：try / catch 捕获异常。
         *
         * TODO:
         * 1. 定义 String input = "123a"。
         * 2. 尝试使用 Integer.parseInt(input) 转成 int。
         * 3. 捕获 NumberFormatException。
         * 4. 转换失败时输出友好提示。
         * 5. 在 catch 后输出 "程序继续执行"。
         */

        String input = "123a";
        try {
            int num = Integer.parseInt(input);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("处理数值转换错误：转换失败，请检查您的输入值");
        } catch (Exception e) {
            System.out.println("兜底全部错误");
        }
        System.out.println("程序继续执行");
    }
}

