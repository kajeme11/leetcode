package main.java.com.problems.linkedlist;

public class ListNode {
    int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      public static void displayList(ListNode node){
          while(node != null){
              System.out.print(node.val + " -> ");
              node = node.next;
          }
          System.out.println(" Null");
      }
}
