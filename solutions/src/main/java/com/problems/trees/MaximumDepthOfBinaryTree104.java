package main.java.com.problems.trees;

public class MaximumDepthOfBinaryTree104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
    /**
     Iterative solution

     Time Complexity O(n)
     Space Complexity O(n)

     */
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         int max = 0;
//         while(!q.isEmpty()){
//             max++;
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 TreeNode n = q.poll();
//                 if(n != null){
//                     if(n.left != null){
//                         q.add(n.left);
//                     }
//                     if(n.right != null){
//                         q.add(n.right);
//                     }
//                 }
//             }
//         }
//         return max;
//     }
}
