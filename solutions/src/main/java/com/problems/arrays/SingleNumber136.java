package main.java.com.problems.arrays;

public class SingleNumber136 {

    /*
   https://leetcode.com/problems/single-number/description/
    Easy
        Given a non-empty array of integers nums, every element
        appears twice except for one.
        Find that single one.

        You must implement a solution with a linear runtime complexity
        and use only constant extra space.
     */
    public static void main(String[] args) {
        int[] nums = {2,2,1};
//        Output: 1
        int[] nums1 = {4,1,2,1,2};
//        Output: 4
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber(nums1));
    }

    public static  int singleNumber(int[] nums) {
        /*
        Xor properties
        1.a ^ a = 0 - cancels itself out
        2.a ^ 0 = a - equals itself when xored to 0
        3.a^b^c = c^b^a - does not matter the order
            [2, 2 , 1]
            2 ^ 2 = 0
            0 ^ 1 = 1

            Input: nums = [4,1,2,1,2]
            Output: 4
            4^1 =   0100 ^ 0001 = 0101 = 5
            5^2 =   0101 ^ 0010 = 0111 = 7
            7^1 =   0111 ^ 0001 = 0110 = 6
            6^2 =   0110 ^ 0010 = 0100 = 4

            Time Complexity O(n) traverse n elements
            Space Complexity o(1)

        */
        int singleOut = 0;
        for(int i = 0; i < nums.length; i++){
            singleOut ^= nums[i];
        }
        return singleOut;
    }
}
