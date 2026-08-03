package lambda;

import java.util.ArrayList;
import java.util.List;

public class StreamFilterMapDemo {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("JavaScript");
        skills.add("TypeScript");
        skills.add("Java");
        skills.add("Spring");

        skills.stream()
                .filter(skill -> skill.length() > 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}

