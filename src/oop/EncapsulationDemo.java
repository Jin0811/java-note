package oop;

/*
  ===== 封装（Encapsulation）=====

  封装 = 把"数据"藏起来（private），只开放"受控的操作入口"（public 方法）。
  核心思路：字段私有化，外部不能直接读写，必须通过方法这道"关卡"。

  三步套路：
    1. 字段用 private 修饰            -> 外部拿不到、改不了
    2. 需要"读"的字段提供 getter        -> 对外只读
    3. 需要"改"的地方提供带校验的方法    -> 所有写入都必须经过校验

  好处：
    · 校验/保护状态：非法值（负数、超额取款）在方法入口就被拦下，
      对象状态永远合法（余额不可能变负数）。
    · 控制读写权限：只给 getter 不给 setter，字段对外就是天然只读。
    · 隐藏实现细节：调用方只知道"能存能取"，不关心 balance 内部怎么存，
      以后改实现也不影响外部代码。
    · 降低耦合：字段是类的"私事"，影响范围被锁在类内部。

  类比 TS：相当于用 private / #字段 藏数据，再用 get/set 访问器暴露受控入口。
  区别是 JS 写法更宽松，而 Java 后端把"私有字段 + 方法访问"当成强约定，
  Jackson / JPA / Spring 等框架也都依赖 getter/setter 这套约定。
*/

public class EncapsulationDemo {
    public static void main(String[] args) {
        Account account = new Account("Alex");
        // 外部只能通过这些 public 方法操作账户，不能直接碰 balance。
        account.deposit(1000);
        account.withdraw(300);
        // account.balance = -10000;   // 报错：balance 是 private，外部根本访问不到

        System.out.println("owner = " + account.getOwner());
        System.out.println("balance = " + account.getBalance());
    }
}

class Account {
    // 1. 字段私有化：外部无法直接读写，只能通过下面的方法。
    private String owner;
    private double balance;

    Account(String owner) {
        this.owner = owner;
    }

    // 2. getter：只提供"读"，不提供 setter -> owner / balance 对外只读。
    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // 3. 业务方法 + 校验：所有改动都必须经过这里。
    // 存款金额小于等于 0 直接拒绝，非法值进不了账户。
    public void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        balance += amount;
    }

    // 取款：金额非法（<=0）或超过余额时拒绝，防止出现负余额。
    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return;
        }
        balance -= amount;
    }
}

