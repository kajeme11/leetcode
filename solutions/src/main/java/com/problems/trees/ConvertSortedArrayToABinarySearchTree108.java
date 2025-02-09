package main.java.com.problems.trees;

public class ConvertSortedArrayToABinarySearchTree108 {
    public static void main(String[] args) {

    }
    /**
     Input: nums = [-10,-3,0,5,9]

     1.we are given a sorted array, we have to convert it into a bst
     2.Since the array is sorted we can find the root value in the middle
     and all the smaller values tio the left and higher values to the right
     3.check if left index is larger than right, if so return null
     4.find middle element, left + (right - left)/2
     5.create node with middle element
     6.for node.left, recursively call function with left and mid - 1 as right
     7.for node.right, recursively call function with mid + 1 as left and right

     Time Complexity O(n), for processing each element in array
     Time Complexity O(n), for storing all elements in array into a bst

     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }
    public static TreeNode bst(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bst(nums, left, mid - 1);
        node.right = bst(nums, mid + 1, right);
        return  node;
    }
}
