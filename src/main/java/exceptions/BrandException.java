package exceptions;

public class BrandException extends Exception {
    public BrandException(String message) {
        super(message);
        System.out.println(message);
    }
}