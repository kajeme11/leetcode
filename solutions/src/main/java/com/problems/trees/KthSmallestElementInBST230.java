package main.java.com.problems.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST230 {
    public static void main(String[] args) {

    }


    /*
    we are given a bst and a k integer
    we have to return the kth smallest number in the tree
    1.we can use a list to store values up to in inorder traversal,
    meaning we will have the elements sorted in ascending order
    2.return list.get(k - 1)

    Time Complexity O(n), for traversing n elements
    Space Complexity O(n), for using a list to store n elements
    */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    public void inorder(TreeNode node, List<Integer> l){
        if(node == null){
            return;
        }
        inorder(node.left, l);
        l.add(node.val);
        inorder(node.right, l);
    }
}
