package Generic;

public class Calculator<T extends Number> {
    private T value;

    public Calculator(T value){
        this.value = value;
    }

    public double square(){
        double number = value.doubleValue();
        return number*number;
    }

    public T getValue(){
        return value;
    }
}
