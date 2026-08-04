package quiz.collection;

import java.util.HashMap;
import java.util.Map;

public class Quiz02HashMapQuestion {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Java", 80);
        scores.put("Java", 90);
        scores.put("MySQL", 85);

        System.out.println(scores.get("Java"));
        System.out.println(scores.containsKey("Spring"));
        System.out.println(scores.size());

        /*
         * 问题：
         * 1. 重复 put 同一个 key 会发生什么？
         * 后续的同名key会覆盖之前的，相当于进行了修改
         *
         * 2. containsKey 和 get 的区别是什么？
         * containsKey 是判断map当中是否存在指定的key
         * get 是根据指定key获取对应的值
         *
         * 3. HashMap 的遍历方式有哪些？
         * for (Map.Entry<String, Integer> entry : scores.entrySet()) {}
         * for (String key : scores.keySet()) {}
         * for (Integer value : scores.values()) {}
         * scores.forEach((key, value) -> System.out.println(key + " score = " + value));
         */

        /*
         * ========== 标准答案 ==========
         *
         * 各输出的预期结果：
         * scores.get("Java")            -> 90     （第二次 put 覆盖了 80）
         * scores.containsKey("Spring")  -> false  （从没放过 Spring）
         * scores.size()                 -> 2      （Java、MySQL 两个 key）
         *
         * 问题 1：重复 put 同一个 key 会发生什么？
         * 答：新值覆盖旧值，相当于"修改"——Map 里一个 key 只对应一个值。
         *     scores.put("Java", 90) 之后，"Java" 的值从 80 变成 90。
         *     补充：put 的返回值是"旧值"（这里是 80），
         *       键不存在时返回 null——可以用这个特性判断是不是新增。
         *
         * 问题 2：containsKey 和 get 的区别是什么？
         * 答：containsKey(key) 判断"键是否存在"，返回 boolean；
         *     get(key) 按键取值，返回对应的 value，键不存在时返回 null。
         *     为什么两个都要存在——get 返回 null 有歧义：
         *       可能是 key 不存在，也可能是 value 本来就存了 null。
         *     想区分这两种情况，就必须先用 containsKey 判断。
         *
         * 问题 3：HashMap 的遍历方式有哪些？
         * 答：四种（你列全了）：
         *     1. entrySet()：取键值对 Entry，一次循环同时拿 key 和 value（推荐，
         *        避免 keySet + get 的二次哈希查找）。
         *     2. keySet()：只遍历 key，需要值时再 get(key)。
         *     3. values()：只遍历 value，不关心 key。
         *     4. forEach((key, value) -> ...)：Java 8+ lambda 写法，最简洁。
         *     注意：HashMap 遍历出来的顺序不保证和插入顺序一致（无序），
         *       需要顺序用 LinkedHashMap。
         */
    }
}

