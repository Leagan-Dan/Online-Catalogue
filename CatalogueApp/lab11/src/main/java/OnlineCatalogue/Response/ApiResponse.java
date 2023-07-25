package OnlineCatalogue.Response;

public class ApiResponse <T>{
    public String message;
    public T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ApiResponse(String message) {
        this.message = message;
    }
}
