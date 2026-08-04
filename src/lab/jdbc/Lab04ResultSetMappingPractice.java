package lab.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Lab04ResultSetMappingPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：把数据库行映射成 Java 对象。
         *
         * TODO:
         * 1. 创建 AccountRow 对象模拟数据库查询结果。
         * 2. 输出 id、username、enabled。
         * 3. 阅读 mapAccount 方法，理解 ResultSet 如何取列。
         */

        AccountRow account = new AccountRow(1L, "alex", true);

        System.out.println(account.getId());
        System.out.println(account.getUsername());
        System.out.println(account.isEnabled());
    }

    static AccountRow mapAccount(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String username = resultSet.getString("username");
        boolean enabled = resultSet.getBoolean("enabled");
        return new AccountRow(id, username, enabled);
    }
}

class AccountRow {
    private Long id;
    private String username;
    private boolean enabled;

    AccountRow(Long id, String username, boolean enabled) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
