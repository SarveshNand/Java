package LoveBabbarTasks.CollectionFramework;

import java.util.*;

public class four {
    public static void main(String[] args){
//        Frequency of numbers
//Given an integer array, count how many times each number appears.
//
//Example:
//
//Input:  [1, 2, 2, 3, 1, 2]
//Output: {1=2, 2=3, 3=1}
//        int[] arr = {1, 2, 2, 3, 1, 2};
//        Map<Integer, Integer> frequency = new HashMap<>();
//        for (int num : arr) {
//            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
//        }
//        System.out.println(frequency);


//        Create and Traverse a Map
//Store 5 student names and their marks using HashMap. Print every name and mark.
//        HashMap<String, Integer> students = new HashMap<>();
//        students.put("Rahul", 85);
//        students.put("Priya", 92);
//        students.put("Aman", 78);
//        students.put("Neha", 88);
//        students.put("Rohit", 95);
//        for (Map.Entry<String, Integer> entry : students.entrySet()) {
//            System.out.println("Name: " + entry.getKey()
//                    + ", Marks: " + entry.getValue());
//        }


//        Search for a Key
//Given a HashMap<Integer, String> of roll numbers and names, check whether a particular roll number exists.
//        HashMap<Integer, String> students = new HashMap<>();
//        students.put(101, "Rahul");
//        students.put(102, "Priya");
//        students.put(103, "Aman");
//        students.put(104, "Neha");
//        students.put(105, "Rohit");
//        int rollNumber = 103;
//        if (students.containsKey(rollNumber)) {
//            System.out.println("Roll number " + rollNumber + " exists.");
//            System.out.println("Student Name: " + students.get(rollNumber));
//        } else {
//            System.out.println("Roll number " + rollNumber + " does not exist.");
//        }


//        Character Frequency ⭐
//Given a string:
//
//"programming"
//
//Count how many times each character occurs.
//
//Expected idea:
//
//p -> 1
//r -> 2
//o -> 1
//g -> 2
//...
//        String str = "programming";
//        HashMap<Character, Integer> frequency = new HashMap<>();
//        for (char ch : str.toCharArray()) {
//            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
//        }
//        for (char ch : frequency.keySet()) {
//            System.out.println(ch + " -> " + frequency.get(ch));
//        }


//        Two Sum
//
//Given:
//
//nums = [2, 7, 11, 15]
//target = 9
//
//Find the two indices whose values add up to target.
//
//Expected:
//
//[0, 1]
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                System.out.println("[" + map.get(complement) + ", " + i + "]");
//                break;
//            }
//            map.put(nums[i], i);
//        }


//        Group anagrams
//
//Given:
//
//["eat", "tea", "tan", "ate", "nat", "bat"]
//
//Group words that are anagrams.
//
//Expected:
//
//[eat, tea, ate]
//[tan, nat]
//[bat]
//
//Hint: Think about what could be used as the key in a HashMap.
//        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        for (String word : words) {
//            char[] chars = word.toCharArray();
//            Arrays.sort(chars);
//            String key = new String(chars);
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(word);
//        }
//        System.out.println(map.values());


//        Longest consecutive sequence
//
//Given:
//
//[100, 4, 200, 1, 3, 2]
//
//Find the length of the longest sequence of consecutive integers.
//
//Expected:
//
//4
//
//Because:
//
//1, 2, 3, 4
//
//Try solving this using a HashSet/map rather than sorting.
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        int longest = 0;
//        for (int num : set) {
//            if (!set.contains(num - 1)) {
//                int current = num;
//                int length = 1;
//                while (set.contains(current + 1)) {
//                    current++;
//                    length++;
//                }
//                longest = Math.max(longest, length);
//            }
//        }
//        System.out.println(longest);


//        Subarray Sum
//
//Given:
//
//int[] arr = {1, 2, 3, -2, 5};
//int target = 3;
//
//Find how many subarrays have a sum equal to 3.
//
//This is a great HashMap problem once you're comfortable with maps.
//        int[] arr = {1, 2, 3, -2, 5};
//        int target = 3;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//        int prefixSum = 0;
//        int count = 0;
//        for (int num : arr) {
//            prefixSum += num;
//            if (map.containsKey(prefixSum - target)) {
//                count += map.get(prefixSum - target);
//            }
//            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
//        }
//        System.out.println(count);


//        Most frequent word
//
//Given:
//
//"apple banana apple orange banana apple mango"
//
//Find the most frequent word without sorting.
        String str = "apple banana apple orange banana apple mango";
        String[] words = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String mostFrequent = "";
        int maxCount = 0;
        for (String word : map.keySet()) {
            if (map.get(word) > maxCount) {
                maxCount = map.get(word);
                mostFrequent = word;
            }
        }
        System.out.println("Most frequent word: " + mostFrequent);
        System.out.println("Count: " + maxCount);
    }
}
