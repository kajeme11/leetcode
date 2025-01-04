package main.java.com.problems.linkedlist;

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
