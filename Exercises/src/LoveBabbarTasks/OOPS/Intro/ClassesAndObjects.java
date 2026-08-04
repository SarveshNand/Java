package LoveBabbarTasks.OOPS.Intro;

public class ClassesAndObjects {
    public static void main(String[] args){
//        Student A = new Student("Rahul", 1, 18);
//        System.out.println(A.name);
//        System.out.println(A.age);
//        System.out.println(A.rollNo);
//        A.displayDetails();
//
//        Student B = new Student("Rohit", 2, 18);
//        System.out.println(B.name);
//        System.out.println(B.age);
//        System.out.println(B.rollNo);
//        A.displayDetails();
//
//        Student C = new Student("Rama", 3, 19);
//        System.out.println(C.name);
//        System.out.println(C.age);
//        System.out.println(C.rollNo);
//        A.displayDetails();


//        Car one = new Car("Bugatti", "Divo", 410000000);
//        Car two = new Car("BMW", "M5", 20800000);
//        System.out.println(one.brand);
//        System.out.println(one.model);
//        System.out.println("₹" + one.price);
//        one.displayCar();
//
//        System.out.println(two.brand);
//        System.out.println(two.model);
//        System.out.println("₹" + two.price);
//        two.displayCar();


//        Book first = new Book("Behind You Is the Sea", "Susan Muaddi Darraj", 256);
//        Book second = new Book("Great Circle", "Maggie Shipstead", 593);
//        Book third = new Book("Small Things Like These", "Claire Keegan", 118);
//        Book fourth = new Book("Piranesi", "Susanna Clarke", 245);
//        Book fifth = new Book("The Will of the Many", "James Islington", 630);
//        System.out.println(first.title);
//        System.out.println(first.author);
//        System.out.println(first.pages);
//        first.showBook();
//
//        System.out.println(second.title);
//        System.out.println(second.author);
//        System.out.println(second.pages);
//        first.showBook();
//
//        System.out.println(third.title);
//        System.out.println(third.author);
//        System.out.println(third.pages);
//        first.showBook();
//
//        System.out.println(third.title);
//        System.out.println(third.author);
//        System.out.println(third.pages);
//        first.showBook();
//
//        System.out.println(fourth.title);
//        System.out.println(fourth.author);
//        System.out.println(fourth.pages);
//        first.showBook();
//
//        System.out.println(fifth.title);
//        System.out.println(fifth.author);
//        System.out.println(fifth.pages);
//        first.showBook();


//        Mobile m = new Mobile();
//        m.display();

//        Laptop l = new Laptop();
//        l.display();


//        Movie m1 = new Movie("The Shawshank Redemption", "Tim Robbins", 9.3);
//        Movie m2 = new Movie("The Godfather", "Marlon Brando", 9.2);
//        Movie m3 = new Movie("The Dark Knight", "Christian Bale", 9.1);
//        Movie m4 = new Movie("Schindler's List", "Liam Neeson", 9.0);
//        Movie m5 = new Movie("12 Angry Men", "Henry Fonda", 9.0);
//        m1.display();
//        m2.display();
//        m3.display();
//        m4.display();
//        m5.display();

//        BankAccount b = new BankAccount("Raman", 3243543, 50546.320);
//        b.display();

//        Product p = new Product("Iphone", 154000, 3455000);
//        System.out.println(p.productName);
//        System.out.println(p.price);
//        System.out.println(p.quantity);


//        ECommerceOrder e1 = new ECommerceOrder();        //Default
//        e1.orderId = 102;
//        e1.customerName = "Radha";
//        e1.totalAmount = 45;
//        e1.display();
//        ECommerceOrder e2 = new ECommerceOrder(101, "Shyam", 27);       //Parameterized
//        e2.display();


        FoodItem f1 = new FoodItem(106, "Pizza", "GO69", 699, 4.1);
        FoodItem f2 = new FoodItem(105, "Burger", "McDonald", 560, 4.3);
        FoodItem f3 = new FoodItem(104, "Biryani", "Khana Khazana", 980, 4.7);
        FoodItem f4 = new FoodItem(101, "Paneer Butter Masala", "Spice Hub", 320, 4.6);
        FoodItem f5 = new FoodItem(102, "Masala Dosa", "PC Cafe", 200, 4.5);
        FoodItem f6 = new FoodItem(103, "Chocolate Cake", "Dominos", 450, 4.8);
        f1.display();
        f2.display();
        f3.display();
        f4.display();
        f5.display();
        f6.display();

        f1.isPopular();
        f2.isExpensive();
    }
}
