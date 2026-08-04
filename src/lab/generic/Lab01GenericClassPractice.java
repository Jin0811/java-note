package lab.generic;

public class Lab01GenericClassPractice {
    public static void main(String[] args) {
        /*
         * 练习目标：泛型类。
         *
         * TODO:
         * 1. 创建 Result<String>，保存登录成功消息。
         * 2. 创建 Result<Integer>，保存分数。
         * 3. 调用 getData 输出结果，观察返回值类型不需要强转。
         */

        Result<String> loginResult = new Result<>(true, "登录成功");
        Result<Integer> scoreResult = new Result<>(true, 95);

        String message = loginResult.getData();
        Integer score = scoreResult.getData();

        System.out.println(message);
        System.out.println(score);
    }
}

class Result<T> {
    private boolean success;
    private T data;

    Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }
}
