package quiz.collection;

import java.util.ArrayList;
import java.util.List;

public class Quiz04CollectionLoopQuestion {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>();
        scores.add(70);
        scores.add(85);
        scores.add(40);
        scores.add(100);

        int count = 0;
        for (Integer score : scores) {
            if (score >= 60) {
                count++;
            }
        }

        System.out.println("count = " + count);

        /*
         * 问题：
         * 1. count 最终是多少？
         * count的值为3，是遍历查找列表当中大于等于60的数据
         *
         * 2. Integer 和 int 有什么关系？
         * int是基本数据类型，Integer是int的包装，是引用数据类型，数组当中可以放int和Integer，列表当中只能放Integer，不能放int
         *
         * 3. 增强 for 循环适合什么场景？
         * 只关心值，不关心下标的场景
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：count 最终是多少？
         * 答：3。
         *     逐个判断 score >= 60：70 ✅、85 ✅、40 ❌、100 ✅，命中 3 个。
         *     增强 for 依次取出每个元素，count 累加到 3。
         *
         * 问题 2：Integer 和 int 有什么关系？
         * 答：int 是基本类型（存值本身、效率高、不能为 null）；
         *     Integer 是 int 的包装类，是引用类型（对象，可以为 null）。
         *     集合（List/Set/Map）只能存引用类型，所以 List<Integer> 而不能 List<int>；
         *     数组两种都行：int[]（更省内存）或 Integer[]。
         *     补充——自动装箱/拆箱：本题 score 是 Integer，
         *       score >= 60 会自动拆箱成 int 参与比较，编译器帮你转换，
         *       平时写代码几乎无感。⚠️ 但拆箱遇到 null 会抛 NPE，
         *       这是后端取包装类字段时的常见坑。
         *
         * 问题 3：增强 for 循环适合什么场景？
         * 答：只关心"每个元素本身"、不需要下标的场景（纯遍历/只读处理）。
         *     数组和 List/Set 都能用，写法统一、不用手写下标边界。
         *     补充两个限制：
         *       1. 拿不到下标：需要 i 的场景（如跳过第 0 个）要用普通 for；
         *       2. 遍历时不能删除原集合元素：for 里调 list.remove(...)
         *          会抛 ConcurrentModificationException，删除要用 Iterator
         *          或 removeIf。
         */
    }
}

