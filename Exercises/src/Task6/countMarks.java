package Task6;

public class countMarks {
    public static void main(String[] args) {
        int[] marks = {72, 92, 45, 88, 67};
        System.out.println("The total number of students scoring above 75: " + count(marks));
    }

    static int count(int[] marks){
        int counter = 0;
        for(int i = 1; i < marks.length; i++){
            if(marks[i] > 75){
                counter++;
            }
        }
        return counter;
    }
}
