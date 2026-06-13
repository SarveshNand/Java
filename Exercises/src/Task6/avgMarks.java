package Task6;

public class avgMarks {
    public static void main(String[] args) {
        int[] marks = {72, 92, 45, 88, 67};
        System.out.println("Average of the elements in array: " + average(marks));
    }

    static int average(int[] marks){
        int sum = 0;
        for(int i = 1; i < marks.length; i++){
            sum += marks[i];
        }
        int avg = sum / marks.length;
        return avg;
    }
}
