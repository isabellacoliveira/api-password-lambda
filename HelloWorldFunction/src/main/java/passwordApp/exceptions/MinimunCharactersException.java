package passwordApp.exceptions;

public class MinimunCharactersException extends RuntimeException {
    private MinimunCharactersException() {
        super("❌ Password should have at least 9 characters.");
    }

    public MinimunCharactersException(String message) {
        super(message);
    }
}
