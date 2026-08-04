package quiz.collection;

import java.util.HashSet;
import java.util.Set;

public class Quiz03HashSetQuestion {
    public static void main(String[] args) {
        Set<String> tags = new HashSet<>();
        tags.add("java");
        tags.add("spring");
        tags.add("java");

        System.out.println(tags);
        System.out.println(tags.size());

        /*
         * 问题：
         * 1. 为什么 size 不是 3？
         * HashSet不允许重复的元素，会自动去重
         *
         * 2. HashSet 是否保证元素顺序？
         * 不保证元素顺序，如果想要保证元素顺序，需要用LinkedHashSet
         *
         * 3. 什么场景适合使用 Set？
         * 不重复，也不关心顺序的时候
         */

        /*
         * ========== 标准答案 ==========
         *
         * 预期输出：
         * [java, spring]    ← 去重后只剩两个，顺序不保证
         * 2                 ← 不是 3：重复的 "java" 被自动忽略
         *
         * 问题 1：为什么 size 不是 3？
         * 答：因为 add 了两次 "java"，而 Set 不允许重复元素，
         *     第二次 add("java") 被静默忽略（不会报错），所以只剩 java、spring 两个。
         *     补充：add 的返回值是 boolean——true 表示成功加入，
         *       false 表示"因重复没加进去"，可以用它检测重复。
         *
         * 问题 2：HashSet 是否保证元素顺序？
         * 答：不保证。元素按哈希值分散存储，遍历出来的顺序和插入顺序无关，
         *     且可能"看起来是乱的"。
         *     需要保持插入顺序就用 LinkedHashSet（HashSet + 链表记录顺序）。
         *
         * 问题 3：什么场景适合使用 Set？
         * 答：核心诉求就是两点：元素不重复、且不需要顺序（或顺序无所谓）。
         *     典型场景：
         *       · 去重：把带重复数据的 List 转成 Set 一键去重
         *       · 快速判断"是否存在"：contains 是 O(1)，比 List 的 O(n) 快
         *         （如判断用户是否已领取过优惠券、标签是否已存在）
         *     反之：要重复元素用 List；要顺序用 LinkedHashSet；
         *       要按键值存取用 Map。
         */
    }
}

