package lambda;

/*
  ===== 函数式接口与 Lambda =====

  函数式接口是只包含一个抽象方法的接口。因为它只有一个需要实现的行为，
  所以可以使用 Lambda 直接创建它的实现对象。

  @FunctionalInterface 是一个编译器检查注解，用来明确表示这个接口应该是函数式接口。
  如果以后给接口增加第二个抽象方法，编译器会立即报错。这个注解不是 Lambda 能够使用的
  必要条件，但建议添加，可以防止接口设计被意外破坏。

  Lambda 本身没有独立的变量类型，必须根据目标类型推断它要实现哪个函数式接口。
  例如：

    Calculator add = (a, b) -> a + b;

  因为等号左边的类型是 Calculator，编译器知道 Lambda 要实现 Calculator.calculate(int, int)。
  因此 a、b 会被推断为 int，a + b 的结果会作为 calculate 方法的返回值。

  上面的 Lambda 等价于传统的匿名内部类写法：

    Calculator add = new Calculator() {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    };

  Lambda 只是把这段实现代码写得更简洁。它描述的是行为，只有在调用
  add.calculate(...) 或 multiply.calculate(...) 时，方法体才会真正执行。

  这种“接口定义规则、实现提供行为”的设计有几个好处：
    1. 解耦：调用方只依赖 Calculator，不需要知道具体是加法还是乘法。
    2. 方便替换：add、multiply 和 subtract 都可以作为 Calculator 使用。
    3. 行为参数化：可以把 Lambda 当作参数传给其他方法。
    4. 便于扩展：新增一种计算方式时，原来的调用逻辑通常不需要修改。
    5. 类型安全：编译器会检查 Lambda 是否接收两个 int 并返回 int。
    6. 代码简洁：Lambda 比匿名内部类更短，适合表达简单明确的行为。

  例如，调用方可以只依赖接口：

    static int execute(Calculator calculator, int a, int b) {
        return calculator.calculate(a, b);
    }

  execute(add, 10, 20) 和 execute(multiply, 10, 20) 可以使用同一个方法，
  只是传入的行为不同。这就是接口、多态和 Lambda 配合使用的价值。
*/

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // add 和 multiply 的类型都是 Calculator，但它们提供了不同的 calculate 实现。
        // 参数类型可以省略，因为 Calculator.calculate 已经声明了两个 int 参数。
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        // 调用接口方法时，会执行 add 对应的 Lambda 方法体：10 + 20。
        System.out.println("add = " + add.calculate(10, 20));
        // 同一个接口可以有另一种 Lambda 实现：10 * 20。
        System.out.println("multiply = " + multiply.calculate(10, 20));
    }
}

// 只有一个抽象方法 calculate，所以 Calculator 是函数式接口。
@FunctionalInterface
interface Calculator {
    // 这个方法的参数列表和返回值决定了 Lambda 的形状：两个 int 参数，返回 int。
    int calculate(int a, int b);
}
