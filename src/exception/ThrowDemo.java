package exception;

public class ThrowDemo {
    public static void main(String[] args) {
        try {
            register("Alex", 16);
        } catch (IllegalArgumentException e) {
            System.out.println("注册失败：" + e.getMessage());
        }
    }

    static void register(String name, int age) {
        if (age < 18) {
            throw new IllegalArgumentException(name + " 未满 18 岁");
        }
        System.out.println(name + " 注册成功");
    }
}

