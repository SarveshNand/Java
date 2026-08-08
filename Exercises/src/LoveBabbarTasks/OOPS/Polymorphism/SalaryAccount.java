package LoveBabbarTasks.OOPS.Polymorphism;

public class SalaryAccount extends BankAccount{
    String companyName;

    SalaryAccount(long accountNumber, String accountHolderName, double balance, String companyName){
        super(accountNumber, accountHolderName, balance);
        this.companyName = companyName;
    }

    @Override
    double calculateInterest(){
        return 0;
    }
}
