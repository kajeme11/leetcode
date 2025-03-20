package main.java.com.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps {
    /*
            GIVEN 2 ARRAY, WHAT ARE THE MINIMUM SWAPS
            TO MAKE AN ARRAY LOOK LIKE THE OTHER ONE
     */

    public static void main(String[] args) {

        int[] a1 = {3, 1, 4, 9, 5};
        int[] a2 = {5, 1, 3, 4, 9};
/*
    1 swap
    5 1 4 9 3
    2 swaps
    5 1 3 9 4
    3 swaps
    5 1 3 4 9
 */
        System.out.println(minSwaps(a1, a2));
    }

    public static int minSwaps(int[] a1, int[] a2){

        int n = a1.length;
        int min = 0;
        boolean[] visited = new boolean[n];

        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < n; i++){
            m.put(a2[i], i);
        }

        for(int i = 0; i < n; i++){
            if(a1[i] == a2[i] || visited[i]){
                continue;
            }
            int cycle = 0;
            int x = i;
            while(!visited[x]){
                visited[x] = true;
                x = m.get(a1[x]);
                cycle++;
            }
            if(cycle > 1){
                min += cycle - 1;
            }
        }
        return min;
    }
}
