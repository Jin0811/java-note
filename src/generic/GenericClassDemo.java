package generic;

public class GenericClassDemo {
    public static void main(String[] args) {
        // JS/TS: type ApiResponse<T> = { success: boolean; data: T };
        // Java: class ApiResponse<T> { ... }
        ApiResponse<String> stringResponse = new ApiResponse<>(true, "登录成功");
        ApiResponse<Integer> numberResponse = new ApiResponse<>(true, 100);

        System.out.println(stringResponse.getData());
        System.out.println(numberResponse.getData());
    }
}

class ApiResponse<T> {
    private boolean success;
    private T data;

    ApiResponse(boolean success, T data) {
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

