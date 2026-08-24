package JavaExceptionHandling;

public class NullNameChecker {

//    static void printNameLength(String name) {
//        try {
//            System.out.println("Name length: " + name.length());
//        } catch (NullPointerException e) {
//            System.out.println("Name cannot be null");
//        }
//    }

    static void printNameLength(String name){
        if (name != null){
            System.out.println("Name length: " + name.length());
        } else {
            System.out.println("Name cannot be null");
        }
    }

    public static void main(String[] args) {
        printNameLength("Ashwani");
        printNameLength(null);
    }
}
