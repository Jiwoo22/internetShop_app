package exceptions;

public class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
        System.out.println(message);
    }
}