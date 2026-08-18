package ExceptionHandling;

public class Main {
    public static void main(String[] args) {
//        BankAccount account = new BankAccount(12345, "Ritvik", 0);
//        try {
//            account.deposit(5000);
//            account.withdraw(6000);
//        } catch (InvalidAmountException e) {
//            System.out.println("Invalid amount: " + e.getMessage());
//        } catch (InsufficientBalanceException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        System.out.println("Balance: " + account.getBalance());


//        try{
//            AgeValidator.validateAge(16);
//        } catch (UnderAgeException e){
//            System.out.println(e.getMessage());
//        }


//        ATM atm = new ATM(5000);
//        try {
//            atm.withdraw(6000);
//        } catch (InsufficientBalanceException e){
//            System.out.println("Error: " + e.getMessage());
//        }


        LoginSystem login = new LoginSystem();
        login.login("admin", "wrong");
        login.login("admin", "wrong");
        login.login("admin", "1234");
        login.login("admin", "1234");
    }
}
