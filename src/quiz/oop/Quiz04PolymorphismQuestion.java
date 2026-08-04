package quiz.oop;

public class Quiz04PolymorphismQuestion {
    public static void main(String[] args) {
        QuizPayMethod payMethod = new QuizWechatPay();
        payMethod.pay(100);

        // ===== 补充示例：实现类的"独有方法"能不能通过接口变量调用？=====
        // sendRedPacket() 是 QuizWechatPay 独有的方法，QuizPayMethod 接口里没有。
        // payMethod.sendRedPacket();   // 编译报错！"编译看左边"——接口里没这个方法
        // 想调用，得先把类型"收窄"回实现类（和 TS 的 narrowing 思路一样）：
        if (payMethod instanceof QuizWechatPay) {
            QuizWechatPay wechat = (QuizWechatPay) payMethod;   // 手动强转
            wechat.sendRedPacket(66.6);
        }
        // Java 16+ 模式匹配 instanceof（本项目 JDK 17）：判断+收窄一步到位，更像 TS
        if (payMethod instanceof QuizWechatPay wechat2) {
            wechat2.sendRedPacket(88.8);
        }

        /*
         * 问题：
         * 1. 变量类型是 QuizPayMethod，真实对象类型是什么？
         * 真实对象类型是QuizWechatPay，因为QuizWechatPay实现了QuizPayMethod接口
         * 编译的时候是看左边QuizPayMethod接口类型，运行的时候是走右边QuizWechatPay
         *
         * 2. payMethod.pay(100) 最终执行哪个类的方法？
         * 执行的是QuizWechatPay上的pay方法，因为QuizPayMethod接口里面的pay只是一个抽象方法，没有具体实现
         *
         * 3. 这种写法在后端项目里有什么好处？
         * 可以规范类的实现
         */

        /*
         * ========== 标准答案 ==========
         *
         * 实际运行输出：Wechat pay 100.0
         *
         * 问题 1：变量类型是 QuizPayMethod，真实对象类型是什么？
         * 答：真实对象类型是 QuizWechatPay。
         *     QuizPayMethod payMethod 只是"引用变量的类型"（接口），
         *     new QuizWechatPay() 创建的才是真实对象。
         *     口诀：编译看左边（变量类型决定"能调哪些方法"），
         *           运行看右边（真实对象决定"执行谁的实现"）。
         *
         * 问题 2：payMethod.pay(100) 最终执行哪个类的方法？
         * 答：QuizWechatPay 的 pay。
         *     编译期：编译器只看左边 QuizPayMethod，确认接口有 pay 方法 → 通过。
         *     运行期：JVM 顺着引用找到真实对象 QuizWechatPay，执行它的实现。
         *     接口里的 pay 是抽象方法（无实现），真正干活的永远是实现类。
         *
         * 问题 3：这种写法在后端项目里有什么好处？
         * 答："规范类的实现"只是接口的契约作用；这种"多态写法"的核心好处是：
         *     1. 面向接口编程、可替换：调用方只依赖接口，不关心具体实现。
         *        支付场景最典型——支付宝/微信/银联都是 QuizPayMethod 的实现，
         *        业务代码写 QuizPayMethod pay = ...; pay.pay(100)，
         *        切换支付方式只需换 new 出来（或换配置）的那一处，调用代码零改动。
         *     2. 解耦 + 易测试：依赖的是"能力契约"而非具体类，
         *        测试时可以传一个假实现（mock）进去。
         *     3. Spring 依赖注入的根基：字段声明成接口类型，
         *        @Autowired 由框架注入真实实现，换实现只改配置/注解，
         *        业务代码完全不感知——这是后端天天用的模式。
         *     一句话：多态让代码"依赖抽象而非细节"，改实现不伤调用方。
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

    // 实现类"独有"的方法：接口 QuizPayMethod 里没有它。
    // 所以通过接口类型的变量调不到（编译看左边），
    // 必须先用 instanceof 判断 + 向下转型"收窄"回 QuizWechatPay 才能调（见 main）。
    public void sendRedPacket(double amount) {
        System.out.println("Wechat 发红包 " + amount);
    }
}

