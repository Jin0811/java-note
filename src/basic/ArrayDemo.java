package basic;

import java.util.Arrays;

/*
  ===== Java 数组的两种定义方式 =====

  共同点：Java 数组是【定长】的引用类型。长度一旦确定就不能变，
  不像 JS 的 Array 可以随便 push/pop。想追加元素要去学 collection 目录的 ArrayList。

  ┌────────────────────────────────────────────────────────────────────┐
  │ 方式一：声明时直接给值（静态初始化）                                │
  │   String[] names = {"Alex", "Bob", "Cindy"};                       │
  │                                                                    │
  │   · 已经知道要放哪些值时用。把初始值直接写在 {} 里。                 │
  │   · 数组长度由初始值个数自动确定（这里 = 3），不用手写长度。          │
  │   · 类比 JS/TS：const names: string[] = ["Alex", "Bob", "Cindy"];  │
  │     区别是 Java 定长、JS 可继续 push。                              │
  │   · 这种"省略 new"的简写【只能用在声明变量的同时】。                 │
  │     如果要之后再赋值，必须写完整形式：                               │
  │       names = new String[]{"Alex", "Bob", "Cindy"};                │
  ├────────────────────────────────────────────────────────────────────┤
  │ 方式二：只指定长度，先不给值（动态初始化）                          │
  │   int[] scores = new int[3];                                       │
  │                                                                    │
  │   · 只知道长度、值稍后再填时用。new int[3] 只分配 3 个格子。          │
  │   · 每个格子自动填【默认值】：                                      │
  │       int/long/short/byte -> 0      double/float -> 0.0            │
  │       boolean -> false              char -> '\u0000'               │
  │       引用类型(如 String) -> null                                   │
  │   · 之后再通过下标逐个赋值：scores[0] = 90; ...                     │
  │   · 类比 JS/TS：const scores: number[] = new Array(3); 再按下标填。  │
  └────────────────────────────────────────────────────────────────────┘

  几个细节：
  · int[] 是类型，[] 习惯写在类型后面（int[] scores），别写成 int scores[]。
  · 取长度用属性 names.length（不带括号）；注意 String 才是 .length() 方法。
  · 下标从 0 开始；越界访问会抛 ArrayIndexOutOfBoundsException（不会像 JS 返回 undefined）。

  ===== 补充：[] 和 {} 的分工（和 JS 对比）=====
  JS 里一个 [] 包办"声明+字面量+下标"；Java 把它拆成两个符号分工：
    []  -> 标记数组类型 int[]、定长 new int[3]、下标访问 a[0]
    {}  -> 只在"声明的同时赋初值"时使用：= {1,2,3}
  完整形式：new boolean[]{false, true, false} 也是合法写法，
  常用于"重新赋值"或"作为方法参数"等不能写 {} 简写的场合。
  规则："给长度"和"给值"二选一——new boolean[3]{...} 会编译错误，
  因为 new 类型[] 后长度由 {} 里的个数自动推断。

  ===== new 类型[长度] 对所有类型成立 =====
  new char[2]、new boolean[6]、new String[4] 都没问题，
  每个格子的默认值就是该类型的默认值（char 是 '\u0000'，打印时看不见）。

  ===== var 声明 vs 显式类型声明 =====
  var flags = new boolean[]{true};        与
  boolean[] flags = new boolean[]{true};
  没有任何运行时区别：var 是纯编译期推断，推断结果就是 boolean[]，字节码一样。
  差别只在可读性和写法限制（var 只能用于局部变量且必须立即初始化）。
  注意：var 推断的是右边的"具体类型"，想声明成接口类型时要手写（见 collection 目录）。

  ===== 什么时候用数组，什么时候用 List =====
  数组：定长、能存基本类型（int[]）、性能敏感/和底层 API 打交道时用。
  List：动态增删、后端业务代码 99% 的场景（见 collection/ArrayListDemo.java）。
*/

public class ArrayDemo {
    public static void main(String[] args) {
        // ===== 方式一：声明同时给值（静态初始化），长度自动 = 3 =====
        // Java 数组长度固定，声明后不能像 JS Array 那样随意 push。
        String[] names = {"Alex", "Bob", "Cindy"};

        // 完整形式：new 类型[]{值...}。这里和 {} 简写效果一样；
        // 完整形式还能用在"之后再赋值"或"当方法参数"等不能写简写的场合。
        // "给长度"和"给值"二选一：new boolean[3]{false,true,false} 是编译错误。
        boolean[] flags = new boolean[]{false, true, false};
        // var flags = new boolean[]{false, true, false};  // 与上面完全等价（var 纯编译期推断，字节码相同）

        System.out.println("names.length = " + names.length);  // length 是属性，不带括号
        System.out.println("names[0] = " + names[0]);          // 下标从 0 开始

        // ===== 数组转字符串：toString() vs Arrays.toString() =====
        // 数组没有重写 toString()，直接调用只会得到 "类名@哈希值"，
        // 例如 [Z@4eec7777（[ 表示数组，Z 表示 boolean，完全看不出内容）。
        System.out.println("flags.toString() = " + flags.toString());
        // 想看数组内容要用 Arrays.toString()：遍历元素拼成 [false, true, false]。
        // 多维数组用 Arrays.deepToString()。
        // 对比：ArrayList / HashSet 等集合重写了 toString()，直接打印就能看到内容。
        System.out.println("Arrays.toString(flags) = " + Arrays.toString(flags));

        names[1] = "Ben";   // 可以改元素内容，但不能改变数组长度
        System.out.println("names[1] = " + names[1]);

        // 方式一如果要之后再整体赋值，必须写完整的 new（简写只能在声明时用）：
        // names = new String[]{"Alex", "Bob", "Cindy"};

        for (int i = 0; i < names.length; i++) {
            System.out.println("index = " + i + ", name = " + names[i]);
        }

        // ===== 方式二：只定长度，元素先填默认值（int 默认是 0），之后再赋 =====
        int[] scores = new int[3];   // 此时 scores = {0, 0, 0}
        scores[0] = 90;
        scores[1] = 85;
        scores[2] = 100;

        // 增强 for 循环（类似 JS 的 for...of）：只读遍历，拿不到下标
        for (int score : scores) {
            System.out.println("score = " + score);
        }
    }
}

