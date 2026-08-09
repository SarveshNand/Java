package LoveBabbarTasks.OOPS.Abstraction;

public class SalaryAccount extends Account{

    SalaryAccount(String accountNumber, String accountHolder, double balance){
        super(accountNumber, accountHolder, balance);
    }

    @Override
    void withdraw(double amount){
        if (amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void creditSalary(double salary){
        if (salary > 0){
            balance += salary;
            System.out.println("Salary credited: " + salary);
        }
    }
}
