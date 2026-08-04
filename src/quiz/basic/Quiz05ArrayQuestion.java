package quiz.basic;

public class Quiz05ArrayQuestion {
    public static void main(String[] args) {
        /*
         * 题目 5：阅读数组代码，回答问题。
         */
        String[] names = {"Alex", "Ben", "Cindy"};

        System.out.println(names.length);
        System.out.println(names[0]);
        System.out.println(names[names.length - 1]);

        /*
         * 问题：
         * 1. names.length 的值是多少？
         * 3
         *
         * 2. names[0] 输出什么？
         * "Alex"
         *
         * 3. names[names.length - 1] 为什么能拿到最后一个元素？
         * names是数组，数组的长度为3,3-1=2，而数组的下标是从0开始的，0 1 2，所以2就是最后一个元素的下标
         *
         * 4. 如果访问 names[3]，会发生什么？
         * 会编译失败，因为已经超出了数组的下标
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：names.length 的值是多少？
         * 答：3。数组里有 Alex、Ben、Cindy 三个元素。
         *     注意 .length 是"属性"（不带括号），和 String 的 .length() 方法不同。
         *
         * 问题 2：names[0] 输出什么？
         * 答：Alex（println 打印字符串内容本身，不带引号）。
         *     数组下标从 0 开始，所以第 1 个元素是 names[0]。
         *
         * 问题 3：names[names.length - 1] 为什么能拿到最后一个元素？
         * 答：数组长度为 3，但下标从 0 开始，合法下标是 0、1、2。
         *     最后一个下标 = 长度 - 1 = 2。
         *     "下标 = 长度 - 1" 是"拿最后一个元素"的通用写法，对任意长度都成立。
         *
         * 问题 4：如果访问 names[3]，会发生什么？
         * 答：编译通过，但运行时抛出 ArrayIndexOutOfBoundsException
         *     （Index 3 out of bounds for length 3），程序崩溃。
         *     ⚠️ 关键区分：编译器只检查"写法"，不知道运行时的下标值，
         *       所以越界不是编译错误，而是运行时错误。
         *     对比：int age = 28.5 那类"类型不匹配"才是编译期错误，
         *       编译阶段就被拦下。分清编译期 / 运行期是理解 Java 报错的关键。
         *     （这也是为什么 JS 里 arr[3] 返回 undefined 不报错，而 Java 直接抛异常）
         */
    }
}

