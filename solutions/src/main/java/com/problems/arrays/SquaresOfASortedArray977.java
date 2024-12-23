package main.java.com.problems.arrays;

import java.util.Arrays;

public class SquaresOfASortedArray977 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
//        Output: [0,1,9,16,100]

        int[] nums2 = {-7,-3,2,3,11};
//        Output: [4,9,9,49,121]

        System.out.println(Arrays.toString(sortedSquares(nums)));
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }
    /*
        nums = [-4,-1,0,3,10]

        1.Square everyNumber in nums
        nums = [16,1,0,9,100]
                L          R
        2.create a result array that will
        hold the numbers in nums in a sorted format
        3.use 2 pointers, left starting on index 0
        and right starting at nums.length - 1
        4.start adding the bigger number between nums[L]
        and nums[R] and store in result[k]

        Time Complexity O(n)
        Space Complexity O(n) depends on size of nums, since
        we create a result array
    */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        nums = Arrays.stream(nums).map(x -> Math.abs(x * x)).toArray();
        int[] result = new int[n];
        int k = n - 1; //match last index on nums for result
        int left = 0;
        int right = n-1;
        while(left <= right){
            if(nums[left] > nums[right]){
                result[k--] = nums[left++];
            }else{
                result[k--] = nums[right--];
            }
        }
        return result;
    }
}
