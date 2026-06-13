package Task6;

public class secondHighest {
    public static void main(String[] args) {
        int[] marks = {72, 92, 45, 88, 67};
        System.out.println("The second highest element in the array: " + finder(marks));
    }

    static int finder(int[] marks) {
        int highest = Integer.MIN_VALUE;
        int secondhighest = Integer.MIN_VALUE;
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                secondhighest = highest;
                highest = marks[i];
            }
            else if (marks[i] > secondhighest) {
                secondhighest = marks[i];
            }
        }
        return secondhighest;
    }
}
