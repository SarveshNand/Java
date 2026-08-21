package LoopsClassesAndObjects;

public class Main {
    public static void main(String[] args){
        Student student1 = new Student();
        student1.name = "Ramesh";
        student1.rollNumber = 45;
        student1.age = 18;
        student1.marks = 78;
        System.out.println(student1.name);
        System.out.println(student1.rollNumber);
        System.out.println(student1.age);
        System.out.println(student1.marks);

        Student student2 = new Student();
        student2.name = "Suresh";
        student2.rollNumber = 55;
        student2.age = 19;
        student2.marks = 68;
        System.out.println(student2.name);
        System.out.println(student2.rollNumber);
        System.out.println(student2.age);
        System.out.println(student2.marks);

        Car car1 = new Car();
        car1.brand = "Hyundai";
        car1.color = "Black";
        car1.price = 600_000;
        System.out.println(car1.brand);
        System.out.println(car1.color);
        System.out.println(car1.price);

        Car car2 = new Car();
        car2.brand = "Porsche";
        car2.color = "Pink";
        car2.price = 1_000_000;
        System.out.println(car2.brand);
        System.out.println(car2.color);
        System.out.println(car2.price);

        Product product = new Product();
        product.price = 60000;
        product.quantity = 150;
        double totalPrice = product.price * product.quantity;
        System.out.println(totalPrice);

        Employee employee = new Employee();
        employee.monthlySalary = 75000;
        double annualSalary = employee.monthlySalary * 12;
        System.out.println(annualSalary);

        BankAccount bankAccount = new BankAccount();
        bankAccount.accountHolder = "Shristi";
        bankAccount.accountNumber = "123245";
        bankAccount.balance = 780000;
        System.out.println(bankAccount.accountHolder);
        System.out.println(bankAccount.accountNumber);
        System.out.println(bankAccount.balance);

//------------------------------------------------------------------------------------------------------------------------------------------------------------

        Student student3 = new Student();
        student3.name = "Ramesh";
        student3.rollNumber = 45;
        student3.age = 18;
        student3.marks = 78;

        Student student4 = new Student();
        student4.name = "Suresh";
        student4.rollNumber = 55;
        student4.age = 19;
        student4.marks = 68;

        Student student5 = new Student();
        student5.name = "Ramesh";
        student5.rollNumber = 45;
        student5.age = 18;
        student5.marks = 88;

        Student highest;

        if (student3.marks >= student4.marks && student3.marks >= student5.marks) {
            highest = student3;
        } else if (student4.marks >= student3.marks && student4.marks >= student5.marks) {
            highest = student4;
        } else {
            highest = student5;
        }
        System.out.println("Student with highest marks:");
        System.out.println("Name: " + highest.name);
        System.out.println("Marks: " + highest.marks);



        Product product1 = new Product();
        product1.name = "Washing Machine";
        product1.price = 70000;
        product1.stock = 150;
        Product product2 = new Product();
        product1.name = "Radio";
        product2.price = 8000;
        product2.stock = 0;
        Product product3 = new Product();
        product1.name = "Oven";
        product3.price = 6000;
        product3.stock = 10;
        if (product1.stock > 0){
            System.out.println(product1.name);
        }
        if (product2.stock > 0){
            System.out.println(product2.name);
        }
        if (product3.stock > 0){
            System.out.println(product3.name);
        }



        Employee employee2 = new Employee();
        employee2.name = "Ashwani";
        employee2.salary = 50000;
        employee2.experience = 6;
        if (employee2.experience >= 5){
            employee2.salary += employee2.salary * .10;
        }
        System.out.println("Employee: " + employee2.name);
        System.out.println("Final Salary: " + employee2.salary);


        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();
        students[0].name = "Rahul";
        students[0].marks = 85;
        students[1].name = "Priya";
        students[1].marks = 92;
        students[2].name = "Aman";
        students[2].marks = 78;
        for (int i = 0; i<students.length; i++){
            System.out.println("Name: " + students[i].name);
            System.out.println("Marks: " + students[i].marks);
        }
    }
}
