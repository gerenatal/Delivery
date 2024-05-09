package Exceptions;
public class NoIdFoundException extends Exception {
    private String message;
    public NoIdFoundException(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}