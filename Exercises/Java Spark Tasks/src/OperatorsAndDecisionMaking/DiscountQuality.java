package OperatorsAndDecisionMaking;

public class DiscountQuality {
    static void main() {
        boolean isStudent = true;
        boolean isSeniorCitizen = false;
        if (isStudent || isSeniorCitizen){
            System.out.println("Discount available");
        } else {
            System.out.println("No discount");
        }
    }
}
