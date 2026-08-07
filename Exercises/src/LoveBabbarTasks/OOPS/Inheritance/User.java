package LoveBabbarTasks.OOPS.Inheritance;

public class User {
    String username;
    String password;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    void login(){
        System.out.println(username + " logged in.");
    }

    void logout(){
        System.out.println(username + " logged out.");
    }
}
