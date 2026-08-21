package ArraysConstructorsThisSuperAndOOP;

public class CurrentAccount extends Account{
    @Override
    void calculateInterest() {
        System.out.println("Current Account interest: 2%");
    }
}
