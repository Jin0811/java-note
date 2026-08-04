package quiz.basic;

public class Quiz03IfElseQuestion {
    public static void main(String[] args) {
        /*
         * 题目 3：修改 score 的值，观察不同分支如何执行。
         */
        int score = 80;

        if (score > 80) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 60) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }

        /*
         * 问题：
         * 1. score = 80 时输出什么？
         * B
         *
         * 2. 如果第一个条件改成 score >= 80，输出会变化吗？
         * 会输出A
         *
         * 3. if / else if 的判断顺序重要吗？
         * 重要，要按顺序来，不然可能进入错误的分支，后续的都无法被判断了
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：score = 80 时输出什么？
         * 答：B。
         *     第一个条件 score > 80 即 80 > 80 为 false；
         *     第二个条件 score >= 80 即 80 >= 80 为 true → 输出 B，
         *     后面的分支直接跳过，不再判断。
         *
         * 问题 2：如果第一个条件改成 score >= 80，输出会变化吗？
         * 答：会变，输出 A。
         *     改后第一个条件 80 >= 80 为 true，立刻输出 A，
         *     else if 链在第一个分支就结束，后面的分支都不执行。
         *     本题正是演示：同一个值（80），只因条件写法不同（> vs >=），
         *     就会落进不同分支。
         *
         * 问题 3：if / else if 的判断顺序重要吗？
         * 答：非常重要。
         *     if / else if 链从上到下判断，一旦某个分支命中，
         *     后面所有分支直接跳过（即使后面的条件也成立）。
         *     所以条件的顺序必须保证"从大到小、逐级收窄"。
         *     反例：若把 score >= 60 写在最前面，
         *       所有 60 及以上都会被它"截胡"，A、B 永远输出不了。
         */
    }
}

