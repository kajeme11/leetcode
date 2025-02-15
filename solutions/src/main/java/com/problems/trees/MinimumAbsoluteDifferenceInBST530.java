package main.java.com.problems.trees;

public class MinimumAbsoluteDifferenceInBST530 {

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST530  m = new MinimumAbsoluteDifferenceInBST530();
        System.out.println(m.getMinimumDifference(new TreeNode(5)));


    }


    /**
     we can use inorder traversal to traverse BST from the smallest number
     to the highest. Since we have a BST it means values close to each other
     will give us the closest minimum difference

     25
     15           35
     14  17      27    40
     7
     minimum difference is 1, from 15 - 14, nodes close to each other
     nodes from further apart would not be able to give us the minimum difference

     1.create a previous Integer object that will hold the previous node's value
     to substract from a current node near by
     2.create the min result object that will hold the result
     3.do an inorder traversal
     -check if node is null, if it is, return
     -traverse left recursively
     -check if prev is not null, if not null take the minimum
     between min and node.val - prev
     -prev becomes node's val
     -traverse right sode recursively

     Time Complexity O(n), for n nodes traversed
     Space complexity O(n), for memory stacks used in recursive calls

     */

    Integer min = Integer.MAX_VALUE;
    Integer prev;
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);

    }
}
