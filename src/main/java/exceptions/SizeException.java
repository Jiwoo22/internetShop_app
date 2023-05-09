package exceptions;

public class SizeException extends Exception{
    public SizeException(String message){
        super(message);
        System.out.println(message);
    }
}
