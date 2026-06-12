package Task5;

public class areaCalc {
    public static void main(String[] args) {
        System.out.println(circle(2));
        System.out.println(rectangle(4, 5));
    }
    static double circle(double radius){
        double areaOfCircle = (radius * radius) * 3.14159;
        return areaOfCircle;
    }
    static double rectangle(double length, double width){
        double areaOfRectangle = length * width;
        return areaOfRectangle;
    }
}
