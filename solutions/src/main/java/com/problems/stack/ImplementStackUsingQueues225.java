package main.java.com.problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementStackUsingQueues225 {
    public static void main(String[] args) {
        MyStack s = new MyStack();

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
