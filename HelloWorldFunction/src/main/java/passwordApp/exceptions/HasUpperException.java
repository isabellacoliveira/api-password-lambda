package passwordApp.exceptions;

public class HasUpperException extends RuntimeException {
    private HasUpperException() {
        super("❌ Password should have at least one uppercase letter.");
    }

    public HasUpperException(String message) {
        super(message);
    }
}