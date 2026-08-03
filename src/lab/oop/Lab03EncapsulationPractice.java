package lab.oop;

public class Lab03EncapsulationPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：private、getter、setter、封装业务规则。
         *
         * TODO:
         * 1. 创建 UserProfile 对象。
         * 2. 通过 setter 设置 name 和 age。
         * 3. age 小于 0 时不允许设置成功。
         * 4. 通过 getter 输出 name 和 age。
         */
    }
}

class UserProfile {
    private String name;
    private int age;

    public String getName() {
        // TODO: 返回 name。
        return "";
    }

    public void setName(String name) {
        // TODO: 设置 name。
    }

    public int getAge() {
        // TODO: 返回 age。
        return 0;
    }

    public void setAge(int age) {
        // TODO: 只有 age >= 0 时才设置。
    }
}

