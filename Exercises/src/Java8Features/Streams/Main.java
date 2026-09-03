package Java8Features.Streams;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main(String[] args) {
        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 35, 40);


//        Get only numbers greater than 20.
//        List<Integer> greaterNum = numbers.stream()
//                .filter(number -> number > 20)
//                .toList();
//        System.out.println(greaterNum);



//        Get only even numbers.
//        List<Integer> evenNum = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .toList();
//        System.out.println(evenNum);



//        Create a new list where every number is multiplied by 2.
//        List<Integer> mul = numbers.stream()
//                .map(n->n*2)
//                .toList();
//        System.out.println(mul);



//        Get the first number greater than 25.
        int result = numbers.stream()
                .filter(n->n>25)
                .findFirst()
                .orElseThrow();
        System.out.println(result);
    }
}
