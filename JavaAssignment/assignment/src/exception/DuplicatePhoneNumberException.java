package exception;

public class DuplicatePhoneNumberException extends Exception {
    public DuplicatePhoneNumberException(String message) {
        super(message);
    }
}
