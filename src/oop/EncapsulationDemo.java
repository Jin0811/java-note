package oop;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Account account = new Account("Alex");
        account.deposit(1000);
        account.withdraw(300);

        System.out.println("owner = " + account.getOwner());
        System.out.println("balance = " + account.getBalance());
    }
}

class Account {
    private String owner;
    private double balance;

    Account(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return;
        }
        balance -= amount;
    }
}

