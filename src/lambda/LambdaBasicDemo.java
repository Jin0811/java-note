package lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaBasicDemo {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("JavaScript");
        skills.add("TypeScript");
        skills.add("Java");

        // JS/TS: skills.forEach(skill => console.log(skill));
        // Java: Lambda 写法也使用 ->。
        skills.forEach(skill -> System.out.println("skill = " + skill));
    }
}

