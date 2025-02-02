package main.java.com.problems.trees;

public class InvertBinaryTree226 {
    public static void main(String[] args) {

    }

    /**
     *
     * https://leetcode.com/problems/invert-binary-tree/description/
     *
     * Easy
     *
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     1.check if root is null to return and break recursive call
     2.swap nodes left and right using a temp node
     3.recursive call on left child
     4.recursive call on right child
     5.return root

     Time Complexity O(n), for traversing n nodes
     Space Complexity O(n), for stack space taken for recursive calls
     */
    public static TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;

    }

}
