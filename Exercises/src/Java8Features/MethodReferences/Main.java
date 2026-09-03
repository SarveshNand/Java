package Java8Features.MethodReferences;

import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> names = List.of("Rahul", "Amit", "Priya", "Neha", "Ravi");

//        Print every name using forEach().
//        names.forEach(name -> System.out.println(name));
//        names.forEach(System.out::println);



//        Create a new list containing all names in uppercase.
//        names.stream()
//                .map(name -> name.toUpperCase())
//                .forEach(System.out::println);
//        names.stream()
//                .map(String::toUpperCase)
//                .forEach(System.out::println);


//        Create a list containing the length of every name.
        List<Integer> lengths = names.stream()
                .map(String::length)
                .toList();
        System.out.println(lengths);
    }
}
