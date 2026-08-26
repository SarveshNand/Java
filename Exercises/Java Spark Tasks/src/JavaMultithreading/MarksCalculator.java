package JavaMultithreading;

import java.util.concurrent.Callable;

public class MarksCalculator implements Callable<Integer> {
    @Override
    public Integer call(){
        int[] marks = {80, 75, 90, 85, 70};
        int total = 0;
        for (int mark: marks){
            total += mark;
        }
        return total;
    }
}
