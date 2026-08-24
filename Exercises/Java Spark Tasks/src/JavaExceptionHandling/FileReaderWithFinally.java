package JavaExceptionHandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderWithFinally {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("student.txt");
            System.out.println("File opened successfully.");
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("File closed successfully.");
                }
            } catch (IOException e) {
                System.out.println("Error while closing file: " + e.getMessage());
            }
        }
    }
}
