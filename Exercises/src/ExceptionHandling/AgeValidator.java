package ExceptionHandling;

public class AgeValidator {
    public static void validateAge(int age) throws UnderAgeException{
        if (age < 18){
            throw new UnderAgeException("Age must be 18 or above");
        }
        System.out.println("Age is valid");
    }
}
