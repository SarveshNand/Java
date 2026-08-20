package OperatorsAndDecisionMaking;

public class ElectricityBill {
    public static void main(String[] args){
        int units = 180;
        int bill;
        if (units <= 100){
            bill = units * 5;
        } else {
            bill = (100*5)+((units-100)*8);
        }
        System.out.println(bill);
    }
}
