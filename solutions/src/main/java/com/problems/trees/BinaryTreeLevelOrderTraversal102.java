package main.java.com.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Medium
Given the root of a binary tree, return the level
 order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {

    }
    /**
     1.create a variables needed
     -List<List<Integer>> result for storing each level in a list, then adding it to the result
     -Queue<TreeNode> for storing nodes at each level
     2.loop until queue is not empty
     3.create a int size variable to take queue's current size
     -create a list that will store all values currently in queue
     4.loop from 0 to size of array
     5.poll the node from queue
     -take its value and add to list
     -check if node has left or right nodes
     -if so add them to queue
     6.add list to result

     Time Complexity O(n), for n nodes traversed
     Space Complexity O(n) for n nodes stored in queue
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                l.add(n.val);
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
            result.add(l);
        }
        return result;
    }
}
