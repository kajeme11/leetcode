package main.java.com.problems.trees;


/*
https://leetcode.com/problems/same-tree/description/

Easy
    Given the roots of two binary trees p
    and q, write a function to check if
    they are the same or not.

Two binary trees are considered the same
 if they are structurally identical,
 and the nodes have the same value.

 */
public class SameTree100 {
    public static void main(String[] args) {

    }
    /*
    1.Check if both p or q are null, if so return true
    2.check if q is not null but p is null and vice versa
    -this checks are needed to avoid null pointers
    and also check if are equal
    3.return if values are equal in p and q
    and recursively call on q and p left, and q and p right

    Time Coplexity O(n) for n nodes in treeNodes
    Space Coplexity O(height) for memory stack space needed for recursion
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null) return false;
        if(q == null && p != null) return false;
        return q.val == p.val && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));

    }
}
