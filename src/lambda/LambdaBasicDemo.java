package lambda;

import java.util.ArrayList;
import java.util.List;

/*
  ===== Lambda 基础 =====

  Lambda 是 Java 8 引入的一种语法，用来简洁地描述一段可执行的行为。
  它的使用方式类似 JavaScript 的箭头函数：

    JavaScript：names.forEach(name => console.log(name));
    Java：      names.forEach(name -> System.out.println(name));

  Lambda 的基本语法是：

    (参数列表) -> { 方法体 }

  如果方法体只有一条表达式，可以省略大括号：

    参数 -> 表达式

  Java 中的 Lambda 不能完全脱离上下文单独存在，通常需要赋值给一个函数式接口，
  或者作为参数传给一个需要函数式接口的方法。函数式接口只有一个抽象方法，
  例如 Runnable 的 run()、Consumer 的 accept()。

  List.forEach() 接收一个 Consumer 参数。Consumer 表示：接收一个元素，
  对它执行某种操作，但不返回结果。下面的 Lambda 就是 Consumer<String> 的实现：

    skill -> System.out.println("skill = " + skill)

  这里可以拆成四部分理解：
    1. skill：Lambda 的参数，代表集合当前遍历到的一个元素。
    2. ->：把参数和要执行的行为分开。
    3. System.out.println(...)：收到一个 skill 后要执行的操作。
    4. String 类型：由 List<String> 和 forEach 的参数类型自动推断，不需要手写。

  Lambda 只是描述行为，不代表线程，也不会自动异步执行。forEach 会按照集合中的
  元素顺序调用这段行为，本例中的 Lambda 会执行 3 次，而且不会修改原来的集合。
*/

public class LambdaBasicDemo {
    public static void main(String[] args) {
        // 创建一个只能保存 String 的 List，尖括号中的 String 是集合的元素类型。
        List<String> skills = new ArrayList<>();
        skills.add("JavaScript");
        skills.add("TypeScript");
        skills.add("Java");

        // JS/TS：skills.forEach(skill => console.log(skill));
        // Java：skills.forEach(skill -> System.out.println("skill = " + skill));
        //
        // forEach 会依次取出 JavaScript、TypeScript、Java，并将当前元素传给 skill。
        // 因此这段 Lambda 会执行 3 次，输出 3 行内容。
        skills.forEach(skill -> System.out.println("skill = " + skill));
    }
}
