package main.java.com.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/

Easy
    Given the root of a binary tree, return the average value of the nodes on each
    level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 */
public class AverageOfLevelsInABinaryTree637 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9, new TreeNode(15), new TreeNode(7)), new TreeNode(20));

        System.out.println(averageOfLevels(tree));
    }

    /**
        /3\
     /9\   20
   15  7

     list = {3}
     q = 3 popped
     val = 3, take average of node.val
     if node has left, add to queue
     if node has right, add to queue
     ---------------
     list = {3}
     q = 9 20, while(queue not empty pop)
     val = 29

     1.Must use breadth first search to acomplish
     the tasks of taking average at each level,
     so a queue can be used here, if we had to make a
     bfs, a stack would be ideal

     we can use a queue

     -add root to q
     -while q is not empty
     -pop value from queue
     -take average and add to list
     -if value has a left child add to queue,
     same if it has a right child
     -if no more nodes to add to queue, loop ends
     -return list

     Time Complexity O(n), traversing n elements in tree
     Space Complexity O(n), for inserting n elements in queue
     */
    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            double val = 0;
            int i = 0;
            int size = q.size();
            while(i < size){
                val += q.peek().val;
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                i++;
            }
            result.add(val/size);
        }
        return result;
    }
}
