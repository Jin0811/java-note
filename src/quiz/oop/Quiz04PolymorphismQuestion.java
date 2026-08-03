package quiz.oop;

public class Quiz04PolymorphismQuestion {
    public static void main(String[] args) {
        QuizPayMethod payMethod = new QuizWechatPay();
        payMethod.pay(100);

        /*
         * 问题：
         * 1. 变量类型是 QuizPayMethod，真实对象类型是什么？
         * 2. payMethod.pay(100) 最终执行哪个类的方法？
         * 3. 这种写法在后端项目里有什么好处？
         */
    }
}

interface QuizPayMethod {
    void pay(double amount);
}

class QuizWechatPay implements QuizPayMethod {
    public void pay(double amount) {
        System.out.println("Wechat pay " + amount);
    }
}

