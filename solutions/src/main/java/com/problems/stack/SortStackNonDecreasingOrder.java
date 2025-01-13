package main.java.com.problems.stack;

import java.util.Stack;

public class SortStackNonDecreasingOrder {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack = sortStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    /*

            stack = { 1, 5, 3, 2 }

            1.create a tempStack, that will be returned with
            the sorted stack
            2.while our original stack is not empty keep looping
            3.pop element from stack into a variable number
            4.start a second while loop
                while our tempStack is not empty AND our number is more then tempStack.peek()
                    -if tempStack not empty and number is more then tempStack.peek(), pop
                    the element at temp and add it back to stack
            -after the nested while loop, add the number to tempStack

        Time Complexity O(n^2), for traversing n elements in stack,
                                and popping out all elements once again for sorting
        Space Complexity O(n), for temp stack used to store sorted elements

     */

    private static Stack<Integer> sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()){
            int number = stack.pop();
            while (!tempStack.isEmpty() && number > tempStack.peek()){
                stack.push(tempStack.pop());
            }
            tempStack.add(number);
        }
        return tempStack;
    }
}
