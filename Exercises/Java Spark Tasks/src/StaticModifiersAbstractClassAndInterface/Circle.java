package StaticModifiersAbstractClassAndInterface;

public class Circle extends Shape{
    double radius = 5;

    @Override
    void calculateArea(){
        double area = Math.PI * radius * radius;
        System.out.println("Circle Area: " + area);
    }
}
