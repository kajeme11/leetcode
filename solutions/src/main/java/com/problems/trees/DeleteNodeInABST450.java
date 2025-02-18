package main.java.com.problems.trees;

public class DeleteNodeInABST450 {
    public static void main(String[] args) {

    }


    /*
        We are given a bst and a key to delete a corresponding node

        1.if root is null, return null
        2.if key is less than root.val, make a recursive call with root.left
        3.else if key is more than current root's val make a recursive call with root.right
        4.else we have found the key, we have 3 posibilities
            - 1. if root, has no children, return null
            - 2. else if root has 1 child, either left or right
                -if right is not null return left
                -if left is not null return right
            - 3. else root has 2 children, we have to choose 1 of the following:
                -either the minium element from the right subtree
                - or the maximum element from the left subtree

            Time Complexity O(logn), since it is a balanced tree
            Space Complexity O(h), for height of tree used in smemory space used in stack

    */

    public TreeNode deleteNode(TreeNode root, int key) {
        //root is null
        if(root == null){
            return null;
        }
        //key is less than current root val
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }

        //key is more then current root val
        else if (key > root.val){
            root.right = deleteNode(root.right, key);
        }else{

            //key is equal to current root's val, we have 3 possibilities
            //root has no children, has 1 child, or has 2 children

            //root has no children
            if(root.left == null && root.right == null){
                return null;
            }
            //root has 1 child, either left or right is not null
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else if(root.right == null && root.left != null){
                return root.left;
            }
//traverse right subtree and find min val from left side
//we can do the same with left subtree and find the max val from right sode
            TreeNode node = root.right;
            int minLeftValue = node.val;
            while(node.left != null){
                minLeftValue = node.left.val;
                node = node.left;
            }
            root.val = minLeftValue;
            root.right = deleteNode(root.right, root.val);
                /*
                root has both children
                -replace root with child
                    -2 cases, one or the other:
                    -child => minimum element of right subtree,
                    Find the Inorder Successor smallest value in the right subtree).
                    -child => maximum element of left subtree
                    Find the Inorder Predecessor (largest value in the left subtree).
                */
        }
        return root;
    }
}
