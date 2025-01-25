package main.java.com.problems.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum112 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.right = new TreeNode(8);
        t.right.left = new TreeNode(13);
        t.right.right = new TreeNode(4);
        t.right.right.right = new TreeNode(1);
        t.left = new TreeNode(4);
        t.left.left = new TreeNode(11);
        t.left.left.left = new TreeNode(7);
        t.left.left.right = new TreeNode(2);

        List<List<Integer>> path = hasPathSum(t, 22);
        System.out.println(path);
    }
    /*

        1.Use level order traversal to store current sum at each node
        2.Use 2 stacks, 1 keeping track of the nodes, and another keeping track of the current Sums
        3.while path is not empty
            -poll the current node
            -poll the current sum
            -check if current node's left and right children are null, and value equals the targetSum
                -if so, return true
            -check if node has left children, if so add left child to path stack and add sum of
            value and left value to sumStack
            -check if node has right children, if so add right child to path stack and add sum of
            value and right value to sumStack

        Time Complexity O(n), for iterating n nodes only once
        Space Complexity O(n), for storing n nodes in stack
    */
        public static boolean hasPathSum2(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            }
            Stack<TreeNode> path = new Stack<>();
            Stack<Integer> sum = new Stack<>();
            path.push(root);
            sum.push(root.val);

            while(!path.isEmpty()){
                TreeNode n = path.pop();
                int value = sum.pop();
                if(n.left == null && n.right == null && value == targetSum){
                    return true;
                }
                if(n.left != null){
                    path.push(n.left);
                    sum.add(value + n.left.val);
                }
                if(n.right != null){
                    path.push(n.right);
                    sum.add(value + n.right.val);
                }
            }
            return false;
        }



    /**
     *
     *
     *
     *      Time Complexity O(n^2), if there is a skewed tree, similar to linkedList, then copying each path
     *          would lead to [[1], [1, 2], [1, 2, 3].....]
     *      Space Complexity(h), for memory stack used in recursive calls depending on height
     */
    public static List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    public static void  dfs(TreeNode node, int target, List<Integer> currentPath, List<List<Integer>> result){

        //check if root is null, return end recursion
        if(node == null){
            return;
        }
        //add node's value to current path
        currentPath.add(node.val);
        //if node's left and right children are null AND the current's node value equals to currentSum, add current path to result
        //since we subtracted the node's value from target in each recursive call eventually it is possible target will equal to node's value
        if(node.right == null && node.left == null && node.val == target){
            result.add(new ArrayList<>(currentPath));
        }
        //recursive call, with left child and subtracting node value to target
        dfs(node.left, target - node.val, currentPath, result);
        //recursive call, with right child and subtracting node value to target
        dfs(node.right, target - node.val, currentPath, result);

        //backtrack by removing last node added in current path
        currentPath.remove(currentPath.size() - 1);
    }
}
