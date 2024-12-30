package main.java.com.problems.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combinations/description/

Medium

    Given two integers n and k, return all possible combinations of k numbers
    chosen from the range [1, n].

    You may return the answer in any order.
 */
public class Combinations77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
//        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println(combine(n, k));
    }
    /*

       1.Start with an empty list to hold a combination
       2.Traverse from 1 to n
       3.add current number to combination
       4.backtrack
       5.remove last index from list
       6.Base case, if combinatin size == k, add combination to result return/end recursion


       Work per combination O(k)
       number of combination O(n/k)
       Time Complexity O(k * (n/k)),

       Recursive Stack O(k)
       output O(n/k)
       Space Complexity O(k * (n/k)),

       n = 4, k = 2
       C(4, 2) = n!/k!(n-k)! =  4!/2!(4-2)! = 24/4 = 6
   */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, result, n, k, new ArrayList<>());
        return result;
    }

    public static void backtrack(int index, List<List<Integer>> res, int n, int k, List<Integer> combination){
        if(combination.size() == k){
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i = index; i <= n; i++){
            combination.add(i);
            backtrack(i + 1, res, n, k, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
