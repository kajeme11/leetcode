package main.java.com.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/minimum-absolute-difference/description/

Easy

Given an array of distinct integers arr,
find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending
order(with respect to pairs), each pair [a, b]follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 */
public class MinimumAbsoluteDifference1200 {

    public static void main(String[] args) {

        int[] arr = {4,2,1,3};
//        Output: [[1,2],[2,3],[3,4]]
        System.out.println(minimumAbsDifference(arr));
    }


    public static List<List<Integer>> minimumAbsDifference(int[] arr) {

        /*
            Input: arr = [4,2,1,3]

            We have to find all pairs that can have the minimum absolute difference

            1.Sort the array
            [1, 2, 3, 4]
            2.travrse array and find the minimum absolute difference
            1-2 = 1, 2-3= 1, 3-4 = 1
             Here we can see the the minimum absolute difference is 1

             DIFFERENT ARRAY
              [3,8,-10,23,19,-4,-14,27]
              sorted [-14, -10, -4, 3, 8, 19, 23, 27]
              minimum 4


             3.traverse array again and add pairs to List<list<Integer>>

            Time Complexity O(nlogn) . since we sort array
            Space Complexity O(n) , use of a list to store pairs
       */
        List<List<Integer>> result = new ArrayList<>();
        int absoluteMin = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            absoluteMin = Math.min(absoluteMin, Math.abs(arr[i] - arr[i - 1]));
        }
        for(int i = 1; i < arr.length; i++){
            if(Math.abs(arr[i] - arr[i - 1]) == absoluteMin){
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }
}
