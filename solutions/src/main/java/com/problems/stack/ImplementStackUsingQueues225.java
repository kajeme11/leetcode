package main.java.com.problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/*

https://leetcode.com/problems/implement-stack-using-queues/description/

easy
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
 */

public class ImplementStackUsingQueues225 {
    public static void main(String[] args) {
        MyStack s = new MyStack();


    }



    static class MyStack3 {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        //initialize q1 and q2
        public MyStack3() {
            q1 = new ArrayDeque<>();
        }

        //add every element to q1
        public void push(int x) {
            // 1 2
            q1.add(x);
            for(int i = 0; i < q1.size() - 1; i++){
                q1.add(q1.poll());
            }
        }

        public int pop() {
            return q1.remove();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }


    /*
            used 2 quests to implement solution
            1.The main logic revolves around pushing elements to the queues
            2.Initially add the element to the empty q2
            3.while(q1 is not empty)
                poll elements from q1 and add them to q2
            4.Swap q1 and q2


     */
    static class MyStack2 {
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        //initialize q1 and q2
        public MyStack2() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        //add every element to q1
        public void push(int x) {
            q2.add(x);
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.remove();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     *
     *  Used a double ended queue, deque for solution
     *  appended elements to the back of deque,
     *  removed only from back
     *  and peeked from the back
     *  simulating a stack behavior
     *
     */

    static class MyStack {

        Deque<Integer> q;

        public MyStack() {
            q = new ArrayDeque<>();

        }

        public void push(int x) {
            q.addLast(x);
        }

        public int pop() {
            return q.pollLast();
        }

        public int top() {
            return q.peekLast();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
