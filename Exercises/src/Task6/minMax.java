package Task6;

public class minMax {
    public static void main(String[] args) {
        int[] marks = new int[5];
        marks[0] = 72;
        marks[1] = 92;
        marks[2] = 45;
        marks[3] = 88;
        marks[4] = 67;

        System.out.println("Minimum: " + findMin(marks));
        System.out.println("Maximum: " + findMax(marks));
    }

    static int findMax(int[] marks){
        int max = marks[0];
        for (int i = 1; i < marks.length; i++){
            if (marks[i] > max){
                max = marks[i];
            }
        }
        return max;
    }

    static int findMin(int[] marks) {
        int min = marks[0];
        for (int i = 1; i < marks.length; i++){
            if(marks[i] < min){
                min = marks[i];
            }
        }
        return min;
    }
}
