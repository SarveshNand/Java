package Java8Features.Advanced;

import java.util.List;

public class Main {
    static void main(String[] args) {
        List<User> users = List.of(
                new User(1L, "Rahul", 25, true),
                new User(2L, "Amit", 17, true),
                new User(3L, "Priya", 30, false),
                new User(4L, "Neha", 22, true),
                new User(5L, "Raj", 15, false),
                new User(6L, "Rohan", 28, true)
        );



//        Get only active users.
//        List<User> activeUsers = users.stream()
//                .filter(User::isActive)
//                .toList();
//        activeUsers.forEach(n-> System.out.println(n.getName()));



//        Get users whose age is at least 18.
//        List<User> greaterAge = users.stream()
//                .filter(user-> user.getAge()>=18)
//                .toList();
//        greaterAge.forEach(n-> System.out.println(n.getName()));



//        Get only the names of active adult users.
        List<String> activeAdultUsers = users.stream()
                .filter(User::isActive)
                .filter(user -> user.getAge()>18)
                .map(User::getName)
                .toList();
        System.out.println(activeAdultUsers);
    }
}
