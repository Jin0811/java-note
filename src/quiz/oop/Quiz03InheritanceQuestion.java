package quiz.oop;

public class Quiz03InheritanceQuestion {
    public static void main(String[] args) {
        QuizFrontendEngineer engineer = new QuizFrontendEngineer("Alex");
        engineer.work();
        engineer.buildPage();

        /*
         * 问题：
         * 1. QuizFrontendEngineer 为什么能调用 work？
         * 2. super(name) 的作用是什么？
         * 3. Java 支持一个类继承多个父类吗？
         */
    }
}

class QuizEngineer {
    String name;

    QuizEngineer(String name) {
        this.name = name;
    }

    void work() {
        System.out.println(name + " is working");
    }
}

class QuizFrontendEngineer extends QuizEngineer {
    QuizFrontendEngineer(String name) {
        super(name);
    }

    void buildPage() {
        System.out.println(name + " builds pages");
    }
}

