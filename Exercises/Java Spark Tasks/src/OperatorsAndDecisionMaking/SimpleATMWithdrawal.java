package OperatorsAndDecisionMaking;

public class SimpleATMWithdrawal {
    public static void main(String[] args){
        int balance = 5000;
        int withdrawAmount = 2000;

        if (withdrawAmount <= balance) {
            balance = balance - withdrawAmount;
            System.out.println("Withdrawal successful");
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
