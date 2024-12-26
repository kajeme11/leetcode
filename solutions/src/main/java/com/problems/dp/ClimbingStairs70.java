package main.java.com.problems.dp;

/*
https://leetcode.com/problems/climbing-stairs/description/

Easy
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?

 */
public class ClimbingStairs70 {
    public static void main(String[] args) {
        int n = 2;
//        Output: 2

        int n2 = 3;
//        Output: 3
        System.out.println(climbStairs(n));
        System.out.println(climbStairs(n2));
    }
    public static int climbStairs(int n) {
       /*
            Input: n = 3

    -can only take 1 to 2 steps, how many distinct ways does it take to n steps
    - for 0 steps, we take 0
    - for 1 steps, only 1 way
    - for 2 steps, only 2 ways
i    step 1   step 2
0    0 - 0     0 - 0
1    1 - 1  +  1 - 0 = 1
2    2 - 1  +  2 - 1 = 2
3    3 - 1  +  3 - 2 = 3

    dp = new int[stpes + 1]
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp = dp[i - 2] + dp[i - 1])

    1. we need a table to store our results
    so we create a dp[n + 1] array
    2. we store initial sum values in the array
    3. we add dp[i - 1] + dp[i - 2] to dp[i]
    4 the sum of the previous 2 values add up to the
    many different ways we can climb n steps

    Time complexity O(n), for traversing n elements
    Space Complaxity O(n), for array[n + 1]
       */
        if(n < 2){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
