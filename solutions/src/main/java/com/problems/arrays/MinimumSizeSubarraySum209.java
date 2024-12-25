package main.java.com.problems.arrays;


/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/

Medium

Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray
whose sum is greater than or equal to target. If there is no such subarray,
return 0 instead.
 */
public class MinimumSizeSubarraySum209 {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
//        Output: 2

        int target2 = 4;;
        int[] nums2 = {1,4,4};
//        Output: 1

        System.out.println(minSubArrayLen(target, nums));
        System.out.println(minSubArrayLen(target2, nums2));
    }

    public static int minSubArrayLen(int target, int[] nums) {
       /*
            target = 7,
            nums = [2,3,1,2,4,3]
                          r
                    l
        r = 4;
        l = 0
        sum = 8
        minLen = Min(minLen, r - l + 1)

            1.We can use a 2 pointer approach starting at index 0
            2.We can start off at the start of the array
            3.start adding every value at the right index to the sum,
            4.Once the sum is equal or grater to the sum
            Take the minimum range between left and right as the answer
            minSumLen = Min(minLen, right - left + 1)
            And we can start substracting the values from the left
            until sum is is less than taret

        Time Complexity O(n), we traverse array at most once
        Space Complexity O(1)
       */
        int r = 0;
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int sum =0;
        while(r < nums.length){
            sum += nums[r];
            while(sum >= target){
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

}
