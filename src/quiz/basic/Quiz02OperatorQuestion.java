package quiz.basic;

public class Quiz02OperatorQuestion {
    public static void main(String[] args) {
        /*
         * 题目 2：先不要运行，先判断每一行输出结果，再运行验证。
         *
         * 输出的结果为：
         * 3
         * 3.333333 循环
         * 1
         * true
         * false
         * true
         */
        int a = 10;
        int b = 3;

        System.out.println(a / b);
        System.out.println(a * 1.0 / b);
        System.out.println(a % b);
        System.out.println(a > b);
        System.out.println(a > 5 && b > 5);
        System.out.println(a > 5 || b > 5);

        /*
         * 问题：
         * 1. a / b 为什么不是小数？
         * 因为默认情况下，int和int进行运算，输出的是int类型，但是可以使用(double)来强制转换为double类型
         *
         * 2. a * 1.0 / b 的结果类型是什么？
         * 是 3.333333 循环，int和double进行运算的时候，结果会转换为double
         *
         * 3. && 和 || 的区别是什么？
         * &&是并且的意思，只有两个判断都成立，才返回true；||是或者的意思，只要有一个判断成立就返回true
         */

        /*
         * ========== 标准答案 ==========
         *
         * 各行输出预测：
         * a / b          -> 3                    （int / int 整数除法，截断小数）
         * a * 1.0 / b    -> 3.3333333333333335   （10.0 / 3，结果是 double）
         * a % b          -> 1                    （10 除以 3 余 1）
         * a > b          -> true
         * a > 5 && b > 5 -> false                （true && false = false）
         * a > 5 || b > 5 -> true                 （true || false = true）
         *
         * 问题 1：a / b 为什么不是小数？
         * 答：/ 两边都是 int 时执行"整数除法"，结果也是 int，小数部分直接截断
         *     （10 / 3 = 3，不是 3.33）。想要小数结果，必须让至少一边变成小数：
         *       a * 1.0 / b、(double) a / b、a / (double) b 都可以。
         *     ⚠️ 注意位置：写成 (double)(a / b) 是【先算完整数除法再转】，
         *       只会得到 3.0，达不到目的！
         *
         * 问题 2：a * 1.0 / b 的结果类型是什么？
         * 答：类型是 double，值是 3.3333333333333335。
         *     运算从左往右：a * 1.0 先发生（int 遇到 double 自动提升），得到 10.0；
         *     接着 10.0 / 3，仍然是 double 除法。
         *     规则：int 和 double 混合运算，int 自动提升为 double，结果也是 double。
         *
         * 问题 3：&& 和 || 的区别是什么？
         * 答：&& 是逻辑与：两边都为 true 才返回 true（一假即假）；
         *     || 是逻辑或：至少一边为 true 就返回 true（一真即真）。
         *     补充——短路特性（很重要）：
         *       && 左边为 false 时，右边直接不执行；
         *       || 左边为 true 时，右边直接不执行。
         *     实战常用写法：user != null && user.getAge() > 18
         *       靠短路保证 user 为 null 时不会执行 getAge()，避免 NPE。
         */
    }
}

