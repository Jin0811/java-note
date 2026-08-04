package jdbc;

/*
  ===== SQL 注入风险 =====

  不要把用户输入直接拼进 SQL 字符串。
  如果 name 是 "' or '1'='1"，拼接出来的 SQL 语义会被篡改。

  正确方向：使用 PreparedStatement，把用户输入当作参数，而不是 SQL 代码。
*/

public class SqlInjectionDemo {
    public static void main(String[] args) {
        String inputName = "' or '1'='1";

        String unsafeSql = "select * from users where name = '" + inputName + "'";
        String safeSql = "select * from users where name = ?";

        System.out.println("unsafeSql = " + unsafeSql);
        System.out.println("safeSql = " + safeSql);
        System.out.println("参数值单独传给 PreparedStatement.setString(1, inputName)");
    }
}
