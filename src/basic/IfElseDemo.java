package basic;

public class IfElseDemo {
    public static void main(String[] args) {
        int score = 86;

        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("需要继续练习");
        }

        // Java 的三元表达式和 JS/TS 很像。
        String result = score >= 60 ? "通过" : "未通过";
        System.out.println("result = " + result);

        // ============================================================
        // switch 用法一：传统 switch 语句（和 JS 几乎一样）
        // 注意：每个 case 后面必须写 break，否则会"贯穿"到下一个 case 继续执行。
        // switch 里能用的类型：byte / short / int / char / String / 枚举。
        // ============================================================
        String role = "admin";
        switch (role) {
            case "admin":
                System.out.println("管理员：可以增删改查");
                break;   // 不写 break 会继续往下执行 "editor" 分支（和 JS 的 fall-through 一样）
            case "editor":
                System.out.println("编辑：可以增删改");
                break;
            case "guest":
                System.out.println("访客：只能查看");
                break;
            default:     // 相当于 JS switch 的 default
                System.out.println("未知角色");
        }

        // ============================================================
        // switch 用法二：switch 表达式（Java 14+，JS 没有对应语法）
        // 用箭头 -> 写，不需要 break，并且整个 switch 可以"返回值"直接赋给变量。
        // 适合"根据一个值算出另一个值"的场景，比 if/else 链更清晰。
        // ============================================================
        char level = 'B';
        String levelDesc = switch (level) {
            case 'A' -> "优秀";          // 单行：直接写表达式
            case 'B' -> "良好";
            case 'C' -> {                // 多行：用代码块 + yield 返回值
                System.out.println("(正在处理 C 级...)");
                // yield：从"代码块分支"里抛出这个 switch 表达式的返回值。
                // 为什么不用 return？—— return 是"退出整个方法"，而这里只是要
                // 给 switch 表达式产出一个值，并不想结束 main 方法，所以用 yield。
                // 注意：只有"箭头 + 代码块"这种分支才需要 yield；
                //       单行写法（case 'A' -> "优秀";）直接写表达式即可，不用 yield。
                // 补充：yield 是 Java 14 为 switch 表达式新增的受限关键字，
                //       和 JS 生成器里的 yield 长得一样但完全不是一回事，这里只是"返回值"。
                yield "及格";
            }
            default -> "未知等级";
        };
        System.out.println("level " + level + " => " + levelDesc);
    }
}

