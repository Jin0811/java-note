package lambda;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Ben");
        names.add("Cindy");

        // names.forEach(name -> System.out.println(name));
        // 方法引用是 Lambda 的简化写法。
        names.forEach(System.out::println);
    }
}

