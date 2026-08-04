package quiz.jdbc;

public class Quiz04ResultSetMappingQuestion {
    public static void main(String[] args) {
        QuizUserRow user = new QuizUserRow(1L, "Alex", 28);

        System.out.println(user.getName());
        System.out.println(user.getAge());

        /*
         * 问题：
         * 1. ResultSet.next() 的作用是什么？
         * 2. getString("name") 中的 name 表示什么？
         * 3. 为什么要把 ResultSet 映射成对象？
         */
    }
}

class QuizUserRow {
    private Long id;
    private String name;
    private int age;

    QuizUserRow(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
