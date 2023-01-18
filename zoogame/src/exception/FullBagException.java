package exception;

public class FullBagException extends Exception{

    public FullBagException(String message) {
        super(message);
    }

    public FullBagException() {
        super("Bag is full!");
    }

}
