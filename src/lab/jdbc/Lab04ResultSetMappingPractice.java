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
    }

    static AccountRow mapAccount(ResultSet resultSet) throws SQLException {
        // TODO: 从 ResultSet 读取 id、username、enabled 并创建 AccountRow。
        return null;
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
