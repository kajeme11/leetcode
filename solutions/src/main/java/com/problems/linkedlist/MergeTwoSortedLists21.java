package main.java.com.problems.linkedlist;


/*
https://leetcode.com/problems/merge-two-sorted-lists/description/

Easy

    You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
 */
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
//        Input: list1 = [1,2,4], list2 = [1,3,4]
//        Output: [1,1,2,3,4,4]

        ListNode res = mergeTwoLists(l1, l2);
        ListNode.displayList(res);

    }
    /*
        1.create result list that will traverse the 2 lists and add values in a sorted manner
        2.create dummy pointer that points at the head of result
        3.while list 1 and list 2 are not empty
            -check if list 1 holds a smaller value than list
            -is so, point result.next to it and move result and the list 1 pointers to the next node
            -else do the same with list 2, point result.next to list 2 and move both pointers
        4.check if list 1 is not empty, if it is not add the rest of the nodes to the result
        5.check if list 2 is not empty, if it is not add the rest of the nodes to the result
        6.return dummy.next

        Time Complexity O(n)
        Space Complexity O(1)
    */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                result.next = l1;
                l1 = l1.next;
            }else{
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        while(l1 != null){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }
        while(l2 != null){
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }
        return dummy.next;
    }
}
