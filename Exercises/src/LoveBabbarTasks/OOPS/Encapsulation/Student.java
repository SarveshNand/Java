package LoveBabbarTasks.OOPS.Encapsulation;

public class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public void setAge(int age) {
        if (age >= 5 && age <= 100){
            this.age = age;
        }
        else {
            throw new IllegalStateException("Invalid age: " + this.age);
        }
    }
    public int getAge(){
        return this.age;
    }

    public void setMarks(double marks){
        if (marks >= 0 && marks <= 100){
            this.marks = marks;
        } else {
            throw new IllegalStateException("Invalid marks: " + this.marks);
        }
    }
    public double getMarks(){
        return this.marks;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
