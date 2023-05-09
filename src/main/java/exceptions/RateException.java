package exceptions;

public class RateException extends Exception {
    public RateException(String message){
        super(message);
        System.out.println(message);
    }
}
