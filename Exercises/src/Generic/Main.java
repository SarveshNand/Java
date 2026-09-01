package Generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static <T> void print(T value){
        System.out.println(value);
    }

//    public static <T> void printList(List<T> list){
//        for (T item: list){
//            System.out.println(item);
//        }
//    }

    public static void printList(List<?> list){
        for (Object item: list){
            System.out.println(item);
        }
    }

//    Producer -> extends
    static double sum(List<? extends Number> numbers){
        double total = 0;
        for (Number number: numbers){
            total += number.doubleValue();
        }
        return total;
    }

//    Consumer -> super
    static void addNumbers(List<? super Integer> list){
        list.add(10);
        list.add(20);
        list.add(30);
    }

    static void method1(List<?> list){
        System.out.println("method1: accepted");
    }

    static void method2(List<? extends Number> list){
        System.out.println("method2: accepted");
    }

    static void method3(List<? super Integer> list){
        System.out.println("method3: accepted");
    }



    static void main(String[] args) {
//        Box<String> box1 = new Box<>();
//        box1.set("Hello");
//        System.out.println(box1.get());
//
//        Box<Integer> box2 = new Box<>();
//        box2.set(100);
//        System.out.println(box2.get());


//        Pair<String, Integer> student = new Pair<>("Rahul", 21);
//        Pair<String, String> country = new Pair<>("India", "Delhi");
//        System.out.println(student.getKey());
//        System.out.println(student.getValue());
//        System.out.println(country.getKey());
//        System.out.println(country.getValue());


//        print("Hello");
//        print(100);
//        print(10.5);
//        print(true);


//        List<String> names = new ArrayList<>();
//        names.add("Rahul");
//        names.add("Amit");
//        names.add("Priya");
//        names.add("Neha");
//        names.add("Ankit");
//        System.out.println(names);
//
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(10);
//        numbers.add(20);
//        numbers.add(30);
//        numbers.add(40);
//        numbers.add(50);
//        System.out.println(numbers);


//        Map<Integer, String> students = new HashMap<>();
//        students.put(101, "Rahul");
//        students.put(102, "Amit");
//        students.put(103, "Priya");
//        System.out.println(students.get(102));
//
//        Map<String, Integer> marks = new HashMap<>();
//        marks.put("Rahul", 85);
//        marks.put("Amit", 90);
//        marks.put("Priya", 95);
//        System.out.println(marks.get("Rahul"));
//        System.out.println(marks.get("Amit"));
//        System.out.println(marks.get("Priya"));


//        List<String> names = new ArrayList<>();
//        names.add("Rahul");
//        names.add("Amit");
//        names.add("Priya");
//
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(10);
//        numbers.add(20);
//        numbers.add(30);
//
//        List<Double> prices = new ArrayList<>();
//        prices.add(10.5);
//        prices.add(20.5);
//        prices.add(30.5);
//
//        printList(names);
//        printList(numbers);
//        printList(prices);


//        List<String> names = List.of("Rahul", "Amit");
//        List<Integer> numbers = List.of(10, 20, 30);
//        printList(names);
//        printList(numbers);



//        List<Integer> integers = List.of(10, 20, 30);
//        List<Double> doubles = List.of(10.5, 20.5, 30.5);
//        List<Float> floats = List.of(1.5f, 2.5f, 3.5f);
//
//        System.out.println(sum(integers));
//        System.out.println(sum(doubles));
//        System.out.println(sum(floats));


//        ApiResponse<String> response1 = new ApiResponse<>("Success", "Request completed");
//        System.out.println(response1.getData());
//        System.out.println(response1.getMessage());
//
//        User user = new User(101, "Rahul");
//        ApiResponse<User> response2 = new ApiResponse<>(user, "User found");
//        System.out.println(response2.getData().getName());
//
//        List<User> users = List.of(
//                new User(101, "Rahul"),
//                new User(102, "Amit"),
//                new User(103, "Priya"));
//        ApiResponse<List<User>> response3 = new ApiResponse<>(users, "Users found");
//        System.out.println(response3.getData());



//        Calculator<Integer> intCalculator = new Calculator<>(10);
//        Calculator<Double> doubleCalculator = new Calculator<>(10.5);
//        System.out.println(intCalculator.getValue());
//        System.out.println(intCalculator.square());
//        System.out.println(doubleCalculator.getValue());
//        System.out.println(doubleCalculator.square());



//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(10);
//        numbers.add(20);
//        numbers.add(30);
//        method1(numbers);
//        method2(numbers);
//        method3(numbers);



//        List<Integer> integers = List.of(10, 20, 30);
//        List<Double> doubles = List.of(10.5, 20.5, 30.5);
//        List<Float> floats = List.of(1.5f, 2.5f, 3.5f);
//
//        System.out.println(sum(integers));
//        System.out.println(sum(doubles));
//        System.out.println(sum(floats));
//
//        // List<String> names = List.of("Rahul", "Amit");
//        // sum(names); // ❌ Not allowed
//
//        // Different lists for addNumbers()
//        List<Integer> numbers = new ArrayList<>();
//        addNumbers(numbers);
//
//        System.out.println(numbers);
//
//        List<Number> numberList = new ArrayList<>();
//        addNumbers(numberList);
//
//        System.out.println(numberList);
//
//        List<Object> objectList = new ArrayList<>();
//        addNumbers(objectList);
//
//        System.out.println(objectList);
//
//        // List<Double> decimalList = new ArrayList<>();
//        // addNumbers(decimalList); // ❌ Not allowed




        Repository<Client> clientRepository = new Repository<>();
        Repository<Product> productRepository = new Repository<>();

        clientRepository.save(new Client("Rahul"));
        clientRepository.save(new Client("Amit"));
        clientRepository.save(new Client("Priya"));

        productRepository.save(new Product("Laptop"));
        productRepository.save(new Product("Phone"));
        productRepository.save(new Product("Keyboard"));

        Client firstClient = clientRepository.findFirst();
        Product firstProduct = productRepository.findFirst();

        System.out.println("First Client: " + firstClient);
        System.out.println("First Product: " + firstProduct);

        List<Client> clients = clientRepository.findAll();
        List<Product> products = productRepository.findAll();

        System.out.println("Client: " + clients);
        System.out.println("Producrs: " + products);
    }
}
