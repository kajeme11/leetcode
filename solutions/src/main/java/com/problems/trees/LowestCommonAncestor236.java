package main.java.com.problems.trees;

public class LowestCommonAncestor236 {
    public static void main(String[] args) {

    }

    /**
     1.check if root is null, return null
     2.check if value of q or p equals to value of root, return root
     3.create variable left to traverse left side recursively
     - create variable right to traverse right side recursively
     4.if both left and right are not null return root
     5.if left is not null return left, else right
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if root is null return null
        if(root == null){
            return root;
        }
        //if root == p or root q return q
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        //create a left variable to traverse left side of root
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //create a right variable to traverse right side of root
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //check if both left and right are not null
        if(left != null && right != null){
            return root;
        }
        // check if left node is not null , return left else right
        if(left != null){
            return left;
        }
        return right;
    }
}
