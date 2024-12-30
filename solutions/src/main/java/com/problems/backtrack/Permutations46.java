package main.java.com.problems.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutations/description/

Medium
Given an array nums of distinct integers, return all the possible
permutations
. You can return the answer in any order.


Permutation Characteristics
-A permutation is a rearrangement of elements
-For an array of size n, there will be n! permutations
-the order of elements matters, so [1, 2, 3] and [3, 2, 1] are distinct permutations

 */
public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }
/*
    We are given an integer array such as {1,2,3}
    We have to find all the permutations

    1.Create a helper function to backtrack and add permutations to result
    2.if the size of the permutation reaches the length of the array
    given (nums), then we have reached a complete permutation
    and is ready to be added to the result and return/end backtracking
    3.traverse numbers in array,
    -check if number in current loop is already in the permutation
    if it is, continue to next iteration
    -otherwise add number to permutation, then backtrack
    -lastly remove the last index in each permutation

Time Complexity O(n * n!), there are n! permutation and takes O(n) to buils each one
Space Complexity O(n * n!) recursion depth stack is O(n), the result list has n! permutations

    nums: [1, 2, 3]
    permutation: [1]
    loop: number = 1
    backtrack(res, permutation, nums)
        loop:number 1, already in permutation, go to next iteration
        loop:number 2,
        permutation: [1, 2]
        backtrack(res, permutation, nums)
            loop: number 1 - 2, already in permutation go to next iteration
            loop: number 3
            permutation [1, 2, 3]
            backtrack(res, permutation, nums)
                    -***permutation has reached nums.length, add to result [1, 2, 3]
       REMOVE permutation.size() - 1, permutation: [1, 2] -> permutation: [1]
       loop: number 3
       permutation: [1, 3]
       backtrack(res, permutation, nums)
            loop: number 1, already in permutation
            loop: number 2
            permutation: [1, 3, 2]
            backtrack
                -***permutation has reached nums.length, add to result [1, 3, 2]
      REMOVE permutation.size() - 1, permutation: [1, 3] -> permutation: [1]
      REMOVE permutation.size() - 1, permutation: [1] -> permutation: [0]
      loop has reached length 3, so we are done
loop: number 2
permutation: [2]
backtrack
...........


 */
    public static void backtrack(List<List<Integer>> res, ArrayList<Integer> permutation, int[] nums){

        if(permutation.size() == nums.length){
            res.add(new ArrayList<>(permutation));
            return;
        }
        for(int number: nums){
            if(permutation.contains(number)){
                continue;
            }
            permutation.add(number);
            backtrack(res ,permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }
}
