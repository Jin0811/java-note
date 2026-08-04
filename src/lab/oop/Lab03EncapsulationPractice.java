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
        UserProfile user1 = new UserProfile();
        user1.setName("张三");
        user1.setAge(18);

        System.out.println(user1.getName());
        System.out.println(user1.getAge());
    }
}

class UserProfile {
    private String name;
    private int age;

    public String getName() {
        // TODO: 返回 name。
        return this.name;
    }

    public void setName(String name) {
        // TODO: 设置 name。
        this.name = name;
    }

    public int getAge() {
        // TODO: 返回 age。
        return this.age;
    }

    public void setAge(int age) {
        // TODO: 只有 age >= 0 时才设置。
        if (age >= 0) {
            this.age = age;
        }
    }
}

