package generic;

/*
  ===== 泛型类（Generic Class）=====

  泛型 = 把"类型"也变成参数。写类的时候先不写死具体类型，
  用一个占位符（如 <T>）代表，用的时候再传入真实类型。
  T 是 Type 的缩写，常见命名：T(类型)、E(元素)、K(键)、V(值)。

  类比 TS：完全一个思路。
    TS:    type ApiResponse<T> = { success: boolean; data: T };
    Java:  class ApiResponse<T> { boolean success; T data; }
    用的时候 ApiResponse<string> / ApiResponse<number>，和 TS 一模一样。

  核心价值：
  · 一个类适配多种类型，不用为 String/Integer 各写一遍。
  · 类型安全：ApiResponse<String> 的 getData() 返回的就是 String，
    编译期检查，不用强转、不会运行时 ClassCastException。
    （对比老式 Object：getData() 返回 Object，取出后得强转，类型错了运行时才炸。）

  注意：泛型的 T 只能是【引用类型】，不能直接写 int/double，
  要用包装类：ApiResponse<Integer>、ApiResponse<Double>（自动装箱，见集合模块）。
*/

public class GenericClassDemo {
    public static void main(String[] args) {
        // JS/TS: type ApiResponse<T> = { success: boolean; data: T };
        // Java: class ApiResponse<T> { ... }

        // 同一个 ApiResponse 类，<> 里传不同类型，就得到不同类型的响应对象。
        ApiResponse<String> stringResponse = new ApiResponse<>(true, "登录成功");
        // 右边 <> 菱形推断：编译器从左边的 ApiResponse<String> 推断出 T=String。
        ApiResponse<Integer> numberResponse = new ApiResponse<>(true, 100);

        // getData() 的返回类型随 T 而定：String 版返回 String，Integer 版返回 Integer，
        // 无需强转，编译期就确定了类型。
        System.out.println(stringResponse.getData());
        System.out.println(numberResponse.getData());
    }
}

// <T> 是类型参数：声明这个类有一个"待定类型"，用的时候再指定。
class ApiResponse<T> {
    private boolean success;   // 固定类型字段，和泛型无关
    private T data;            // 泛型字段：T 在实例化时确定具体类型

    // 构造方法的参数也能用 T：data 的类型跟随调用方传入的泛型。
    ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    // 返回 T：返回类型随调用方的泛型参数变化（String / Integer / ...）。
    public T getData() {
        return data;
    }
}

