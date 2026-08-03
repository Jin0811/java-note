package collection;

import java.util.ArrayList;
import java.util.List;

/*
  ===== List 与 ArrayList："接口 + 实现类"的经典搭配 =====

  先分清概念：JS 里一个 Array 包打天下，Java 拆成了两样东西：
  ┌──────────┬──────────────────────┬──────────────────────────────┐
  │          │ Java 数组(见 ArrayDemo)│ Java 列表 List               │
  ├──────────┼──────────────────────┼──────────────────────────────┤
  │ 长度     │ 定长，创建后不可变     │ 动态，随时 add/remove         │
  │ 本质     │ 语言级内置结构(专门语法)│ java.util 包里的接口/类        │
  │ 定义     │ int[] a = {1,2};      │ List<String> l = new ...;    │
  │ 取元素   │ a[0]（下标语法）        │ l.get(0)（方法调用）           │
  │ 长度     │ a.length（属性）        │ l.size()（方法）              │
  │ 基本类型 │ ✅ int[]、char[]...    │ ❌ 要用包装类 List<Integer>    │
  └──────────┴──────────────────────┴──────────────────────────────┘
  迁移直觉：JS 的 [] 绝大多数时候对应 Java 的 List<T>（动态、能 add）；
  Java 的定长数组在 JS 里没有直接对应物。真实后端代码 99% 场景用 List。

  ===== List 是接口，ArrayList 是实现类 =====
  · List：接口，只规定 add/get/remove/size 等方法签名（契约），不能被 new。
  · ArrayList：实现类之一，把 List 的抽象方法全部实现，
    底层用数组存储（所以叫 Array-List）：按下标 get(i) 快，
    中间插入/删除慢（要搬移元素），容量不够自动扩容。

  拆解 List<String> skills = new ArrayList<>();
    右边 new ArrayList<>() -> 真正被创建的是 ArrayList 对象（接口永远不能被 new）；
    左边 List<String> skills -> 引用变量的类型标注成 List 接口，存的是对象引用；
    调用方法时"编译看左边，运行看右边"：
      编译器只检查 List 接口有没有这个方法；运行时执行的是 ArrayList 的实现逻辑。
    和 PolymorphismDemo 里 Notification n = new EmailNotification() 是同一套多态机制。

  泛型与菱形推断：
  · <String> 泛型参数：声明"这个列表只放 String"，类似 TS 的 Array<string>。
    skills.add(123) 会直接编译报错，编译器帮你做类型检查。
  · <> 菱形推断（Java 7+）：编译器从左边的 List<String> 已知类型，
    右边无需重复写；new ArrayList<String>() 是老写法，效果相同。
  · 注意：<> 只能出现在 new 的时候，变量声明处不能写 List<> skills。
  · 用 var 时右边必须自己写泛型：var skills = new ArrayList<String>();

  List 的其他常见实现：
  · ArrayList：数组底层，随机访问快（最常用）
  · LinkedList：双向链表底层，头部/中间增删快
  · Vector：数组底层的线程安全老类，新项目不用
  声明成 List 接口类型的收益——换实现只改一处：
      List<String> skills = new LinkedList<>();   // 只改右边，调用代码不用动
    两个前提：1. 不能调用实现类特有方法（如 ArrayList 的 trimToSize 不在 List 里）；
              2. 行为一致但性能特征不同，要按场景选实现。

  Spring 的"面向接口编程"、@Autowired 注入接口得到实现类，根基就是这套机制。
*/

public class ArrayListDemo {
    public static void main(String[] args) {
        // JS/TS: const skills = ["JS", "TS"];
        // Java: List 更接近 JS Array——动态、能 add/remove。
        // new 出来的是实现类 ArrayList；List 只是引用变量的类型标注（接口本身不能被 new）。
        List<String> skills = new ArrayList<>();   // 右边的 <> 会被推断成 ArrayList<String>
        // ArrayList<String> skills = new ArrayList<>();  // 也能写，但调用方就和具体实现类绑死了

        skills.add("JavaScript");   // add = JS 的 push
        skills.add("TypeScript");
        skills.add("Vue");
        skills.add("Java");
        // skills.add(123);         // 编译错误：泛型限定元素只能是 String

        // List 实现类重写了 toString()，直接打印就能看到内容
        // （对比：数组直接打印是 [Z@xxx，见 ArrayDemo 的 Arrays.toString 一节）
        System.out.println("skills = " + skills);
        System.out.println("first = " + skills.get(0));   // get(i) = JS 的 [i]，ArrayList 按下标取很快
        System.out.println("size = " + skills.size());    // size() 是方法，不像数组的 .length 是属性

        skills.remove("Vue");       // 按值删除
        System.out.println("after remove = " + skills);

        // 声明成接口类型的好处：以后换实现只改下面这一行，其它代码不用动（详见顶部注释）
        // List<String> skills2 = new LinkedList<>();
    }
}

