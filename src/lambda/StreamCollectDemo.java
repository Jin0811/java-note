package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
  ===== Stream 与 collect =====

  Stream 是 Java 8 提供的数据处理工具。它不是用来保存数据的容器，
  而是围绕数据源组织一条处理流程。常见的 Stream 流程是：

    数据源 -> stream() -> 中间操作 -> 终端操作 -> 处理结果

  本例的具体流程是：

    scores
      -> stream()
      -> filter(score -> score >= 60)
      -> collect(Collectors.toList())
      -> passedScores

  各部分的作用：
    stream()：根据原集合创建一个 Stream，不会复制或修改原集合。
    filter(...)：中间操作，根据条件筛选元素，返回一个新的 Stream。
                 score -> score >= 60 是一个返回 boolean 的 Lambda，
                 表示只保留分数大于等于 60 的元素。
    collect(...)：终端操作，真正触发 Stream 流程的执行，并把处理结果收集起来。
    Collectors.toList()：告诉 collect 使用 List 收集器，把通过筛选的元素收集成 List。
    Stream.toList()：Java 16 提供的快捷写法，直接把 Stream 收集成 List。

  collect(Collectors.toList()) 是 Java 8 以来的常见写法；toList() 是 Java 16+ 的简化写法。
  两种写法在本例中都会得到 [60, 85, 90]，但结果集合的可修改性语义不同：
    - Stream.toList() 返回不可修改的 List。
    - Collectors.toList() 不保证具体 List 实现和可修改性，不能依赖其具体实现。
      如果业务明确需要一个可修改的集合，可以显式创建 new ArrayList<>(结果集合)。

  filter 是中间操作，通常具有延迟执行的特点。仅仅写出 stream() 和 filter()
  并不会立刻遍历集合，直到调用 collect 这样的终端操作时，Stream 才会真正处理元素。

  本例中：
    60、85、90 满足 score >= 60，会进入 passedScores；
    45 不满足条件，会被过滤掉。
    原来的 scores 仍然是 [60, 85, 90, 45]，passedScores 是收集后的结果集合。

  这和手写循环的目标类似，但 Stream 可以把“筛选、转换、收集”等处理步骤串成一条
  更直观的流程。Stream 适合描述数据怎么流过各个处理步骤，而不是保存数据本身。
*/

public class StreamCollectDemo {
    public static void main(String[] args) {
        // 原始数据集合，也可以称为 Stream 的数据源。
        List<Integer> scores = new ArrayList<>();
        scores.add(60);
        scores.add(85);
        scores.add(90);
        scores.add(45);

        // 处理流程：从 scores 创建 Stream，筛选及格分数，再收集成新的 List。
        List<Integer> passedScores = scores.stream()
                // filter 接收一个 Predicate，只有返回 true 的元素才会保留。
                .filter(score -> score >= 60)
                // collect 是终端操作；执行到这里时，前面的 Stream 流程才会真正运行。
                .collect(Collectors.toList());

        // Java 16+ 可以使用 Stream.toList()，省略 collect(Collectors.toList())。
        // 这里重新创建一个 Stream，是为了在同一个示例中对比两种写法。
        List<Integer> passedScoresWithToList = scores.stream()
                .filter(score -> score >= 60)
                .toList();

        // 两种方式的筛选结果相同，scores 本身没有被修改。
        System.out.println("passedScores = " + passedScores);
        System.out.println("passedScoresWithToList = " + passedScoresWithToList);
    }
}
