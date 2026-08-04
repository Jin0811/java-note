package quiz.generic;

public class Quiz01GenericClassQuestion {
    public static void main(String[] args) {
        Box<String> textBox = new Box<>("Java");
        Box<Integer> numberBox = new Box<>(100);

        System.out.println(textBox.getValue());
        System.out.println(numberBox.getValue());

        /*
         * 问题：
         * 1. Box<String> 中的 T 最终是什么类型？
         * 2. numberBox.getValue() 的返回值类型是什么？
         * 3. 为什么泛型比 Object 更安全？
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * Java
         * 100
         *
         * 问题 1：Box<String> 中的 T 最终是什么类型？
         * 答：T 被替换成 String。这个对象里的 value 字段、构造参数、
         *     getValue 返回值，都按 String 来检查。
         *
         * 问题 2：numberBox.getValue() 的返回值类型是什么？
         * 答：Integer。因为 numberBox 的声明类型是 Box<Integer>。
         *
         * 问题 3：为什么泛型比 Object 更安全？
         * 答：泛型把类型检查提前到编译期。使用 Object 时取值后常常要强转，
         *     类型写错可能运行时才抛 ClassCastException；泛型能更早发现问题。
         */
    }
}

class Box<T> {
    private T value;

    Box(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }
}
