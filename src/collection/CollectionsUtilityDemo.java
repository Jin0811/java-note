package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilityDemo {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>();
        scores.add(86);
        scores.add(100);
        scores.add(72);
        scores.add(95);

        Collections.sort(scores);
        System.out.println("sorted = " + scores);

        Collections.reverse(scores);
        System.out.println("reversed = " + scores);

        System.out.println("max = " + Collections.max(scores));
        System.out.println("min = " + Collections.min(scores));
    }
}

