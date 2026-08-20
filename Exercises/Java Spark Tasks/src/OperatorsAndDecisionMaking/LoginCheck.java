package OperatorsAndDecisionMaking;

public class LoginCheck {
    static void main() {
        String username = "admin";
        String password = "1234";
        if (username == "admin" && password == "1234"){
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid login");
        }
    }
}
