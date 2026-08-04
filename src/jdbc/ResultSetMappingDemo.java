package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
  ===== ResultSet 映射对象 =====

  JDBC 查询结果会放在 ResultSet 里。
  resultSet.next() 移动到下一行，getLong/getString/getInt 按列取值。

  后端项目里通常不会把 ResultSet 直接传到业务层，而是映射成 Entity/DTO 对象。
*/

public class ResultSetMappingDemo {
    public static void main(String[] args) {
        UserRow user = new UserRow(1L, "Alex", 28);

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

    static UserRow mapUser(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        return new UserRow(id, name, age);
    }
}

class UserRow {
    private Long id;
    private String name;
    private int age;

    UserRow(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
