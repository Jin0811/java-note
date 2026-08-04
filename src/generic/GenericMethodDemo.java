package generic;

/*
  ===== 泛型方法（Generic Method）=====

  泛型不只能放在类/接口上，也能放在"方法"上：
  方法自己声明类型参数，T 由每次调用时的实参决定。

  类比 TS：写法和位置几乎一样。
    TS:    function first<T>(a: T, b: T): T { return a; }
    Java:  static <T> T first(T a, T b) { return a; }
    类型参数都写在"参数列表前面"。

  语法拆解：static <T> T first(T a, T b)
    static  -> 修饰符：静态方法
    <T>     -> 【声明】类型参数：本方法有一个泛型参数叫 T
               （位置固定：必须在返回值类型的前面）
    T       -> 【使用】返回值类型：返回前面声明的那个 T
    first   -> 方法名
    (T a, T b) -> 【使用】参数类型：a、b 都是 T 类型
                  → 注意：a 和 b 必须是同一个类型！first("Java", 100) 编译报错。
                    想允许不同类型 → 多声明几个参数：<K, V>（见 printPair）。

  泛型方法 vs 泛型类的关键区别：
    泛型类：   T 在 new 对象时确定，整个对象生命周期固定
              （ApiResponse<String> 之后 getData 永远返回 String）。
    泛型方法： T 在"每次调用"时独立推断——
              first("Alex","Ben") 推断 T=String；first(90,100) 推断 T=Integer。
              同一个方法，每次调用 T 可以不同。

  也可以手动指定 T（极少用，写出来只是为了帮助理解机制）：
    GenericMethodDemo.<String>first("Alex", "Ben");
*/

public class GenericMethodDemo {
    public static void main(String[] args) {
        // 每次调用独立推断 T：
        // 传两个 String -> T=String，返回值也是 String，无需强转。
        String name = first("Alex", "Ben");
        // 传两个 Integer -> T=Integer。同一个方法，这次 T 就不一样了。
        Integer score = first(90, 100);

        System.out.println("name = " + name);
        System.out.println("score = " + score);

        // <K, V> 两个类型参数：key 和 value 可以是不同类型（String + Integer）。
        // K、V 由实参推断：K=String, V=Integer。
        printPair("Java", 100);
        // first("Java", 100);   // ❌ 编译错误：first 只有一个 T，两参数必须同类型
    }

    // 泛型方法：<T> 声明类型参数，T 同时用于返回值和参数类型。
    static <T> T first(T a, T b) {
        return a;
    }

    // 多个类型参数：<K, V> 让 key 和 value 互不约束，可以传不同类型。
    static <K, V> void printPair(K key, V value) {
        System.out.println(key + " -> " + value);
    }
}

