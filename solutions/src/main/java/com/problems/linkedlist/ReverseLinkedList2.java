package main.java.com.problems.linkedlist;


/*
https://leetcode.com/problems/reverse-linked-list-ii/description/

Medium
    Given the head of a singly linked list and two integers left and right where left <= right,
    reverse the nodes of the list from position left to position right, and return the reversed list.
 */

public class ReverseLinkedList2 {
    public static void main(String[] args) {

        int left = 2;
        int right = 4;
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
//        Input: head = [1,2,3,4,5], left = 2, right = 4
//        Output: [1,4,3,2,5]
        reverseBetween(root, left, right);
        ListNode.displayList(root);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

/*
left = 3, right = 4
                       h     L         R
          -1  ->       1     2    3    4    5

    dummy ^
    prev  ^            ^

    1. create a dummy pointer pointing at any value, not from the list, dummy.next point to head
    2.Create a prev ListNode to point at dummy
        -move prev pointer to the node before left value
        -for i = 1; i < left => prev = prev.next
    3.create 2 placeHolders using prev
        -previous pointing to node previous to left-index
        -current pointing to the actual left-index node
    4.create 2 moving pointers to simulate a regular linkedlist traversal
        -prev can be set to null, or create a new ListNode prevNode that points to null
        -currNode pointing to current
    5.we will not traverse the list until current is not null such as a normal LL reversal
        - We will traverse the list from i = 0 to i <= right - left
        This is the size of the list from left-index to right-index given as arguments
        for(int i = 0; i <= right - left; i++){
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }
    6.notice the logic is the same as in a normal LL reversal
    7.Now we have to update our placeholders next references
        -previous.next = prev;
        -current.next = currNode;
    8.return dummy.next;





    Time Complexity O(n)
    Space Complexity O(1)

*/
        if(head == null || left == right){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 1; i < left; i++){
            prev = prev.next;
        }
        /**
                      1    2    3    4    5
         dummy ^
         prev. ^      ^
         */
        //placeholders
        ListNode previous = prev;
        ListNode current = prev.next;

        //moving pointers, just like a normal reversal
        ListNode currNode = current;
        prev = null;
        //move pointers for i = 0 i <= right - left (list size from left to right)
        for(int i = 0; i <= right - left; i++){
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }
        previous.next = prev;
        current.next = currNode;

        return dummy.next;
    }


    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

/*
r = 4
l = 2
r-l = 2

                   L     R
                1->2<-3->4->5
       dummy  ^
    prevNode    ^
    currNode.      ^
    nextNode.        ^
    holder.     ^
    nextNode = currNode.next
    currNode.next = prevNode
    prevNode = currNode
    currNode = nextNode

i = 3

*/

        for(int i = 1; i < left; i++){
            prev = prev.next;
        }
        ListNode prevNode = prev;
        ListNode currentNode = prev.next;
        ListNode prevHolder = prev;

        for(int i = 0; i <= right - left; i++){
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = nextNode;
        }
        // System.out.println(prevNode.val);
        // System.out.println(currentNode.val);
        prevHolder.next = prevNode;
        while(prevNode.next != prevHolder){
            prevNode = prevNode.next;
        }
        prevNode.next = currentNode;

        return dummy.next;

    }

}
