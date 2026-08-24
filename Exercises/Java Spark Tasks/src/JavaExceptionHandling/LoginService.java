package JavaExceptionHandling;

public class LoginService {


    void login(String username, String password) throws InvalidLoginException{
        if ((!username.equals("admin")) || (!password.equals("java123"))){
            throw new InvalidLoginException("Invalid username or password");
        }
        System.out.println("Login successfully!");
    }
}
