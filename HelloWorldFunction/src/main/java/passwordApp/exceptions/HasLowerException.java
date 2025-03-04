package passwordApp.exceptions;

public class HasLowerException extends RuntimeException {
    private HasLowerException() {
        super("❌ Password should have at least one lowercase letter.");
    }

    public HasLowerException(String message) {
        super(message);
    }
}
