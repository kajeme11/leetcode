package main.java.com.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
 *
 * Easy
 * Given the array nums, for each nums[i] find out how many numbers in the array
 * are smaller than it. That is, for each nums[i] you have to count the number
 * of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 */
public class HowManyNumbersAreSmallerThanCurrent1365 {
    public static void main(String[] args) {

        int[] nums = {8,1,2,2,3};
//        Output: [4,0,1,1,3]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        /*
        nums = [8,1,2,2,3]

        1.Make a deep copy of nums and sort the array
        nums = [1, 2, 2, 3, 8]
        2.Create an array for result and create a map to sotr nums[i] as key and index as value
        no need to store duplicates

        Map = {1: 0, 2: 1, 3: 3, 8: 4}

        3.Iterate over nums array and add map.get(nums[i]) to the result,
        this will give us the current index that we store as values,
        and it is also the count of it's comparison to other values

        i = 0, i < n; i++
        result[i] = map.get(nums[i])
        result[0] = map.get(nums[0]) -> result[0] = map.get(8)
        result[1] = map.get(nums[1]) -> result[1] = map.get(1)
`...
        result = {4, 0}
        */
        int n = nums.length;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        for(int i = 0; i < n; i++){
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], i);
            }
        }
        for(int i = 0; i < n; i++){
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
