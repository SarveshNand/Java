package OperatorsAndDecisionMaking;

public class SimpleMenu {
    public static void main(String[] args){
        int choice = 4;
        switch (choice){
            case 1:
                System.out.println("Add money");
                break;
            case 2:
                System.out.println("Withdraw money");
                break;
            case 3:
                System.out.println("Check balance");
                break;
            case 4:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
