package main.java.com.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/contains-duplicate-ii/description/

Easy
Given an integer array nums and an integer k,
 return true if there are two distinct indices i and j
 in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicate219 {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int k = 3;
//        Output: true
        int[] nums2 = {1,0,1,1};
        int k2 = 1;
//        Output: true
        int[] nums3 = {1,2,3,1,2,3};
        int k3 = 2;
//        Output: false

        System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicate(nums2, k2));
        System.out.println(containsNearbyDuplicate(nums3, k3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

/*
    We have an array of integers along with a k numbers that
    sets up a range in which we need to find our dupicate in

    nums = [1,2,3,1], k = 3 -> true
            0 1 2 3
    here abs(i - j) <= 3, so we have a duplicate in range

    1.Create a Set to store integers, track range and check if we encounter a duplicate
    2.Traverse nums array and if we have a duplicate return true
    3.else add it to set.
    4.before going to the next iteration check if we are inside the range
    5 we keep track of range (k) by the set's size
        if set.size() > k, then we need to remove the value the far left
        set.remove(nums[i - k])

    Time Complexity O(n) , we traverse n elemenmts in nums array
    Space Complexity O(n) , we use a set to store n elements
*/
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
