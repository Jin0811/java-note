package lambda;

import java.util.ArrayList;
import java.util.List;

/*
  ===== 方法引用 =====

  方法引用是 Lambda 的简化写法。当 Lambda 只是调用一个已经存在的方法，
  不需要额外编写参数和方法体时，可以使用 :: 直接引用这个方法。

  下面两种写法等价：

    name -> System.out.println(name)
    System.out::println

  方法引用的基本形式包括：
    对象::实例方法       例如 System.out::println
    类::静态方法         例如 Math::abs
    类::实例方法         例如 String::toUpperCase
    类::new              例如 ArrayList::new

  System.out 是一个 PrintStream 对象，println 是它的实例方法。
  names.forEach() 需要接收一个 Consumer<String>，也就是一个接收 String、
  不返回结果的行为。编译器会根据这个目标类型，把 System.out::println
  理解为：收到一个 name 后，调用 System.out.println(name)。

  方法引用只是把方法作为行为传递出去，并不会在写下这一行时立即调用 println。
  forEach 遍历 names 时，才会对每个元素调用一次 println，本例一共执行 3 次。
*/

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 创建一个保存姓名的字符串集合。
        List<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Ben");
        names.add("Cindy");

        // Lambda 写法：forEach 把当前元素传给 name，再执行 println。
        // names.forEach(name -> System.out.println(name));
        
        // 方法引用写法：直接引用 PrintStream 的 println 方法。
        // 这里的 :: 不是调用方法，所以不能写成 System.out::println()。
        names.forEach(System.out::println);
    }
}
