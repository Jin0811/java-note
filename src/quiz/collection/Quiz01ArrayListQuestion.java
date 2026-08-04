package quiz.collection;

import java.util.ArrayList;
import java.util.List;

public class Quiz01ArrayListQuestion {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");

        System.out.println(list);
        System.out.println(list.size());

        /*
         * 问题：
         * 1. 最终 list 中有哪些元素？
         * "A" 和 "C"
         *
         * 2. list.size() 输出多少？
         * 2
         *
         * 3. ArrayList 和数组的主要区别是什么？
         * 数组是定长的，不可改变长度的；ArrayList是动态的，不定长度的
         */

        /*
         * ========== 标准答案 ==========
         *
         * 问题 1：最终 list 中有哪些元素？
         * 答：A 和 C。
         *     依次 add A/B/C 得到 [A, B, C]；
         *     remove("B") 是按【值】删除，删掉 B 后剩 [A, C]。
         *     实际打印是 [A, C]（List 重写了 toString，直接打印出内容）。
         *
         * 问题 2：list.size() 输出多少？
         * 答：2。删除 B 之后只剩 A、C 两个元素。
         *     注意集合数个数用 size() 方法，数组才用 .length 属性。
         *
         * 问题 3：ArrayList 和数组的主要区别是什么？
         * 答：数组是【定长】的：创建时长度就固定，之后不能增删元素；
         *     ArrayList 是【动态】的：可以随时 add/remove，容量自动扩容。
         *     补充两点次要区别：
         *       1. 元素类型：数组能存基本类型（int[]）；
         *          ArrayList 只能存引用类型，基本类型要装箱（List<Integer>）。
         *       2. 访问方式：数组用下标语法 arr[0]、长度是 .length 属性；
         *          ArrayList 用方法调用 list.get(0)、长度是 .size() 方法。
         */
    }
}

