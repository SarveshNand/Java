package LoveBabbarTasks.CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class one {
    public static void main(String[] args){

//Create an ArrayList<Integer>, add these numbers:
//10, 20, 30, 40, 50
//Print the entire list using a loop.
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(10);
//        arr.add(20);
//        arr.add(30);
//        arr.add(40);
//        arr.add(50);
//        for (Integer el: arr){
//            System.out.println(el);
//        }



//Find the sum
//Given an ArrayList<Integer>, calculate and print the sum of all elements.
//        ArrayList<Integer> el = new ArrayList<>();
//        int sum = 0;
//        el.add(1);
//        el.add(20);
//        el.add(40);
//        el.add(60);
//        el.add(80);
//        el.add(100);
//        for (Integer ut: el){
//            sum += ut;
//        }
//        System.out.println(sum);


//        Find the largest number
//Find the maximum element without using Collections.max().
//        ArrayList<Integer> element = new ArrayList<>();
//        int max = 0;
//        element.add(80);
//        element.add(90);
//        element.add(70);
//        element.add(60);
//        element.add(97);
//        element.add(95);
//        element.add(70);
//        for (Integer it:element){
//            if (max < it){
//                max = it;
//            }
//        }
//        System.out.println(max);


//        Count even numbers
//Given an ArrayList<Integer>, count how many elements are even.
//        ArrayList<Integer> em = new ArrayList<>();
//        int counter = 0;
//        em.add(1);
//        em.add(2);
//        em.add(3);
//        em.add(4);
//        em.add(5);
//        em.add(6);
//        em.add(7);
//        em.add(8);
//        em.add(9);
//        em.add(10);
//        for (Integer count: em){
//            if (count % 2 == 0){
//                counter++;
//            }
//        }
//        System.out.println(counter);


//        Search for an element
//Given an ArrayList and a number x, check whether x exists in the list.
//Try solving it without using contains().
//        ArrayList<Integer> arm = new ArrayList<>();
//        int x = 38;
//        boolean found = false;
//        arm.add(56);
//        arm.add(69);
//        arm.add(12);
//        arm.add(34);
//        arm.add(93);
//        arm.add(78);
//        arm.add(76);
//        for (Integer ar: arm){
//            if (ar == x){
//                found = true;
//                break;
//            }
//        }
//        if (found){
//            System.out.println("Element exists");
//        } else {
//            System.out.println("Element does not exists");
//        }


//        Remove all occurrences
//Given:
//[2, 5, 2, 8, 2, 10]
//
//Remove every occurrence of 2.
//        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(2, 5, 2, 8, 2, 10));
//        num.removeIf(x -> x==2);
//        System.out.println(num);


//        Reverse the list
//Reverse an ArrayList without using Collections.reverse().
//Example:
//
//Input:  [1, 2, 3, 4, 5]
//Output: [5, 4, 3, 2, 1]
//        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        System.out.println("Num List: " + num);
//        int left = 0;
//        int right = num.size() - 1;
//        while (left < right){
//            int temp = num.get(left);
//            num.set(left, num.get(right));
//            num.set(right, temp);
//            left++;
//            right--;
//        }
//        System.out.println("Reversed Num List: " + num);


//        Find the second largest
//Find the second-largest number in an ArrayList<Integer>.
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 20, 8, 15));
//        int largest = Integer.MIN_VALUE;
//        int secondLargest = Integer.MIN_VALUE;
//        for (int num:list){
//            if (num > largest){
//                secondLargest = largest;
//                largest = num;
//            } else if (num > secondLargest && num < largest) {
//                secondLargest =  num;
//            }
//        }
//        System.out.println(secondLargest);


//        Remove duplicates
//Given:
//[1, 2, 2, 3, 4, 3, 5, 1]
//
//produce:
//[1, 2, 3, 4, 5]
//        ArrayList<Integer> dups = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 3, 5, 1));
//        ArrayList<Integer> unique = new ArrayList<>();
//        for (Integer num: dups){
//            if (!unique.contains(num)){
//                unique.add(num);
//            }
//        }
//        System.out.println(unique);


//        Move zeros to the end
//Input:  [0, 1, 0, 3, 12]
//Output: [1, 3, 12, 0, 0]
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 0, 3, 12));
//        int index = 0;
//        for (int num:list){
//            if (num!=0){
//                list.set(index++, num);
//            }
//        }
//        while (index<list.size()){
//            list.set(index++, 0);
//        }
//        System.out.println(list);


//        Find the frequency
//Given:
//[1, 2, 2, 3, 1, 2, 4]
//
//print:
//
//1 -> 2
//2 -> 3
//3 -> 1
//4 -> 1
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 2, 4));
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num: list){
//            if (map.containsKey(num)){
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        for (int num: map.keySet()){
//            System.out.println(num + " -> " + map.get(num));
//        }


//        Find common elements
//Given two ArrayLists:
//A = [1, 2, 3, 4, 5]
//B = [3, 4, 5, 6, 7]
//
//output:
//
//[3, 4, 5]
//        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
//        ArrayList<Integer> common = new ArrayList<>();
//        for(int num:a){
//            if (b.contains(num)){
//                common.add(num);
//            }
//        }
//        System.out.println(common);


//        Rotate the ArrayList
//Input:  [1, 2, 3, 4, 5]
//Rotate right by 2
//
//Output: [4, 5, 1, 2, 3]
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        int k = 2;
//        k %= list.size();
//        ArrayList<Integer> result = new ArrayList<>();
//        for (int i = list.size()-k; i<list.size(); i++){
//            result.add(list.get(i));
//        }
//        for (int i = 0; i<list.size()-k; i++){
//            result.add(list.get(i));
//        }
//        System.out.println(result);


//        Find the missing number
//An ArrayList contains numbers from 1 to n, but one number is missing:
//[1, 2, 3, 5, 6]
//
//Find the missing number.
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6));
//        int n = 6;
//        int expectedSum = n*(n+1)/2;
//        int actualSum = 0;
//        for (int num: list){
//            actualSum += num;
//        }
//        int missingNum = expectedSum - actualSum;
//        System.out.println(missingNum);


//        Palindrome ArrayList
//Check whether an ArrayList reads the same forwards and backwards.
//[1, 2, 3, 2, 1] → true
//[1, 2, 3, 4, 1] → false

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        int left = 0;
        int right = list.size()-1;
        while (left<right){
            if (!list.get(left).equals(list.get(right))){
                System.out.println(false);
            }
            left++;
            right--;
        }
        System.out.println(true);
    }
}
