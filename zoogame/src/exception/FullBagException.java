package exception;

public class FullBagException extends Exception{

    public FullBagException() {
        super("Bag is full!");
    }

    public FullBagException(String message) {
        super(message);
    }

}
