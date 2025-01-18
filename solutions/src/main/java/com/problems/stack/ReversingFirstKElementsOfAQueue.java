package main.java.com.problems.stack;

import java.sql.Array;
import java.util.*;

public class ReversingFirstKElementsOfAQueue {
    public static void main(String[] args) {

        /*

                queue  10   20  30  40  50  60  70  80  90  100, size of queue is 10
                k = 4
                i = 0 i < k
                i = 3, after loop finishes
                srack = 10  20  30  40

                queue   50  60  70  80  90  100
                add stack to queue, since pop removes from the top of stack
                we will have our numbers reversed after adding to queue
                queue = 50  60  70  80  90  100 40  30  20  10

                Now all that is left to is to poll elements from queue and add them to the back
                for i < queue size, i is currently 3

                Time Complexity O(n), for traversing n elements
                Space Complexity O(k), for storing k elements
         */

        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);

        reverseKElementsInQueue(q, 4);
        for(int i = 0; i < q.size(); i++){
            int poll = q.poll();
            System.out.println(poll);
            q.add(poll);
        }
    }

    public static void reverseKElementsInQueue(Queue<Integer> q, int k){
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for(; i < k; i ++){
            s.add(q.poll());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        for(;i < q.size(); i++){
            q.add(q.poll());
        }
    }
}
