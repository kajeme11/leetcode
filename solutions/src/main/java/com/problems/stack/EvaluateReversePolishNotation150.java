package main.java.com.problems.stack;

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

Medium

You are given an array of strings tokens that represents
an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents
 the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be
represented in a 32-bit integer.
 */

import java.util.Stack;

public class EvaluateReversePolishNotation150 {

    public static void main(String[] args) {

        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        Output: 22
//        Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//                = ((10 * (6 / (12 * -11))) + 17) + 5
//                = ((10 * (6 / -132)) + 17) + 5
//                = ((10 * 0) + 17) + 5
//                = (0 + 17) + 5
//                = 17 + 5
//                = 22
        System.out.println(evalRPN(tokens));
    }


    /*
         tokens = ["2","1","+","3","*"]

         1.Create a Stack of String elements
         2.loop over the string array
         3.We have 2 options
            -if string is an integer, add to stack
            -else
            pop last 2 previous elements from stack as left and right
            if tokens[i] == +, then add right and left
            if tokens[i] == -, then substract right and left
            if tokens[i] == *, then multiply right and left
            else divide right and left
            push to stack

            return stack.pop

            Time Complaxity O(n), for n strings in array
            Space complexity O(n), using a stack to store n strings
    */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for(String current: tokens){
            if(!(current.equals("+") || current.equals("-") || current.equals("*") ||
                    current.equals("/"))){
                stack.push(Integer.parseInt(current));
            }else{
                int left = stack.pop();
                int right = stack.pop();
                if(current.equals("+")){
                    stack.push(right + left);
                }else if(current.equals("-")){
                    stack.push(right - left);
                }else if(current.equals("*")){
                    stack.push(right * left);
                }else{
                    stack.push(right / left);
                }
            }
        }
        return stack.pop();
    }
}

