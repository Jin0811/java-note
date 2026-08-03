package basic;

public class ForLoopDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("for i = " + i);
        }

        int count = 1;
        while (count <= 3) {
            System.out.println("while count = " + count);
            count++;
        }

        String[] skills = {"JavaScript", "TypeScript", "Vue", "Java"};

        // 增强 for 循环，类似 JS/TS 的 for...of。
        for (String skill : skills) {
            System.out.println("skill = " + skill);
        }
    }
}

