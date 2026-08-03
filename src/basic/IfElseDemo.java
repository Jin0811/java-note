// package 声明当前类所属的包（命名空间），必须和文件所在目录对应：
// src/basic/IfElseDemo.java -> package basic。
// 类比 TS：类似模块路径 + 命名空间，用于组织代码、避免类名冲突。
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
    }
}

