package JavaCollectionsFramework;

import java.util.*;

public class Main {
    static void main(String[] args) {
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student(101, "Genie", 85.5));
//        students.add(new Student(102, "Ashwani", 90.0));
//        students.add(new Student(103, "Rahul", 78.5));
//        students.add(new Student(104, "Priya", 92.0));
//        students.add(new Student(105, "Amit", 88.0));
//
//        int searchId = 103;
//        boolean found = false;
//
//        for (Student student: students){
//            if (student.id == searchId){
//                System.out.println("ID: " + student.id + ", Name: " + student.name + ", Marks: " + student.marks);
//                found = true;
//                break;
//            }
//        }
//        if (!found){
//            System.out.println("Student not found");
//        }






//        List<String> emails = new ArrayList<>();
//        emails.add("rahul@gmail.com");
//        emails.add("priya@gmail.com");
//        emails.add("rahul@gmail.com");
//        emails.add("amit@gmail.com");
//        emails.add("priya@gmail.com");
////        Set<String> uniqueEmails = new HashSet<>(emails);
////        for (String email: uniqueEmails){
////            System.out.println(email);
////        }
//        Set<String> uniqueEmails = new LinkedHashSet<>(emails);
//        for (String email: uniqueEmails){
//            System.out.println(email);
//        }





//        TreeSet<Integer> rollNumbers = new TreeSet<>();
//        rollNumbers.add(105);
//        rollNumbers.add(102);
//        rollNumbers.add(109);
//        rollNumbers.add(101);
//        rollNumbers.add(104);
//
//        for (Integer roll: rollNumbers){
//            System.out.println(roll);
//        }




//        Map<Integer, Product> products = new HashMap<>();
//        products.put(101, new Product(101, "Laptop", 55000));
//        products.put(102, new Product(102, "Mobile", 25000));
//        products.put(103, new Product(103, "Keyboard", 1500));
//        products.put(104, new Product(104, "Mouse", 800));
//        products.put(105, new Product(105, "Monitor", 12000));
//
//        int searchId = 103;
//
//        Product product = products.get(searchId);
//        if (product != null){
//            product.display();
//        } else {
//            System.out.println("Product not found");
//        }




//        String input = "java spring java sql spring java";
//        String[] words = input.split(" ");
//        Map<String, Integer> frequency = new HashMap<>();
//        for (String word : words){
//            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
//        }
//        for (Map.Entry<String, Integer> entry: frequency.entrySet()){
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }





//        String input = "banana";
//        Map<Character, Integer> charCountMap = new HashMap<>();
//        for (char ch: input.toCharArray()){
//            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
//        }
//        charCountMap.forEach((key, value) -> System.out.println(key + ": " + value));




//        List<shoppingProduct> cart = new ArrayList<>();
//        cart.add(new shoppingProduct("Laptop", 50000));
//        cart.add(new shoppingProduct("Mouse", 800));
//        cart.add(new shoppingProduct("Keyboard", 1500));
//        cart.add(new shoppingProduct("Headphones", 2000));
//        double total = 0;
//        for (shoppingProduct product: cart){
//            total += product.price;
//        }
//        System.out.println("Total Bill: ₹" + total);




//        PriorityQueue<SupportTicket> tickets = new PriorityQueue<>((t1, t2) -> Integer.compare(t1.priority, t2.priority));
//        tickets.add(new SupportTicket(101, "Login problem", 3));
//        tickets.add(new SupportTicket(102, "Server down", 1));
//        tickets.add(new SupportTicket(103, "Password reset", 2));
//        tickets.add(new SupportTicket(104, "UI issue", 4));
//        System.out.println("Processing Support Tickets: ");
//        while (!tickets.isEmpty()){
//            SupportTicket ticket = tickets.poll();
//            System.out.println(ticket);
//        }




//        ArrayDeque<String> stack = new ArrayDeque<>();
//        stack.push("Home");
//        stack.push("Courses");
//        stack.push("Java");
//        stack.push("Collections");
//        stack.pop();
//        System.out.println("Current page: " + stack.peek());




//        List<StudentSort> students = new ArrayList<>();
//        students.add(new StudentSort(101, "Rahul", 75));
//        students.add(new StudentSort(102, "Priya", 90));
//        students.add(new StudentSort(103, "Amit", 60));
//        students.add(new StudentSort(104, "Neha", 85));
//
//        students.sort(Comparator.comparingDouble(s -> s.marks));
//        System.out.println("Marks Ascending:");
//        for (StudentSort student: students){
//            System.out.println(student);
//        }
//        students.sort(Comparator.comparingDouble((StudentSort s) -> s.marks).reversed());
//        System.out.println("\n Marks Descending:");
//        for (StudentSort student: students){
//            System.out.println(student);
//        }




