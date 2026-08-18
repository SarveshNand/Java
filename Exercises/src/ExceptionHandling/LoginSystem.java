package ExceptionHandling;

public class LoginSystem {
    final int MAX_LOGIN_ATTEMPTS = 3;
    static int loginAttemps = 0;

    public void login(String username, String password){
        loginAttemps++;
        if (loginAttemps > MAX_LOGIN_ATTEMPTS){
            System.out.println("Maximum login attempts exceeded");
            return;
        }
        if (username.equals("admin") && password.equals("1234")){
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid username or password");
        }
        System.out.println("Attempt: " + loginAttemps);
    }
}
