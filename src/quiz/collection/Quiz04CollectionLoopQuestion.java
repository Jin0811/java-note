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
         * 2. Integer 和 int 有什么关系？
         * 3. 增强 for 循环适合什么场景？
         */
    }
}

