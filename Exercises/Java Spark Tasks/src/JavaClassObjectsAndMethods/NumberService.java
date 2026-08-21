package JavaClassObjectsAndMethods;

public class NumberService {
    int calculateSum(int[] numbers){
        int sum = 0;
        for (int i=0; i<numbers.length; i++){
            sum += numbers[i];
        }
        return sum;
    }
}
