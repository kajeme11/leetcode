package main.java.com.problems.linkedlist;

public class LinkedListCycle141 {

    /*
    https://leetcode.com/problems/linked-list-cycle/description/

    Easy
        Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
//        Input: head = [3,2,0,-4]
        //true
        System.out.println(hasCycle(head));
    }


    /*
    Floyd's Tortoise and Hare Algorithm

        1.create a slow and fast pointer that point to the head
        2.while fast is not null and fast.next is not null
        -move slow pointer to its next node
        -move fast pointer to its next next node
        -check if they are the same, if they are return true
        -return fasle if no cycle is detected

        Time Complexity O(n), for n nodes trversal
        Space Complexity O(1), used 2 pointer (slow fast) approach
    */
    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
