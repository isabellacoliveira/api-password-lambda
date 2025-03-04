package passwordApp.exceptions;

public class RepeatedCharacterException extends RuntimeException {
    private RepeatedCharacterException() {
        super("❌ Password should not contain repeated characters.");
    }

    public RepeatedCharacterException(String message) {
        super(message);
    }
}
