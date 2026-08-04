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

        /*
         * ========== 标准答案 ==========
         *
         * 实际输出：
         * Alex
         * 28
         *
         * 问题 1：把游标移动到下一行；返回 true 表示当前有数据。
         *
         * 问题 2：表示数据库查询结果里的列名。
         *
         * 问题 3：对象更适合在业务代码中传递和理解。
         *     后端项目通常把数据库行映射成 Entity、DTO 或 VO。
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
