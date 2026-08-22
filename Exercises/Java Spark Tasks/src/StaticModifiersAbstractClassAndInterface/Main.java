package StaticModifiersAbstractClassAndInterface;

public class Main {
    static void main(String[] args) {
        Student s = new Student();
        s.name = "Rahul";
        s.marks = 75;
        s.showResult();

        Student s1 = new Student();
        s1.rollNumber = 101;
        s1.name = "Rahul";
        Student s2 = new Student();
        s2.rollNumber = 102;
        s2.name = "Aman";
        Student s3 = new Student();
        s3.rollNumber = 103;
        s3.name = "Priya";
        s1.showDetails();
        s2.showDetails();
        s3.showDetails();
        Student.instituteName = "XYZ Institute";
        System.out.println("After changing institute name:");
        s1.showDetails();
        s2.showDetails();
        s3.showDetails();

        Student st1 = new Student();
        Student st2 = new Student();
        Student st3 = new Student();
        Student st4 = new Student();
        Student st5 = new Student();
        Student.showTotalStudents();

        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2, 5));
        System.out.println(calculator.subtract(2, 5));
        System.out.println(calculator.multiply(2, 5));
        System.out.println(calculator.divide(2, 5));

        DatabaseConfig.showDatabaseName();

        BankAccount account = new BankAccount(101, 5000);
        account.deposit(2000);
        account.withdraw(1500);
        System.out.println("Current Balance: " + account.getBalance());

        Exam exam = new Exam();
        exam.showMaxMarks();

        Circle circle = new Circle();
        circle.showMessage();
        circle.calculateArea();
        Rectangle rectangle = new Rectangle();
        rectangle.showMessage();
        rectangle.calculateArea();

        Aspirant aspirant = new Aspirant("Rahul", "Java");
        aspirant.showAspirantDetails();

        NotificationService notification;
        notification = new EmailService();
        notification.send("Hello from Email!");
        notification = new SmsService();
        notification.send("Hello from SMS!");

        PrinterMachine printerMachine = new PrinterMachine();
        printerMachine.print();
        printerMachine.scan();




        UpiPayment upi = new UpiPayment("TXN101", "rahul@upi");
        CardPayment card = new CardPayment("TXN102", "1234-5678-9012-3456");
        PaymentGateway payment;
        payment = upi;
        payment.pay(1500);
        System.out.println();
        payment = card;
        payment.pay(2500);
    }
}
