package Java8Features.Optional;

import java.util.List;
import java.util.Optional;

public class Main {

//    Write a method:
//public List<String> getActiveAdultUserNames(List<User> users)
//Requirements:
//user must be active
//user must be at least 18
//return only their names
//names should be sorted alphabetically
//return a List<String>

    public static List<String> getActiveAdultUserNames(List<User> users){
        return users.stream()
                .filter(User::isActive)
                .filter(user->user.getAge()>=18)
                .map(User::getName)
                .sorted()
                .toList();
    }


    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1L, "Rahul", 25, true),
                new User(2L, "Amit", 17, true),
                new User(3L, "Priya", 30, false),
                new User(4L, "Neha", 22, true),
                new User(5L, "Raj", 15, false),
                new User(6L, "Rohan", 28, true)
        );


//        Return the user's name if present, otherwise: "Unknown User"
//        Optional<User> userOptional = users.stream()
//                .filter(user -> user.getId() == 7L)
//                .findFirst();
//        String result = userOptional
//                .map(User::getName)
//                .orElse("Unknown User");
//        System.out.println(result);



//Get the user's name in uppercase.
//If there is no user, return:"UNKNOWN"
//        Optional<User> user = users.stream()
//                .filter(u->u.getId()==1L)
//                .findFirst();
//        String result = user.map(User::getName)
//                .map(String::toUpperCase)
//                .orElse("UNKNOWN");
//        System.out.println(result);



//Write code that:
//returns the user if found
//throws an exception if not found
//Use:orElseThrow()

//        User user = users.stream()
//                .filter(u->u.getId()==10L)
//                .findFirst()
//                .orElseThrow();
//        System.out.println(user.getName());


        List<String> result = getActiveAdultUserNames(users);
        System.out.println(result);
    }
}
