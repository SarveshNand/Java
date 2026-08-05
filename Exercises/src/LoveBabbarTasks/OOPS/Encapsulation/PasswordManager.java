package LoveBabbarTasks.OOPS.Encapsulation;

public class PasswordManager {
    private String username;
    private String password;

    public PasswordManager(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void login(String username, String password){
        if (this.username.equals(username) && this.password.equals(password)){
            System.out.println("Login Successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
    public void changePassword(String oldPassword, String newPassword){
        if (!this.password.equals(oldPassword)){
            System.out.println("Old password is incorrect.");
            return;
        }
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }

    public String getUsername() {
        return username;
    }
}
