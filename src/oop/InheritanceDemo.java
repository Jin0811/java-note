package oop;

public class InheritanceDemo {
    public static void main(String[] args) {
        FrontendEngineer frontend = new FrontendEngineer("Alex");
        BackendEngineer backend = new BackendEngineer("Ben");

        frontend.work();
        frontend.buildPage();

        backend.work();
        backend.buildApi();
    }
}

class Engineer {
    String name;

    Engineer(String name) {
        this.name = name;
    }

    void work() {
        System.out.println(name + " is writing code");
    }
}

class FrontendEngineer extends Engineer {
    FrontendEngineer(String name) {
        super(name);
    }

    void buildPage() {
        System.out.println(name + " builds Vue pages");
    }
}

class BackendEngineer extends Engineer {
    BackendEngineer(String name) {
        super(name);
    }

    void buildApi() {
        System.out.println(name + " builds Java APIs");
    }
}

