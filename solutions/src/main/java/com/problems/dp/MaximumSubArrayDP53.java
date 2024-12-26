package main.java.com.problems.dp;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-subarray/description/

Medium
Given an integer array nums, find the subarray
with the largest sum, and return its sum.


 */
public class MaximumSubArrayDP53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        Output: 6
        int[] nums2 = {5,4,-1,7,8};
//        Output: 23
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums2));
    }
    /*

           [5,4,-1,7,8]
              ^
   dp[n]
   dp[0] = nums[0]; = 5
   go into for loop starting at 1
   dp[1] = MAX(nums[1], nums[1] + dp[0]); = (4, 9) = 9
   dp[2] = Max(nums[2], nums[2] + dp[1]); = (-1, 8) = 8
   dp[3] = Max(nums[3], nums[3]+ dp[2])
   .....
   ..
   1.We create a dp[n] array to store max sum values at every index
   2.We add first alement in nums to dp[0]
   3. We loop from i = 1 to i < n, and find the max for the following
   4.dp[i] = MAX(nums[i], nums[i] + dp[i - 1])
   5.return the maximum value in dp table

   Time Complexity O(n)
   Space Complexity O(n)
   Kadane algorithm would be much more efficient
   */
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
