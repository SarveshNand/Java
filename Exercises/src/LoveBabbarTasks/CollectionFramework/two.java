package LoveBabbarTasks.CollectionFramework;

import java.util.*;

public class two {
    public static void main(String[] args){
//        Problem 1: Stack
//
//Create a Java Stack<Integer> and perform these operations:
//
//Push 10
//Push 20
//Push 30
//Print the top element
//Remove the top element
//Print the new top element
//Print the size of the stack
//Check whether the stack is empty
//        Stack<Integer> st = new Stack<>();
//        st.push(10);
//        st.push(20);
//        st.push(30);
//        System.out.println(st.peek());
//        st.pop();
//        System.out.println(st.peek());
//        System.out.println(st.size());
//        System.out.println(st.isEmpty());


//       Problem 2 — Queue
//
//Now let's practice Queue.
//
//Create a Queue<Integer> and:
//
//Add 10, 20, 30, 40
//Print the element at the front without removing it
//Remove the front element
//Print the new front
//Print the size
//Check whether the queue is empty
//        Queue<Integer> q = new LinkedList<>();
//        q.add(10);
//        q.add(20);
//        q.add(30);
//        q.add(40);
//        System.out.println(q.peek());
//        q.remove();
//        System.out.println(q.peek());
//        System.out.println(q.size());
//        System.out.println(q.isEmpty());


//        Problem 3 — Deque
//
//Now let's make it slightly more interesting.
//
//Create a Deque<Integer> using ArrayDeque.
//
//Perform these operations:
//
//Add 10 to the front
//Add 20 to the front
//Add 30 to the back
//Add 40 to the back
//Print the front element
//Print the back element
//Remove the front element
//Remove the back element
//Print the deque
//        ArrayDeque<Integer> d = new ArrayDeque<>();
//        d.addFirst(10);
//        d.addFirst(20);
//        d.addLast(30);
//        d.addLast(40);
//        System.out.println(d.getFirst());
//        System.out.println(d.getLast());
//        d.removeFirst();
//        d.removeLast();
//        System.out.println(d);


//        Problem 4 — LinkedList
//
//Now let's test whether you understand that a LinkedList can behave like both a list and a queue.
//
//Create:
//
//LinkedList<String> names = new LinkedList<>();
//
//Do these operations:
//
//Add "Alice" to the end.
//Add "Bob" to the end.
//Add "Charlie" to the beginning.
//Add "David" to the end.
//Print the list.
//Remove "Bob".
//Print the first element.
//Print the last element.
//Print the final list.
//        LinkedList<String> ll = new LinkedList<>();
//        ll.addLast("Alice");
//        ll.addLast("Bob");
//        ll.addFirst("Charlie");
//        ll.addLast("David");
//        System.out.println(ll);
//        ll.remove("Bob");
//        System.out.println(ll.getFirst());
//        System.out.println(ll.getLast());
//        System.out.println(ll);


//        Problem 5 — Vector
//
//Now let's practice Vector, but with a slightly different task.
//
//Create:
//
//Vector<Integer> v = new Vector<>();
//
//Do the following:
//
//Add 10, 20, 30, 40, 50
//Print the vector
//Print the element at index 2
//Change the element at index 2 to 100
//Remove the element at index 0
//Print the final vector
//Print its size
//        Vector<Integer> v = new Vector<>();
//        v.add(10);
//        v.add(20);
//        v.add(30);
//        v.add(40);
//        v.add(50);
//        System.out.println(v);
//        System.out.println(v.get(2));
//        v.set(2, 100);
//        v.remove(0);
//        System.out.println(v);
//        System.out.println(v.size());


//        Problem 6 — Choose the data structure
//
//You're given a string:
//
//"hello"
//
//You need to reverse it using a Stack.
//
//For example:
//
//Input:  hello
//Output: olleh
//Requirements
//
//Use:
//
//Stack<Character>
//
//and:
//
//Put every character of the string into the stack.
//Remove characters from the stack one by one.
//Build the reversed string.
//Print it.
//
//Don't use StringBuilder.reverse() — I want you to practice the stack concept.
//        String st = "hello";
//        Stack<Character> s = new Stack<>();
//        for (char ch: st.toCharArray()){
//            s.push(ch);
//        }
//        String reversed = "";
//        while (!s.isEmpty()){
//            reversed += s.pop();
//        }
//        System.out.println(reversed);


//        Problem 7 — Queue simulation
//
//Now let's combine loops + Queue.
//
//Imagine people are standing in a queue:
//
//[10, 20, 30, 40, 50]
//
//Each number represents a person's ID.
//
//You need to:
//
//Create a Queue<Integer>.
//Add 10, 20, 30, 40, 50.
//Process every person one by one.
//When processing a person, print:
//Processing: 10
//Processing: 20
//...
//At the end, print whether the queue is empty.
//
//Expected output:
//
//Processing: 10
//Processing: 20
//Processing: 30
//Processing: 40
//Processing: 50
//true
//Constraint
//
//Use a loop with:
//
//while (!q.isEmpty())
//
//and remove people from the queue as you process them.
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        while (!q.isEmpty()){
            System.out.println("Processing: " + q.poll());
        }
        System.out.println(q.isEmpty());
    }
}
