package main.java.com.problems.stack;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/description/

Easy

   Given a string s containing just the characters
   '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

 */

public class ValidParentheses20 {
    public static void main(String[] args) {

        String s = "([])";
        //true
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {

        /*
                ([])

        cArr  ['(', '[', ']', ')']
        stack = [, [
                1.convert s to char array
                2.create a stack
                -if cArr[i] is (, [, { push to ctack
                -else{
                    if(a[i] == ']' && stack.peek('['))
                        stack.pop()
                    else if(a[i] == ')' && stack.peek('('))
                        stack.pop()
                    else if(a[i] == } && stack.peek('{'))
                        stack.pop()
                    else
                        return false
                }
        return stack.isEmpty();

        Time Complexity O(n), checking n characters in string
        Space Complexity O(n), for character space in Stack

        */

        char[] cArr = s.toCharArray();
        int n = cArr.length;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(cArr[i] == '(' || cArr[i] =='[' || cArr[i] =='{'){
                stack.push(cArr[i]);
            }else{
                if(stack.isEmpty())  return false;
                if(cArr[i] == ')' && stack.peek() == '('){
                    stack.pop();
                }else if(cArr[i] == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(cArr[i] == '}' && stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
