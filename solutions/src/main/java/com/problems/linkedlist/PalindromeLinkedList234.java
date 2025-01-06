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

            1.check if head is null and hea.next is null, if it is return true
            2.create a slow pointer and fast pointer to find the middle of a linked list
            3.reverse slow pointer
            4.create a current node pointing at head
            5.while slod pointer is not null, check if current's value equals to
            the value in slow pointer
                -if values don't match return false
            6.return true asterwards if every value matched

            Time Complexity O(n)
            Space Complexity O(1)
    */
    public static boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        ListNode current = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         1 2 3 4 5 6 7 8
         s
         f
         1 2 3 4 5 6 7 8 9
         s
         f

         */
        slow = reverse(slow);
        while(slow != null){
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
