package main.java.com.problems.linkedlist;


/*
https://leetcode.com/problems/remove-linked-list-elements/description/

Easy
    Given the head of a linked list and an integer val, remove all
     the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElement203 {
    public static void main(String[] args) {

//        [1,2,6,3,4,5,6]
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
//        root.next.next.next.next = new ListNode(4);
//        root.next.next.next.next.next = new ListNode(5);
//        root.next.next.next.next.next.next  = new ListNode(6);
        int val = 2;
        ListNode r = removeElements(root, val);
        while (r != null){
            System.out.print(r.val + " -> ");
            r = r.next;
        }
        System.out.println(" null");
    }
    /*
              [1,2,2,1]       val = 2
              1 -> 2 -> 2 -> 1.     1 -> 1
      head    ^
      current           ^

  while current != null
  if current.next != null && current.next.val == val
      current.next = current.next.next
  else
      current = current.next

    1.Have current Node that points to head
    2.traverse list while current is not null
    3.if current.next is not null and current.next.val equals to val
        -make current.next point to current.next.next (current is still in its previous state)
      else move current to current's next
    4.After while loop check if head's value equals to the value target, if so, move head to next


  Time Complexity O(n), for n nodes traversed
  Space Complexity O(n)
  */
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode current = head;

        while(current != null){
            if(current.next != null && current.next.val == val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }
}
