package main.java.com.problems.arrays;

/*
    https://leetcode.com/problems/missing-number/description/

    Easy

    Given an array nums containing n distinct numbers in the range [0, n],
     return the only number in the range that is missing from the array.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber268 {
    public static void main(String[] args) {


        int[] nums = {0,1};
        System.out.println(missingNumber(nums));
//        Output: 2
        int[] nums2 = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums2));
//        Output: 8

    }

    /*
        We take the expected sum of all integers from 1 to n
        then take the actual sum in the array
        substract actual from expected, we should get the missing number
        Time complexity O(n), we traverse array from 1 to n
        Spcae complaxity O(1)
     */
    public static int missingNumber(int[] nums) {
//IntStream.range(inclusive, exclusive), hence the plus 1
//        int expectedSum = IntStream.range(1, nums.length + 1).sum();
        int n = nums.length;
        int expectedSum = n * (1 + n)/2;
//        System.out.println(expectedSum);
        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }
}
