package StaticModifiersAbstractClassAndInterface;

public class Rectangle extends Shape{
    double length = 10;
    double width = 5;

    @Override
    void calculateArea(){
        double area = length * width;
        System.out.println("Rectangle Area: " + area);
    }
}
