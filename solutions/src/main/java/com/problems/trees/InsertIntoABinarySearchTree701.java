package main.java.com.problems.trees;

public class InsertIntoABinarySearchTree701 {
    public static void main(String[] args) {

    }


    /**
     1.check if root is null, if so return a new node with value
     2.create a node(current) referencing root for traversal
     3.check if val is smaller than current's value
     - if val is smaller
     -check if current's left node is not null, current moves to left
     -else current left is created with val, BREAK
     else val is greater
     -check if current right is not null, current moves to right
     -else current right is created with val, BREAK

     Time Complexity O(n) for n nodes traversed
     Space Complexity O(1)
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode current = root;
        while(true){
            if(val < current.val){
                if(current.left != null){
                    current = current.left;
                }else{
                    current.left = new TreeNode(val);
                    break;
                }
            }else{
                if(current.right != null){
                    current = current.right;
                }else{
                    current.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

}
