package exceptions;

public class CustomerUncheckedException extends RuntimeException{
    public CustomerUncheckedException(String message) {
        super(message);
    }
}
