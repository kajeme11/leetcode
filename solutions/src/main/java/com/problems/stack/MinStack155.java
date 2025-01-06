package main.java.com.problems.stack;

import java.util.Stack;

/*
https://leetcode.com/problems/min-stack/description/

Medium

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class MinStack155 {
    public static void main(String[] args) {
        MinStack155 s = new MinStack155();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
    }

    /*
        Create a main stack that stores every value coming in
        Create a min stack to push min values to it
        ex:
            push 3, 5, 2 6 -3
            getMin = -3
            stack =  -3 6 2 5 3
            5 is not less than 3, don't add
            minstack =  -3 2 3

            pop
            stack =  -3 6 2 5 3
            if pop == minStack.peek(), pop minstack
            minstack =  -3 2 3

            push method, only push to minStack if it is empty or value is less or equal to minStack.peek()
            pop method, only pop from minStack if popped value from main stack equals to minStack.peek()
     */
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        int pop = stack.pop();
        if(pop == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
