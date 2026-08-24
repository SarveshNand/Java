package JavaExceptionHandling;

class ProductNotFoundException extends RuntimeException{
    ProductNotFoundException(String message){
        super(message);
    }
}
