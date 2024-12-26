package main.java.com.problems.arrays;

public class MaximumSubArray53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        Output: 6
        int[] nums1 = {1};
//        Output: 1
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray(nums1));
    }
    /*

       Kadenes algorithm
       1.create a current sum at nums[0]
       2.create a maxSum at nums[0]
       3.traverse array from i = 1 to i < n
       4. current = MAX(nums[i], current + nums[i])
       max = MAX(MAX, current)
       5. return max

       Time Complexity O(n), trversing length of array
       Space Complexity O(1)

       */
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int current = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            current = Math.max(current + nums[i], nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }

}
