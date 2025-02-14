package main.java.com.problems.trees;

import java.util.Set;

public class TwoSumIV653 {

    public static void main(String[] args) {

    }


    /*
        root = [5,3,6,2,4,null,7], k = 9

         5
      3     6
    2   4     7

    set = {5}
    y = k - root.val = 9 - 5 = 4
    if set contains 4, then it means there is a sum in the bst that matches k
        - return true
    else
        -add root.val to set

    return resursive call on left and right

    Time Complexity O(n), for n nodes traversed
    Space Complexity O(n), for set and stack calls

    */

    public boolean dfs(TreeNode root, int k, Set<Integer> set){
        if(root == null){
            return false;
        }
        //  x + y = k
        //  y = k - x 23, 25, 22, 26, 24, 21
        int y = k - root.val;

        if(set.contains(y)){
            return true;
        }else{
            set.add(root.val);
        }
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
