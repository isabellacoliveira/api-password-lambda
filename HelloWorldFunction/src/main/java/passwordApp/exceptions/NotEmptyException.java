package passwordApp.exceptions;

public class NotEmptyException extends RuntimeException {
    private NotEmptyException() {
        super("❌ Password should not be empty.");
    }

    public NotEmptyException(String message) {
        super(message);
    }
}
