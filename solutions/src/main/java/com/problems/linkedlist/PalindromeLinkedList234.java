package main.java.com.problems.linkedlist;

/*
https://leetcode.com/problems/palindrome-linked-list/description/

Easy
Given the head of a singly linked list, return true if it is a
palindrome
 or false otherwise.


 */

public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
         root.next = new ListNode(2);
         root.next.next = new ListNode(3);
         root.next.next.next = new ListNode(4);
         root.next.next.next.next  = new ListNode(5);

        System.out.println(isPalindrome(root));
    }

    /*
        1.have a current pointer poiting to head
        2.Create a slow and fast pointes to find middle of linked list
        3.reverse the list starting from the slow pointer
        4.Now we can check if current value == slow value
        and move current and slow pointer
        5.if the value are not the same return false
        6.if loop did not find different values return true

        Time Complexity O(n)
        Space Complexity O(1)
     */
    public static boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }
        if(head.next.next == null && head.val != head.next.val){
            return false;
        }
        if(head.next.next == null && head.val == head.next.val){
            return true;
        }

        ListNode current = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        while(current != null && slow != null){
            if(current.val != slow.val){
                return false;
            }
            current = current.next;
            slow = slow.next;
        }

        return true;
    }
    public static ListNode reverse(ListNode node){
        ListNode current = node;
        ListNode prev = null;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
