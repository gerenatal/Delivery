package Exceptions;
public class NoDeliveryGuyAvailableException extends Exception {
    private String message;
    public NoDeliveryGuyAvailableException(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}