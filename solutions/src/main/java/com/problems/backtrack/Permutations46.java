package main.java.com.problems.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutations/description/

Medium
Given an array nums of distinct integers, return all the possible
permutations
. You can return the answer in any order.


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

    public static void backtrack(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums){

        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int number: nums){
            if(temp.contains(number)){
                continue;
            }
            temp.add(number);
            backtrack(res ,temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
