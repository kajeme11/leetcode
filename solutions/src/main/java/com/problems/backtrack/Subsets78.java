package main.java.com.problems.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/description/

Medium

    Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }
    /*

    For subsets we need to include and exclude an element
        1. Start with an empty Subset
        2. Include current element and exclude the current element
        3.Add to result once subset has been processed

        Time Complexity O(n * 2^n), takes n time to create each subset, O(2^n) (each element has 2 options)
        Space Complexity O(n * 2^n), O(n) recusive stack, O(2^n) output storage
    */

    public static void backtrack(List<List<Integer>> result , ArrayList<Integer> subset, int index, int[] nums){
        result.add(new ArrayList(subset));
        for(int i = index; i < nums.length; i++){
            //include
            subset.add(nums[i]);
            backtrack(result, subset, i + 1, nums);
            //exclude
            subset.remove(subset.size() - 1);
        }
    }

}
