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
         * 2. list.size() 输出多少？
         * 3. ArrayList 和数组的主要区别是什么？
         */
    }
}

