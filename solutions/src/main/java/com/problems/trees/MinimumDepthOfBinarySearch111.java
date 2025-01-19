package main.java.com.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinarySearch111 {
    public static void main(String[] args) {

    }


    /*

        Iterative approach to finding the minimum depth of a binary tree
        1.use a queue and add the root node
            -A queue will be helpful to do a breadth first search
            and keep count of each level
        2.while queue is not empty search tree
        3.Increase level by 1 and keep track of size of queue for an inner loop
          -Here we pop off the node from the queue
          -check if node is not null to continue processing node
          -if both left and right leaves are null then we found our result
          -if left is not null add to queue
          -if right is not null add to queue

           Time Complexity O(n), for n nodes traversed
           Space Complexity O(n), for queue for storing n nodes

     */

    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node != null){
                    if(node.right == null && node.left == null){
                        return level;
                    }
                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
                }
            }
        }
        return 0;
    }

}
