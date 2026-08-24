package JavaExceptionHandling;

public class Main {
    public static void main(String[] args) {
//        BankAccount account = new BankAccount(5000);
//
//        try {
//            account.withdraw(6000);
//        } catch (InsufficientBalanceException e){
//            System.out.println("Exception: " + e.getMessage());
//        }


//        LoginService login = new LoginService();
//        try {
//            login.login("admin", "wrong123");
//        } catch (InvalidLoginException e){
//            System.out.println("Login failed: " + e.getMessage());
//        }


        ProductServiceExtended service = new ProductServiceExtended();
        try {
            service.getProductById(105);
        } catch (InvalidProductIdException e){
            System.out.println("Invalid request: Please enter a valid product ID.");
        } catch (ProductNotFoundException e){
            System.out.println("Sorry, the requested product was not found.");
        }
    }
}
