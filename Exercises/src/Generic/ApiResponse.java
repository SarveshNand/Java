package Generic;

public class ApiResponse<T> {
    private T data;
    private String message;

    ApiResponse(T data, String message){
        this.data = data;
        this.message = message;
    }

    public T getData(){
        return data;
    }

    public String getMessage(){
        return message;
    }
}
