package JavaExceptionHandling;

public class InvalidProductIdException extends RuntimeException{
    InvalidProductIdException(String message){
        super(message);
    }
}
