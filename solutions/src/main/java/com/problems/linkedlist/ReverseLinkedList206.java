package main.java.com.problems.linkedlist;

/*
https://leetcode.com/problems/reverse-linked-list/description/

Easy
    Given the head of a singly linked list, reverse the list,
    and return the reversed list.


 */
public class ReverseLinkedList206 {
    public static void main(String[] args) {

        //1 2 3 4 5
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next  = new ListNode(5);
        ListNode reversed = reverseList(root);
        while (reversed != null){
            System.out.print(reversed.val + " -> ");
            reversed = reversed.next;
        }
        System.out.println(" Null");
    }
    /*
                      1 -> 2 -> 3 -> 4 -> 5
                p  <- c   n
                   <- p <-c    n
                          p  <-c    n
                               p <- c.    n
                                    p     c   n
      prev = null
      current = head
      next = cuurent.next
      ---
      current.next = previous
      previous = current
      current = next
      next = current.next

      1.handle base case, if linked list is empty return null
      2.create a node (prev) pointing at null and another (current) pointing to head
      3.while current is not null
      -have a placeholder for current's next node (nextnode)
      -make current point to prev
      4.Move prev to current and current to the placeholder (nextNode)
      5.return prev

      Time Complexity O(n), traversing n nodes
      Space Complexity O(1)

   */
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
