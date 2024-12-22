package main.java.com.problems.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
        Easy

        Given an array nums of n integers where nums[i] is in the range [1, n],
        return an array of all the integers in the range [1, n] that
        do not appear in nums.

 */

public class FindAllNumbersDisappearedInAnArray448 {

    public static void main(String[] args) {


        int[] nums = {4,3,2,7,8,2,3,1};
//        Output: [5,6]


        int[] nums1 = {1,1};
//        Output: [2]
        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbers(nums1));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        /*
            1.Add all numbers in nums array into a set
            2.traverse the nums array from 1 to n (nums length) and check
            if current itaration number is inside the set
            3.if not inside set, that number is missing, add to list

            Time complexity O(n)
            Space Complexity O(n)
        */
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}
