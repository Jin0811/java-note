package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/// JDBC Demo 公共工具类。
///
/// 这个类集中放置几组 Demo 都会用到的内容：
/// 1. MySQL 连接地址、用户名和密码读取方式。
/// 2. 打开数据库连接的方法。
/// 3. 创建示例 users 表并初始化少量数据的方法。
/// 4. 统一输出 SQLException 诊断信息的方法。
///
/// 密码可以通过 JVM 参数 java.note.jdbc.password，或环境变量
/// JAVA\_NOTE\_DB\_PASSWORD 传入，避免把真实密码写进业务代码。
public final class JdbcDemoSupport {
    // 连接 URL 的参数用于本机学习场景：指定字符集、时区，并允许本地认证流程使用公钥。
    // 如果部署到生产环境，应根据服务器的 SSL 和安全策略重新配置这些参数。
    private static final String URL = readSetting(
        "java.note.jdbc.url",
        "JAVA_NOTE_JDBC_URL",
        "jdbc:mysql://localhost:3306/java_note"
            + "?useUnicode=true&characterEncoding=UTF-8"
            + "&serverTimezone=Asia/Shanghai"
            + "&useSSL=false&allowPublicKeyRetrieval=true"
    );
    // 默认使用本机 MySQL 初始化时常见的 root 账号，也可以通过环境变量覆盖。
    private static final String USER = readSetting(
        "java.note.jdbc.user",
        "JAVA_NOTE_DB_USER",
        "root"
    );
    // 123456 只是本学习项目的兼容默认值，实际使用时建议配置 JAVA_NOTE_DB_PASSWORD。
    private static final String PASSWORD = readSetting(
        "java.note.jdbc.password",
        "JAVA_NOTE_DB_PASSWORD",
        "123456"
    );

    private JdbcDemoSupport() {
        // 工具类只提供 static 方法，不应该被 new 出来。
    }

    /**
     * 打开一个指向 java_note 数据库的连接。
     * <p>
     * DriverManager 会根据 jdbc:mysql 前缀找到 Maven 引入的 MySQL Connector/J，
     * 再把 URL、用户名和密码交给驱动完成连接。调用方负责关闭返回的 Connection。
     */
    static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 返回当前 Demo 实际使用的 JDBC URL，便于排查连接配置。
     */
    static String getUrl() {
        return URL;
    }

    /**
     * 返回当前 Demo 实际使用的数据库用户名，不输出密码。
     */
    static String getUser() {
        return USER;
    }

    /**
     * 创建所有 JDBC Demo 共用的 users 表，并插入可重复执行的示例数据。
     * <p>
     * IF NOT EXISTS 可以避免表已经存在时执行失败；name 上的 UNIQUE 约束配合
     * ON DUPLICATE KEY UPDATE，可以避免每次运行 Demo 都新增同名数据。
     * 这个方法会执行 DDL 和 INSERT，因此它不只是查询操作。
     */
    static void ensureUsersTable(Connection connection) throws SQLException {
        // DDL：定义 Demo 使用的最小表结构。
        // id 由 MySQL 自动递增，name 作为示例查询条件，age 用于范围过滤。
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS users (
                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(50) NOT NULL UNIQUE,
                age INT NOT NULL
            ) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4
            """;
        try (Statement statement = connection.createStatement()) {
            // Statement 适合执行这里没有外部参数的固定 SQL。
            statement.executeUpdate(createTableSql);
        }
        // DML：使用 PreparedStatement 写入示例数据。
        // 三个 ? 的下标从 1 开始：前两个对应 INSERT，第三个对应 UPDATE。
        String insertSql = """
            INSERT INTO users (name, age)
            VALUES (?, ?)
            ON DUPLICATE KEY UPDATE age = ?
            """;
        try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
            // 每次运行都会检查这三条数据；存在时只同步 age，不会重复插入。
            insertSeed(statement, "Alex", 28);
            insertSeed(statement, "Mina", 24);
            insertSeed(statement, "Kai", 31);
        }
    }

    private static void insertSeed(PreparedStatement statement, String name, int age) throws SQLException {
        // PreparedStatement 的参数位置从 1 开始，而不是从 0 开始。
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setInt(3, age);
        // executeUpdate 用于 INSERT、UPDATE、DELETE 和 DDL 等不返回 ResultSet 的语句。
        statement.executeUpdate();
    }

    /**
     * 输出 JDBC 异常中的三类常用诊断信息。
     * message 通常包含可读的错误原因，SQLState 和 errorCode 便于进一步检索。
     */
    static void printSQLException(SQLException exception) {
        System.err.println("数据库操作失败：" + exception.getMessage());
        System.err.println("SQLState = " + exception.getSQLState());
        System.err.println("errorCode = " + exception.getErrorCode());
    }

    /**
     * 按“JVM 系统属性 -> 环境变量 -> 默认值”的顺序读取配置。
     * <p>
     * 这样既可以在 IDEA 的 VM options 中临时传值，也可以在运行配置中设置环境变量，
     * 同时保留一个适合本地学习的默认配置。
     */
    private static String readSetting(String propertyName, String environmentName, String fallback) {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue != null && !propertyValue.isBlank()) {
            return propertyValue;
        }
        String environmentValue = System.getenv(environmentName);
        if (environmentValue != null && !environmentValue.isBlank()) {
            return environmentValue;
        }
        return fallback;
    }
}
