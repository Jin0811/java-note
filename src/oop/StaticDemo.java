package oop;

public class StaticDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alex");
        Employee e2 = new Employee("Ben");

        e1.printInfo();
        e2.printInfo();

        System.out.println("Employee.count = " + Employee.count);
        System.out.println("Company name = " + Employee.companyName);
    }
}

class Employee {
    static String companyName = "Demo Company";
    static int count = 0;

    String name;

    Employee(String name) {
        this.name = name;
        count++;
    }

    void printInfo() {
        System.out.println(name + " works at " + companyName);
    }
}

