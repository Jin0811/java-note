// package 声明当前类所属的包（命名空间），必须和文件所在目录对应：
// src/basic/HelloWorld.java -> package basic。
// 类比 TS：类似模块路径 + 命名空间，用于组织代码、避免类名冲突。
package basic;

/*
 ===== 关键字说明（针对下面这一行）=====
 public class HelloWorld {
     public static void main(String[] args) { ... }
 }

 public   访问修饰符：表示该类/方法对所有包公开可见。
          类比 TS：类似 export。注意 Java 不写修饰符时默认"包内可见"（包私有，也就是basic包内的文件可以使用，不能跨包），而不是公开。

 class    声明一个类，与 TS 的 class 含义一致。
          规则：一个 .java 文件最多只能有一个 public 类，且类名必须与文件名完全一致
          （HelloWorld.java 里必须是 public class HelloWorld）。
          一个 .java 文件最多一个 public 类、类名须与文件名一致"是 javac 强制的编译规则（JLS §7.6），违反即编译失败；非 public 类不受此限制。

 static   静态成员：属于类本身，而不是某个实例，无需 new 即可调用。
          类比 TS：static 方法/属性。JVM 启动时是直接以 Main.main() 这样的方式调用入口的，
          此时还没有任何对象被创建，所以入口方法必须是 static。

 void     返回值类型：表示方法没有返回值。
          与 TS 完全一样：function main(args: string[]): void {}

 补充：String[] args 是命令行参数，java HelloWorld a b 时 args = ["a", "b"]，类似 Node 的 process.argv。
 一句话总结：main 方法是 JVM 规定的程序入口，签名固定为 public static void main(String[] args)。
 */

/*
 ===== Java 的四种访问权限级别 =====

 public       所有包可见（本文件的类和方法都用它）。
 不写          包私有：仅同包可见（如 basic 包内其他文件），不能跨包访问。
 protected    同包可见 + 不同包的【子类】也可访问（继承示例在 oop 目录）。
 private      仅当前类内部可见，外部无法访问，常用于隐藏类的字段。

 可见范围从大到小：public > protected > 包私有(默认) > private

 两条重要规则：
 1. 顶层类（直接写在文件里的类）只能用 public 或包私有（不写）两种，
    不能写 private/protected —— 否则编译报错。
 2. private/protected 只能修饰类成员（字段、方法、内部类）：
    class User {
        private String name;       // 只有 User 内部能访问
        protected void reset() {}  // 同包 + 子类可访问
    }

 类比 TS：TS 也有 public / protected / private，含义接近；
          但 TS 还有 # 私有字段和 readonly。Java 没有 readonly，对应概念是 final。
 实际开发习惯：类一般声明为 public，字段用 private + getter/setter 封装。
 */

public class HelloWorld {
    public static void main(String[] args) {
        // JS/TS: console.log("Hello Java");
        // Java: System.out.println("Hello Java");
        System.out.println("Hello Java");
        System.out.println("这是 basic 目录下的第一个 Java 示例");

        // 调用同类中的静态方法 sayName。
        // 同类 + 静态方法：直接写方法名即可；也可以写成 HelloWorld.sayName()。
        sayName();
    }

    public static void sayName () {
        System.out.println("My name is Tom");
    }
}

