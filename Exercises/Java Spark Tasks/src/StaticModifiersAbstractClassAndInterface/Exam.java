package StaticModifiersAbstractClassAndInterface;

public class Exam {
    final int MAX_MARKS = 100;

    void showMaxMarks(){
        System.out.println(MAX_MARKS);
    }

    void changeMarks() {
        // MAX_MARKS = 200;
        // ERROR: cannot assign a value to final variable MAX_MARKS
        // A final variable can be assigned only once.
    }
}
