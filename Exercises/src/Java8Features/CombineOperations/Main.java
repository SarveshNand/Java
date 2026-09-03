package Java8Features.CombineOperations;

import java.util.List;

public class Main {
    static void main(String[] args) {
        List<String> names = List.of("Rahul", "Amit", "Priya", "Raj", "Neha", "Rohan");


//        Find names whose length is greater than 4.
//        List<String> greater = names.stream()
//                .filter(n -> n.length() > 4)
//                .toList();
//        System.out.println(greater);



//        Find names whose length is greater than 4 and convert them to uppercase.
//        List<String> greaterUpper = names.stream()
//                .filter(n->n.length()>4)
//                .map(String::toUpperCase)
//                .toList();
//        System.out.println(greaterUpper);



//        Find names beginning with "R".
//        List<String> nameFind = names.stream()
//                .filter(n->n.startsWith("R"))
//                .toList();
//        System.out.println(nameFind);



//        Find names beginning with "R" and sort them alphabetically.
        List<String> nameSorted = names.stream()
                .filter(n->n.startsWith("R"))
                .sorted()
                .toList();
        System.out.println(nameSorted);
    }
}
