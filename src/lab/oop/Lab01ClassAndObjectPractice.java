package lab.oop;

public class Lab01ClassAndObjectPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：类、对象、字段、方法。
         *
         * TODO:
         * 1. 创建一个 Developer 对象。
         * 2. 给 name、skill、years 三个字段赋值。
         * 3. 调用 introduce 方法输出开发者介绍。
         */
        Developer person1 = new Developer("Tom", "Java", 6);
        person1.introduce();
    }
}

class Developer {
    String name;
    String skill;
    int years;

    Developer(String name, String skill, int years) {
        this.name = name;
        this.skill = skill;
        this.years = years;
    }

    void introduce() {
        // TODO: 输出类似 "Alex has 6 years experience in Vue"。
        System.out.printf("%s has %d years experience in %s%n", name, years, skill);
        System.out.println("introduce 执行完毕");
    }
}