//        List<ProductSort> products = new ArrayList<>();
//        products.add(new ProductSort(101, "Laptop", 50000));
//        products.add(new ProductSort(102, "Mouse", 800));
//        products.add(new ProductSort(103, "Keyboard", 800));
//        products.add(new ProductSort(104, "Monitor", 12000));
//        products.sort(Comparator.comparingDouble((ProductSort p) -> p.price).thenComparing(p -> p.name));
//        System.out.println("Sorted Products:");
//        for (ProductSort p: products){
//            System.out.println(p);
//        }




//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(103, "Rahul", 45000));
//        employees.add(new Employee(101, "Priya", 50000));
//        employees.add(new Employee(104, "Amit", 40000));
//        employees.add(new Employee(102, "Neha", 55000));
//        Collections.sort(employees);
//        System.out.println("Employees sorted by ID:");
//        for (Employee employee: employees){
//            System.out.println(employee);
//        }




//        ArrayList<String> enrolledStudents = new ArrayList<>();
//        enrolledStudents.add("Rahul");
//        enrolledStudents.add("Priya");
//        enrolledStudents.add("Amit");
//        enrolledStudents.add("Neha");
//
//        HashSet<String> uniqueEmails = new HashSet<>();
//        uniqueEmails.add("rahul@gmail.com");
//        uniqueEmails.add("priya@gmail.com");
//        uniqueEmails.add("amit@gmail.com");
//        uniqueEmails.add("rahul@gmail.com");
//
//        HashMap<Integer, String> courses = new HashMap<>();
//        courses.put(101, "Java Programming");
//        courses.put(102, "Data Structures");
//        courses.put(103, "Database Management");
//        courses.put(104, "Web Development");
//
//        TreeSet<Integer> rollNumbers = new TreeSet<>();
//        rollNumbers.add(105);
//        rollNumbers.add(101);
//        rollNumbers.add(103);
//        rollNumbers.add(102);
//        rollNumbers.add(101);
//
//        LinkedHashSet<String> uploadedEmails = new LinkedHashSet<>();
//        uploadedEmails.add("student1@gmail.com");
//        uploadedEmails.add("student2@gmail.com");
//        uploadedEmails.add("student3@gmail.com");
//        uploadedEmails.add("student1@gmail.com");
//
//        System.out.println("Enrolled Students:");
//        System.out.println(enrolledStudents);
//
//        System.out.println("\nUnique Emails:");
//        System.out.println(uniqueEmails);
//
//        System.out.println("\nCourses:");
//        System.out.println(courses);
//
//        System.out.println("\nSorted Roll Numbers:");
//        System.out.println(rollNumbers);
//
//        System.out.println("\nUploaded Emails (Insertion Order):");
//        System.out.println(uploadedEmails);











        Course course = new Course(101, "Java Programming");
        StudentCourse s1 = new StudentCourse(1, "Rahul", "rahul@gmail.com", 75);
        StudentCourse s2 = new StudentCourse(2, "Priya", "priya@gmail.com", 45);
        StudentCourse s3 = new StudentCourse(3, "Amit", "amit@gmail.com", 60);
        StudentCourse s4 = new StudentCourse(4, "Neha", "neha@gmail.com", 35);

        course.addStudent(s1);
        course.addStudent(s2);
        course.addStudent(s3);
        course.addStudent(s4);

        HashSet<String> emails = new HashSet<>();
        for (StudentCourse student : course.students) {
            if (emails.add(student.email)) {
                System.out.println("Email added: " + student.email);
            } else {
                System.out.println("Duplicate email: " + student.email);
            }
        }

        HashMap<Integer, StudentCourse> studentMap = new HashMap<>();
        for (StudentCourse student : course.students) {
            studentMap.put(student.id, student);
        }
        System.out.println("\nSearch student with ID 3:");
        StudentCourse foundStudent = studentMap.get(3);
        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found");
        }

        TreeSet<Integer> sortedMarks = new TreeSet<>();
        for (StudentCourse student : course.students) {
            sortedMarks.add(student.marks);
        }
        System.out.println("\nSorted Marks:");
        System.out.println(sortedMarks);

        PriorityQueue<StudentCourse> extraClassQueue = new PriorityQueue<>(Comparator.comparingInt(student -> student.marks));
        extraClassQueue.addAll(course.students);
        System.out.println("\nExtra Class - Lowest Marks First:");
        while (!extraClassQueue.isEmpty()) {
            StudentCourse student = extraClassQueue.poll();
            System.out.println(student);
        }

        System.out.println("\nAll Students in Course:");
        for (StudentCourse student : course.students) {
            System.out.println(student);
        }
    }
}
