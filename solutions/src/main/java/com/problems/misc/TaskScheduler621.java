package main.java.com.problems.misc;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler621 {

    public static void main(String[] args) {

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    /**
     [A A A B B B B]

     map{A: 3, B: 4}  n = 4

     1.highest frequency
     2.How many tasks have the same frequency
     3.
     start with highest frequency plus n spaces for n given

     [B _ _ B _ _ B _ _B_ _]
     1 2 3 4 5 6 7 8 9 10

     use the formula:
     # of high frequency - 1 * # of n + 1(+1 for buffer) + # of instances with highest frequencies
     return the max between length of tasks and the formula above

     Time Complexity O(n)
     Space Complexity O(n)
     */
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencies = new HashMap<>();
        int result = 0;
        int highestFreq = 0;
        int sameFrequency = 0;
        for(char t: tasks){
            if(!frequencies.containsKey(t)){
                frequencies.put(t, 1);
            }else{
                frequencies.put(t, frequencies.get(t) + 1);
                highestFreq = Math.max(highestFreq, frequencies.get(t));
            }
        }
        for(Map.Entry<Character, Integer> m : frequencies.entrySet()){
            if(m.getValue() == highestFreq){
                sameFrequency++;
            }
        }
        System.out.println(frequencies);
        System.out.println(highestFreq);
        System.out.println(sameFrequency);
        return Math.max(tasks.length, (highestFreq - 1) * (n + 1) + sameFrequency);
    }
}
