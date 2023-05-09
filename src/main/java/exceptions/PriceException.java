package exceptions;

public class PriceException extends Exception{
    public PriceException(String message){
        super(message);
        System.out.println(message);
    }
}