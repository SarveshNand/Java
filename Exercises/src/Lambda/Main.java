package Lambda;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    static void main(String[] args) {
//        Greeting greeting = (name) -> {
//            System.out.println("Hello " + name);
//        };
//        greeting.sayHello("Rahul");


//        Calculator addition = (a, b) -> a+b;
//        System.out.println(addition.calculate(10, 20));


//        Calculator multiplication = (a, b) -> a*b;
//        System.out.println(multiplication.calculate(5, 4));


//        NumberChecker checker = (number) -> number % 2 == 0;
//        System.out.println(checker.check(10));
//        System.out.println(checker.check(7));


//        Predicate<Integer> isGreaterThan50 = number -> number > 50;
//        System.out.println(isGreaterThan50.test(60));
//        System.out.println(isGreaterThan50.test(30));


//        Predicate<String> isEmpty = str -> str.isEmpty();
//        System.out.println(isEmpty.test(""));
//        System.out.println(isEmpty.test("Java"));


//        Function<String, Integer> getLength = str -> str.length();
//        System.out.println(getLength.apply("Java"));
//        System.out.println(getLength.apply("Backend"));


//        Function<Integer, Integer> numSquare = number -> number*number;
//        System.out.println(numSquare.apply(5));
//        System.out.println(numSquare.apply(10));


//        Consumer<String> greet = name -> System.out.println("Hello, " + name);
//        greet.accept("Rahul");


//        Supplier<String> message = () -> "Welcome to Java Backend Development";
//        System.out.println(message.get());


//        Predicate<Integer> isPositive = number -> number > 0;
//        System.out.println(isPositive.test(10));
//        System.out.println(isPositive.test(-5));


//        Function<String, String> upper = str -> str.toUpperCase();
//        System.out.println(upper.apply("santa"));
//        System.out.println(upper.apply("cLown"));


//        Consumer<String> print = str -> System.out.println(str);
//        print.accept("Shakira");
//        print.accept("Leo");


//        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
//        System.out.println(randomNumber.get());


//        List<String> names = List.of("Rahul", "Amit", "Rohan", "Priya", "Raj");
//        names.forEach(n -> System.out.println(n));
//        names.forEach(n -> System.out.println("Hello " + n));


//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
//        numbers.forEach(n -> {
//            if (n%2==0){
//                System.out.println(n);
//            }
//        });


//        numbers.stream()
//                .filter(number -> number % 2 == 0)
//                .forEach(number -> System.out.println(number));



//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        numbers.stream()
//                .map(n -> n*n)
//                .forEach(n -> System.out.println(n));



        List<String> names = List.of("Rahul", "Amit", "Rohan", "Raj", "Priya");
        names.stream()
                .filter(str -> str.length() > 4)
                .forEach(n -> System.out.println(n));
    }
}
