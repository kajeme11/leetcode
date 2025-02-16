package main.java.com.problems.trees;

import java.util.ArrayList;

public class BalanceBinarySearchTree1382 {
    public static void main(String[] args) {

    }

    /*
        given root of binary tree, return a bst

        1.create a list from the binary tree given using inorder traversal
        2.create a method that will take the list, starting index and
        ending index and will use binary search to get midlle index as root
        3.then traverse left side recursively with starting index and
        ending index as mid - 1
        4.then traverse right side recursively with starting index as mid+1
        and ending as end

        Time Complexity O(n), for n nodes in binary tree
        Space Complexity O(n), for  space used and list
    */

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> inorderList = new ArrayList<>();
        inorderList(root, inorderList);
        return create_bst(inorderList, 0, inorderList.size() - 1);
    }

    public void inorderList(TreeNode root, ArrayList<TreeNode> inorderList){
        if(root == null){
            return;
        }

        inorderList(root.left, inorderList);
        inorderList.add(root);
        inorderList(root.right, inorderList);
    }

    public TreeNode create_bst(ArrayList<TreeNode> list, int start, int end ){

        if(start > end){
            return null;
        }

        int mid = (end + start)/2;

        TreeNode bst = list.get(mid);
        bst.left = create_bst(list, start, mid - 1);
        bst.right = create_bst(list, mid + 1, end);

        return bst;
    }
}
