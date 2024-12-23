package main.java.com.problems.arrays;

import java.util.*;

/*

https://leetcode.com/problems/3sum/description/

Medium

Given an integer array nums, return all the triplets
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        Output: [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(nums));
    }

    /*
       1.create a List<List<Integer>> result to return
       2.loop through index 0 to nums.length - 1
       3.use 2 pointers, right on index 0
       and left on index nums.length - 1
       4.Add a[i] + a[left] + a[right] to sum
       5.if sum > 0, then sum if positively greater, decrease
       right pointer
       6.else if sum < 0, then sum is negatively greater increase
       left
       7.else, our sum == 0, then create a list of current values
       and add it to the result list

       Time Complexity O(n^2), sorting-nlogn - nested loop(n*n) = n^2
       Space Complexity O(n), usage of set to store n elements
   */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
