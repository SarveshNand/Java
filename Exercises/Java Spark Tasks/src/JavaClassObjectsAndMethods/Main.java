package JavaClassObjectsAndMethods;

public class Main {
    static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Rahul";
        student1.rollNumber = 45;
        student1.age = 12;
        student1.marks = 88;
        System.out.println(student1.name);
        System.out.println(student1.rollNumber);
        System.out.println(student1.age);
        System.out.println(student1.marks);

        Student student2 = new Student();
        student2.name = "Saloni";
        student2.rollNumber = 55;
        student2.age = 13;
        student2.marks = 78;
        System.out.println(student2.name);
        System.out.println(student2.rollNumber);
        System.out.println(student2.age);
        System.out.println(student2.marks);

        Student student3 = new Student();
        student3.name = "Shreya";
        student3.rollNumber = 65;
        student3.age = 14;
        student3.marks = 98;
        System.out.println(student3.name);
        System.out.println(student3.rollNumber);
        System.out.println(student3.age);
        System.out.println(student3.marks);


        Car car1 = new Car();
        car1.brand = "Mercedes";
        car1.model = "X";
        car1.color = "Red";
        car1.price = 4_500_000;
        System.out.println(car1.brand);
        System.out.println(car1.model);
        System.out.println(car1.color);
        System.out.println(car1.price);

        Car car2 = new Car();
        car2.brand = "Lamborghini";
        car2.model = "Gallardo";
        car2.color = "Yellow";
        car2.price = 9_945_000;
        System.out.println(car2.brand);
        System.out.println(car2.model);
        System.out.println(car2.color);
        System.out.println(car2.price);


        Employee emp = new Employee();
        emp.employeeId = 101;
        emp.employeeName = "Genie Ashwani";
        emp.monthlySalary = 50000;
        double annualSalary = emp.monthlySalary * 12;
        System.out.println("Employee ID: " + emp.employeeId);
        System.out.println("Employee Name: " + emp.employeeName);
        System.out.println("Monthly Salary: " + emp.monthlySalary);
        System.out.println("Annual Salary: " + annualSalary);

        Product p = new Product();
        p.name = "Laptop";
        p.price = 50000;
        p.quantity = 2;
        double totalPrice = p.price * p.quantity;
        System.out.println("Product Name: " + p.name);
        System.out.println("Price: " + p.price);
        System.out.println("Quantity: " + p.quantity);
        System.out.println("Total Price: " + totalPrice);

        Calculator calc = new Calculator();
//        System.out.println("Addition: " + calc.add(10, 5));
        calc.displayMessage();
        calc.add(10, 5);
        System.out.println("Subtraction: " + calc.subtract(10, 5));
        System.out.println("Multiplication: " + calc.multiply(10, 5));
        System.out.println("Division: " + calc.divide(10, 5));

        Rectangle r = new Rectangle();
        r.length = 10;
        r.width = 5;
        System.out.println("Area: " + r.calculateArea());
        System.out.println("Perimeter: " + r.calculatePerimeter());

        BankAccount account = new BankAccount();
        account.accountHolder = "Genie Ashwani";
        account.balance = 10000;
        account.deposit(5000);
        account.withdraw(2000);
        account.displayBalance();


        Inventory inventory = new Inventory();
        inventory.name = "Laptop";
        inventory.stock = 10;
        inventory.addStock(5);
        inventory.sell(8);
        inventory.sell(10);
        System.out.println("Product: " + inventory.name);
        System.out.println("Available Stock: " + inventory.stock);


        Student[] students = new Student[3];
        students[0] = new Student();
        students[1] = new Student();
        students[2] = new Student();

        students[0].studentId = 101;
        students[0].name = "Ashwani";
        students[0].rollNumber = 12;
        students[0].age = 19;
        students[0].marks = 85.5;

        students[1].studentId = 102;
        students[1].name = "Rahul";
        students[1].rollNumber = 45;
        students[1].age = 18;
        students[1].marks = 92.0;

        students[2].studentId = 103;
        students[2].name = "Amit";
        students[2].rollNumber = 11;
        students[2].age = 19;
        students[2].marks = 78.5;

        for (int i = 0; i < students.length; i++) {
            students[i].displayDetails();
        }




        NumberService service = new NumberService();
        int[] numbers = {10, 20, 30, 40, 50};
        int result = service.calculateSum(numbers);
        System.out.println("Sum: " + result);
    }
}
