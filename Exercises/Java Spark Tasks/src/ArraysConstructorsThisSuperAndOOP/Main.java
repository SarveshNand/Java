package ArraysConstructorsThisSuperAndOOP;

public class Main {
    static void main(String[] args) {
//        Array Maximum
        int[] arr1 = new int[5];
        arr1[0] = 12;
        arr1[1] = 45;
        arr1[2] = 23;
        arr1[3] = 67;
        arr1[4] = 34;
//        int max = arr1[0];
//        for (int i: arr1){
//            if (max < i){
//                max = i;
//            }
//        }
//        System.out.println("Output: " + max);

//        Count Even And Odd Numbers
        int evenCount = 0;
        int oddCount = 0;
        for (int i: arr1){
            if (i % 2 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even count: " + evenCount);
        System.out.println("Odd count: " + oddCount);


        Apprentice[] students = new Apprentice[3];
        students[0] = new Apprentice("Ramesh", 65.7);
        students[1] = new Apprentice("Sweety", 72.7);
        students[2] = new Apprentice("Swati", 87.2);
        for (Apprentice arr: students){
            arr.showDetails();
        }

        Product p1 = new Product("Genie", 100, 2);
        Product p2 = new Product("Ashwani", 200, 3);
        Product p3 = new Product("Product3", 150, 1);
        p1.showBill();
        p2.showBill();
        p3.showBill();
        double totalBill = p1.calculateTotal() + p2.calculateTotal() + p3.calculateTotal();
        System.out.println("Total Bill = " + totalBill);

        Employee e1 = new Employee(101, "Ashwani");
        Employee e2 = new Employee(102, "Rahul", 25000);
        e1.display();
        e2.display();

        Course c1 = new Course("Java", 6);
        Course c2 = new Course("Python", 4, 20000);
        c1.display();
        System.out.println();
        c2.display();

        Car car = new Car("Toyota", 180, "Petrol");
        car.showCarDetails();

        SavingsAccount savings = new SavingsAccount();
        CurrentAccount current = new CurrentAccount();
        savings.calculateInterest();
        current.calculateInterest();

        BankAccount account = new BankAccount("ACC101", 10000);
        account.deposit(5000);
        account.withdraw(3000);
        System.out.println("Current Balance: " + account.getBalance());



        Student student = new Student("Ashwani", "ashwani@gmail.com", "Java Backend");
        Trainer trainer = new Trainer("Genie", "genie@gmail.com", "Java Programming");
        System.out.println("----- Student Profile -----");
        student.showProfile();
        System.out.println();
        System.out.println("----- Trainer Profile -----");
        trainer.showProfile();
    }
}
