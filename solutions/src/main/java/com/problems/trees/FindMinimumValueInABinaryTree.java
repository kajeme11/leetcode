package main.java.com.problems.trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;




public class FindMinimumValueInABinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(15, new TreeNode(8, new TreeNode(7), new TreeNode(10)), new TreeNode(2));
        System.out.println(findMin(node));
    }

    /**
     *
     * Time Complexity O(n) for n traversal
     * Space Complexity O(n) for storing n nodes in queue
     *
     */

    public static int findMin(TreeNode root){
        if(root == null){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                min = Math.min(min, node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return min;
    }
}
