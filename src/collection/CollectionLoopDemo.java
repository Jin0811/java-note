package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionLoopDemo {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("JavaScript");
        skills.add("TypeScript");
        skills.add("Java");

        for (String skill : skills) {
            System.out.println("skill = " + skill);
        }

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Java", 90);
        scores.put("MySQL", 85);
        scores.put("Spring", 88);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " score = " + entry.getValue());
        }
    }
}

