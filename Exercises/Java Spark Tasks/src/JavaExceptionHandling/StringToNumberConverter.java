package JavaExceptionHandling;

public class StringToNumberConverter {
    public static void main(String[] args) {
        String[] values = {"123", "abc", "10a"};
        for (String value: values){
            try {
                int number = Integer.parseInt(value);
                System.out.println(value + " -> " + number);
            } catch (NumberFormatException e){
                System.out.println(value + " -> Invalid number");
            }
        }
    }
}
