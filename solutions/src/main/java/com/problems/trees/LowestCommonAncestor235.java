package main.java.com.problems.trees;

public class LowestCommonAncestor235 {


    public static void main(String[] args) {

    }


    /**
     1.check values for p and q, if they are less then the root's value then
     recursively traverse left side
     2.if p and q are greater than the root's value recursively traverse right side
     3.return root

     Time Complexity O(logN), since the tree is structured so we cut time by half
     Space Complexity O(logN), since the tree is structured and we only traverse either left or right
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root != null && root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(root != null && root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
