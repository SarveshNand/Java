package JavaExceptionHandling;

public class VoterService {
    void checkAge(int age){
        if (age<18){
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Allowed to vote");
    }

    public static void main(String[] args) {
        VoterService voterService = new VoterService();
        try {
            voterService.checkAge(16);
        } catch (IllegalArgumentException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
