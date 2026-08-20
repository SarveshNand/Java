package OperatorsAndDecisionMaking;

public class GradeCalculator {
    static void main() {
        int marks = 60;
        if (marks >= 90){
            System.out.println("A+");
        } else if (marks >= 75) {
            System.out.println("A");
        } else if (marks >= 60) {
            System.out.println("B");
        } else if (marks >= 40) {
            System.out.println("C");
        } else{
            System.out.println("Fail");
        }
    }
}
