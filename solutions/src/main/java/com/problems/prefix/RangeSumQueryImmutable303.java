package main.java.com.problems.prefix;

public class RangeSumQueryImmutable303 {

    /*

    https://leetcode.com/problems/range-sum-query-immutable/description/

    Easy
    Given an integer array nums, handle multiple queries of the following
    type:

    Calculate the sum of the elements of nums between indices
    left and right inclusive where left <= right.

     */
    public static void main(String[] args) {

        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(2, 5));

    }
    static class NumArray {

        /*
            1.create a prefix array that will store the prefix sum at each index
                nums = [-2, 0, 3, -5, 2, -1]

                prefix = [-2, -2, 1, -4, -2, -3]
                prefix[0] = nums[0] = -2
                prefix[1] = prefix[1 - 1] + nums[1] = -2 + 0 = -2
                prefix[2] = prefix[2 - 1] + nums[2] = -2 + 3 = 1
                prefix[3] = prefix[3 - 1] + nums[3] = 1 + (-5) = -4
                .... and so on
                2. We want to create the prefic array when an object
                of NumArray is instantiated. It will take O(n) time complexity
                , but after creating the prefix we will be able to retrieve
                the query sums between left and right in O(1) Time Complexity
        */
        int[] prefix;
        public  NumArray(int[] nums) {
            prefix = new int[nums.length];
            prefix[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                prefix[i] = prefix[i - 1] +  nums[i];
            }
        }

    /*
        to retrieve the sum of indices between left and right
        we habe to return prefix[right] - prefix[left - 1]
        Just check if left = 0, if so don't look up left - 1
        since that would be an index out of bounds, just
        return prefix[right]

        ex:
         prefix = [-2, -2, 1, -4, -2, -3]
         left = 2, right =5
         result = prefix[right] - prefix[left - 1] = prefix[5] - prefix[2 - 1]
                = -3 - (-2) = -1

    */

        public int sumRange(int left, int right) {
            return (left == 0) ? prefix[right] : prefix[right] - prefix[left - 1];
        }
    }
}
