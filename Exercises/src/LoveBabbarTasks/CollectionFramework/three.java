package LoveBabbarTasks.CollectionFramework;

import java.util.*;

public class three {
    public static void main(String[] args){
//        1. Queue simulation
//
//Given an array of people waiting in a queue:
//
//[10, 20, 30, 40, 50]
//
//Perform these operations:
//
//Add 60
//Remove the first person
//Add 70
//Remove two people
//Print the remaining queue
//
//Use: Queue + ArrayDeque
//        Queue<Integer> q1 = new ArrayDeque<>(Arrays.asList(10, 20, 30, 40, 50));
//        q1.add(60);
//        q1.poll();
//        q1.add(70);
//        q1.poll();
//        q1.poll();
//        System.out.println(q1);


//        2. Reverse a queue
//
//Given:
//
//[1, 2, 3, 4, 5]
//
//Transform it into:
//
//[5, 4, 3, 2, 1]
//
//Constraint: Use a Queue.
//        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
//        System.out.println(q2);
//        Stack<Integer> st = new Stack<>();
//        while (!q2.isEmpty()){
//            st.push(q2.remove());
//        }
//        while (!st.isEmpty()){
//            q2.add(st.pop());
//        }
//        System.out.println(q2);


//        3. Remove duplicates
//
//Given:
//
//[4, 2, 7, 2, 4, 9, 7, 1]
//
//Print only unique numbers.
//
//Expected:
//
//[1, 2, 4, 7, 9]
//
//Try solving this three different ways:
//
//HashSet
//LinkedHashSet
//TreeSet
//
//Then notice how the output/order differs.
//        Set<Integer> s1 = new HashSet<>(Arrays.asList(4, 2, 7, 2, 4, 9, 7, 1));
//        Set<Integer> s2 = new LinkedHashSet<>(Arrays.asList(4, 2, 7, 2, 4, 9, 7, 1));
//        Set<Integer> s3 = new TreeSet<>(Arrays.asList(4, 2, 7, 2, 4, 9, 7, 1));
//        System.out.println("HashSet: "+s1);
//        System.out.println("LinkedHashSet: "+s2);
//        System.out.println("TreeSet: "+s3);


//        4. First non-repeating character
//
//Given:
//
//"swiss"
//
//Find the first character that appears only once.
//
//Expected:
//
//'w'
//
//Hint: Think about combining a Queue with a Set, or using another structure you've learned.
//        String str = "swiss";
//        Queue<Character> q3 = new LinkedList<>();
//        Set<Character> s4 = new HashSet<>();
//        for (char ch:str.toCharArray()){
//            if (!s4.contains(ch)){
//                s4.add(ch);
//                q3.add(ch);
//            } else {
//                s4.remove(ch);
//                q3.remove(ch);
//            }
//        }
//        if (!q3.isEmpty()){
//            System.out.println(q3.peek());
//        }


//        5. Browser history
//
//Simulate:
//
//google.com
//youtube.com
//github.com
//stackoverflow.com
//
//The user presses Back twice.
//
//Print the page they're currently on.
//
//Then implement Forward.
//
//Think about whether one Queue is enough.
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        String current = "google.com";
        visit("youtube.com", backStack, forwardStack, current);
        current = "youtube.com";
        visit("github.com", backStack, forwardStack, current);
        current = "github.com";
        visit("stackoverflow.com", backStack, forwardStack, current);
        current = "stackoverflow.com";
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
        }
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
        }
        System.out.println("Current page after Back twice: " + current);
        if (!forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
        }
        System.out.println("Current page after Forward: " + current);
    }
    static void visit(String page, Stack<String> backStack, Stack<String> forwardStack, String current) {
        backStack.push(current);
        forwardStack.clear();
    }
}
