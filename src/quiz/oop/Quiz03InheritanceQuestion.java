package quiz.oop;

public class Quiz03InheritanceQuestion {
    public static void main(String[] args) {
        // 创建的是子类对象。子类自己只定义了 buildPage，
        // work 是从父类"继承"来的，也能直接调用。
        QuizFrontendEngineer engineer = new QuizFrontendEngineer("Alex");
        engineer.work();       // 继承自父类 QuizEngineer 的方法
        engineer.buildPage();  // 子类自己的方法

        /*
         * 问题：
         * 1. QuizFrontendEngineer 为什么能调用 work？
         * 因为QuizFrontendEngineer继承了QuizEngineer，QuizEngineer当中有一个work方法
         * 这个work方法不是private的，所以可以被继承
         *
         * 2. super(name) 的作用是什么？
         * 调用父类QuizEngineer的构造函数，为name属性赋值
         *
         * 3. Java 支持一个类继承多个父类吗？
         * 不支持继承多个类，如果想要实现类似的效果，可以使用接口，Java支持实现多个接口
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际运行输出：
         * Alex is working      <- work 继承自父类
         * Alex builds pages    <- buildPage 是子类自己的方法
         *
         * 问题 1：QuizFrontendEngineer 为什么能调用 work？
         * 答：因为 extends QuizEngineer，子类继承父类的可见成员，
         *     work 是父类的非 private 方法，所以子类拿过来直接用。
         *     补充可见性细节：本题 work 和 name 都是"默认(包私有)"，
         *     父子类在同一个包，所以能继承；若父类方法写成 private，
         *     子类就"看不见"，既不能调用也不能重写（见 InheritanceDemo）。
         *
         * 问题 2：super(name) 的作用是什么？
         * 答：调用父类 QuizEngineer 的构造方法，让父类初始化它自己的字段 name。
         *     三个要点：
         *       1. 必须放在子类构造方法的【第一行】；
         *       2. name 字段定义在父类，初始化必须交给父类构造方法做；
         *       3. 不写 super(...) 时，编译器默认插入无参 super()——
         *          若父类没有无参构造（像本题只有带参的），直接编译报错。
         *          这就是"父类只有带参构造时，子类必须显式 super(...)"的原因。
         *
         * 问题 3：Java 支持一个类继承多个父类吗？
         * 答：不支持多继承：一个类只能 extends 一个父类。
         *     想获得"多方能力"用接口：可以 implements 多个接口
         *     （class A extends B implements X, Y, Z —— 一继承 + 多实现）。
         *     为什么禁止多继承？避免"菱形问题"：
         *       两个父类有同名方法，子类不知道该继承哪个，产生歧义。
         *       接口没有字段状态、Java 8+ 的 default 方法冲突也有明确规则，
         *       所以多实现是安全的。
         */
    }
}

// ===== 父类 =====
class QuizEngineer {
    // name 是"默认(包私有)"字段：同包的子类可以继承并访问。
    String name;

    QuizEngineer(String name) {
        this.name = name;
    }

    // work 也是默认访问级别（非 private），所以能被同包子类继承。
    void work() {
        System.out.println(name + " is working");
    }
}

// ===== 子类：extends 继承父类 =====
class QuizFrontendEngineer extends QuizEngineer {
    QuizFrontendEngineer(String name) {
        // super(name)：调用父类构造方法初始化父类的 name 字段。
        // 必须写在构造方法第一行；父类只有带参构造，所以这里必须显式写，
        // 否则编译器默认插无参 super() 会编译报错。
        super(name);
    }

    // 子类自己的方法，和继承来的 work 并存。
    void buildPage() {
        System.out.println(name + " builds pages");
    }
}

