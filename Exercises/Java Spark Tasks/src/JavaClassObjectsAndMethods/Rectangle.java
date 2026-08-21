package JavaClassObjectsAndMethods;

public class Rectangle {
    double length;
    double width;

    double calculateArea(){
        return length * width;
    }
    double calculatePerimeter(){
        return 2*(length+width);
    }
}
