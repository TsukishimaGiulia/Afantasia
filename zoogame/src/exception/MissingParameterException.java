package exception;

public class MissingParameterException extends Exception {

    public MissingParameterException() {
    }

    public MissingParameterException(String message) {
        super(message);
    }
}
