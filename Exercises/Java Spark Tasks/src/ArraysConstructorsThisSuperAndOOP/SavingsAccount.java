package ArraysConstructorsThisSuperAndOOP;

public class SavingsAccount extends Account{
    @Override
    void calculateInterest() {
        System.out.println("Savings Account interest: 5%");
    }
}
