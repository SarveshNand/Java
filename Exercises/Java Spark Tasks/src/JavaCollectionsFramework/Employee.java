package JavaCollectionsFramework;

public class Employee implements Comparable<Employee>{
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other){
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Salary: ₹" + salary;
    }
}
