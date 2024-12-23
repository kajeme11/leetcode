package main.java.com.problems.arrays;

/*
https://leetcode.com/problems/longest-mountain-in-array/description/

Medium

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of
 the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 */
public class LongestMountainInArray845 {
    public static void main(String[] args) {
        int[] arr1 = {2,1,4,7,3,2,5};
//        Output: 5
        int[] arr2 = {2,2,2};
//        Output: 0
        System.out.println(longestMountain(arr1));
        System.out.println(longestMountain(arr2));
    }
    /*
        arr = [2,1,4,7,3,2,5]

        1.create varialble to hold result of length of subarray
        2.iterate array from 1 to i < n - 1, since the first
        index and last cannot be peaks
        3.if peak is found a[i] > a[a-i] && a[i] > a[i+1]
        then create a left pointer and right pointer starting at index i
        4.decrease left pointer while(a[left] > a[a[left - 1]]), left --
        5.increase right pointer while(a[right] > a[right + 1], right++)
        6.take max for subArrayLength max(maxLen, right - left + 1)

        Time Complexity O(n), while expanding left and right, each index is visited at most once
        Space Complexity O(1)

    */
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        for(int i = 1; i < n - 1; i++){
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
                int left = i;
                int right = i;
                while(left > 0 && arr[left] > arr[left - 1]){
                    left--;
                }
                while(right < n - 1 && arr[right] > arr[right + 1]){
                    right++;
                }
                max = Math.max(max, right - left + 1);
            }
        }
        return max;

    }
}
