package quiz.basic;

public class Quiz06MethodQuestion {
    public static void main(String[] args) {
        /*
         * 题目 6：先判断每个方法调用的返回结果，再运行验证。
         */
        System.out.println(add(10, 20));
        System.out.println(isPassed(59));
        System.out.println(isPassed(60));
        System.out.println(buildMessage("Alex", "Java"));

        /*
         * 问题：
         * 1. add 方法的返回值类型是什么？
         * int类型
         *
         * 2. isPassed 方法为什么适合返回 boolean？
         * isPassed内部直接返回了一个判断，这个判断会返回一个布尔值
         *
         * 3. buildMessage 方法中的参数顺序能随便换吗？
         * 不能随便换，参数顺序错误的话，后面返回的文本也是错误的
         */

        /*
         * ========== 标准答案 ==========
         *
         * 各方法调用的预期输出：
         * add(10, 20)                   -> 30
         * isPassed(59)                  -> false   （59 >= 60 为 false）
         * isPassed(60)                  -> true    （边界值：>= 包含 60，刚好通过）
         * buildMessage("Alex", "Java")  -> Alex is learning Java
         *
         * 问题 1：add 方法的返回值类型是什么？
         * 答：int。方法签名里方法名前面的类型就是返回值类型：
         *     static int add(int a, int b) —— static 后面的 int。
         *     方法体内 return a + b 返回的值必须能匹配这个类型。
         *     （顺带回顾：void 表示没有返回值）
         *
         * 问题 2：isPassed 方法为什么适合返回 boolean？
         * 答：它回答的是一个"是/否问题"（及格了吗？），布尔值就是最自然的载体。
         *     而且比较表达式 score >= 60 本身求值结果就是 true/false，
         *     可以直接 return，不需要写 if/else：
         *       return score >= 60;                              // ✅ 简洁
         *       if (score >= 60) { return true; } else { return false; }  // ❌ 啰嗦
         *     命名惯例：返回 boolean 的方法通常以 is / has / can 开头，
         *     如 isPassed、hasRole、canEdit，调用处读起来就是一句话。
         *
         * 问题 3：buildMessage 方法中的参数顺序能随便换吗？
         * 答：不能。参数按"位置"匹配：定义是 (name, skill)，
         *     如果调用写成 buildMessage("Java", "Alex")，
         *     输出会变成 "Java is learning Alex"——语义完全反了。
         *     ⚠️ 进阶坑：两个参数类型相同（String, String）时，
         *       编译器【完全发现不了】顺序写反——编译照常通过，运行时结果才是错的。
         *       如果参数类型不同（如 String, int），换序会直接编译报错，反而安全。
         *       所以"同类型参数连排"的方法是调用时最需要仔细看的地方。
         */
    }

    static int add(int a, int b) {
        return a + b;
    }

    static boolean isPassed(int score) {
        return score >= 60;
    }

    static String buildMessage(String name, String skill) {
        return name + " is learning " + skill;
    }
}

