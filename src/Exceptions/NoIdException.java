package Exceptions;

public class NoIdException extends Exception {
    private String message;

    public NoIdException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}