package JavaExceptionHandling;

public class InvalidLoginException extends Exception{
    InvalidLoginException(String message){
        super(message);
    }
}
