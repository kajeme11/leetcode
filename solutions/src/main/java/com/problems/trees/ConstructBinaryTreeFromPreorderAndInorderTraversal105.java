package main.java.com.problems.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

    public static void main(String[] args) {

    }


    /*
        preorder = [3,9,20,15,7]
        inorder = [9,3,15,20,7]


        Construct the original Binary Tree the preorder and inorder array
        were constructed from.

        1. Preorder start with the root, then left, then right
        2.We can take the first node in preorder array and assign it as the root
        3.Now that we have the root, we need to find it's position in our inorder array
                inorder = [9,    3    ,15,20,7]
        4.once we find its position we know that elements
            -on the left side of 3 will go on the left side of the Original Binary Tree
            -and  on the right side we have the elements that go on the right side
        5.create a middle point to separate left and right elements
        6.if mid is more the low, then check left side and constrcut left subtree
        7.if mid is more the high, then check right side and construct right subtree

    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            m.put(inorder[i], i);
        }
        return originalBinaryTree(preorder, m, 0, 0, inorder.length - 1);
    }

    /**

     we need to find the mid point in our inorder array, to do so, we can use a
     hashmap to store the value of the inorder array as key and its index as value

     m = {9: 0, 3: 1, 15: 2, 20: 3, 7: 4}

     preorder = [3,9,20,15,7]

     index = 0

     */

    public TreeNode originalBinaryTree(int[] preorder, Map<Integer, Integer> m,
                                       int index, int low, int high){

        TreeNode node = new TreeNode(preorder[index]);

        int mid = m.get(preorder[index]);

        if(mid > low){
            node.left = originalBinaryTree(preorder, m, index + 1, low, mid - 1);
        }
        if(mid < high){
            node.right = originalBinaryTree(preorder, m, index + mid - low + 1, mid + 1, high);
        }
        return node;
    }

}
