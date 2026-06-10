package Task2;

import java.util.Scanner;
public class profitLossCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Cost Price: ");
        double costPrice = input.nextDouble();

        System.out.print("Selling Price:");
        double sellingPrice = input.nextDouble();

        double profit = sellingPrice - costPrice;
        double loss = costPrice - sellingPrice;

        double profitPercentage = (profit/costPrice) * 100;
        double lossPercentage = (loss/costPrice) * 100;

        if (profit < loss) {
            System.out.println("Loss: $" + loss);
            System.out.println("Loss%: $" + lossPercentage);
        } else if (profit > loss) {
            System.out.println("Profit: $" + profit);
            System.out.println("Profit%: $" + profitPercentage);
        }  else {
            System.out.println("No Profit No Loss");
        }
    }
}
