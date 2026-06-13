package Task6;

public class sumArr {
    public static void main(String[] args){
        int[] marks = {72, 92, 45, 88, 67};

        int sum = 0;
        for(int i = 1; i < marks.length; i++){
            sum += marks[i];
        }
        System.out.println("Sum of the elements in array: " + sum);
    }
}
