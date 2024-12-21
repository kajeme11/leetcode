package main.java.com.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/*


    https://leetcode.com/problems/contains-duplicate/description/

    Easy

    Given an integer array nums, return true if any value appears at least twice in the array,
     and return false if every element is distinct.

 */
public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        //Output: false
        System.out.println(containsDuplicate(nums1));

        int[] nums2 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums2));
        //Output: true
    }


    /*
        Use a set when looking for duplicates
        when adding a duplicate value in a set, it will return false
        we can also check if it contains the value as well

        Time complexity is O(n), we only traverse the array once,
        checking 1 to n numbers

        Space Complexity is O(n), since we use a a Set to store n values

        different approach to avoid using space can be sorting the array
        then iterating over (i = 0; i < nums.length - 1; i++)
        and checking id nums[i] == nums[i + 1], we would end up with
        time complexity of O(nlogn), and  space complexity of O(1);

     */
    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
