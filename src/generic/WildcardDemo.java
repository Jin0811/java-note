package generic;

import java.util.ArrayList;
import java.util.List;

/*
  ===== 通配符 & 上界（? extends）=====

  ? extends Number 的含义："某个未知类型，但保证是 Number 或其子类"。
  接受 List<Integer>、List<Double>、List<Number>……元素只要是 Number 家族就行。

  为什么需要它？——Java 泛型是"不变的"（invariant），这是最大的反直觉点：
    List<Integer> 【不是】 List<Number> 的子类型！
    如果写 void print(List<Number> nums)，传 List<Integer> 会编译报错。
    Java 这么严是为了安全：否则就能往 List<Integer> 里塞 Double，污染集合。
    ? extends Number 就是解法：声明"元素是 Number 家族的某种 List"，都能收。

  类比 TS：TS 的数组是协变的，number[] 天然能接受 Integer[]/Double[]，
    所以 TS 写 function print(numbers: Number[]) 直接就行，根本不需要通配符。
    Java 的不变性才逼出了 ? extends 这种语法。

  关键代价：? extends 让集合变成【只读】。
    能取出元素（至少是 Number），但不能 add：
      numbers.add(1);      // ❌ 编译错误：编译器不知道具体是
      numbers.add(1.5);    // ❌ List<Integer> 还是 List<Double>，塞啥都怕塞错
    口诀（PECS 的一半）：Producer Extends —— 只读出来的集合用 extends。
    （对应的 Consumer Super 会在 ? super 通配符再讲。）

  和"带名字的泛型约束"对照：
    static <T extends Number> void print(List<T> list)     // 给 T 起名，可反复引用
    static void print(List<? extends Number> list)         // 匿名版：不需要引用 T 时更简洁
    ? 相当于"匿名的类型参数"。TS 对照物是 <T extends Number> 约束。
*/

public class WildcardDemo {
    public static void main(String[] args) {
        List<Integer> intNumbers = new ArrayList<>();
        intNumbers.add(1);
        intNumbers.add(2);
        intNumbers.add(3);

        List<Double> doubleNumbers = new ArrayList<>();
        doubleNumbers.add(1.5);
        doubleNumbers.add(2.5);

        // 同一个方法，既能收 List<Integer> 又能收 List<Double>——
        // 靠的就是参数里的 ? extends Number（换成 List<Number> 这两行都会编译报错）。
        printNumbers(intNumbers);
        printNumbers(doubleNumbers);
    }

    // ? extends Number：可以接收"元素是 Number 或其子类"的任意 List。
    // 注意：方法内只能"读"（遍历输出），不能 numbers.add(...)，编译会拦。
    static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println("number = " + number);
        }
    }
}

