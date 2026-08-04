package lab.exception;

public class Lab03ThrowPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：主动抛出异常。
         *
         * TODO:
         * 1. 调用 register 方法。
         * 2. 传入不同 age 观察结果。
         * 3. 使用 try / catch 捕获 IllegalArgumentException。
         */
        try {
            register("张三", 16);
        } catch (IllegalArgumentException e) {
            System.out.println("错误：" + e.getMessage());
        }
    }

    static void register(String name, int age) {
        // TODO: 如果 age < 18，抛出 IllegalArgumentException。
        // TODO: 否则输出注册成功。
        if (age < 18) {
            throw new IllegalArgumentException("年龄需要>=18");
        }
        System.out.println("注册成功");
    }
}

