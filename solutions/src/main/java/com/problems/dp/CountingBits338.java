package main.java.com.problems.dp;

import java.util.Arrays;

/*
https://leetcode.com/problems/counting-bits/description/

easy

Given an integer n, return an array ans of length n + 1
such that for each i (0 <= i <= n),
 ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits338 {

    public static void main(String[] args) {
        int n = 2;
//        Output: [0,1,1]

        int n2 = 5;
//        Output: [0,1,1,2,1,2]
        System.out.println(Arrays.toString(countBits(n)));
        System.out.println(Arrays.toString(countBits(n2)));
    }
    public static  int[] countBits(int n) {

        /*
            n      bit-representation.    offset.  i      formula = 1 + dp[i - offset]
            0              0000             0
            1              0001             1       1    1 + dp[1 - 1] = 1
            2              0010             2       2    1 + dp[2 - 2] = 1, back to n = 0
            3              0011             2       3    1 + dp[3 - 2] = dp[1] = 2
            4              0100             4       4    1 + dp[4 - 4] = 1,  back to n = 0
            5              0101             4       5    1 + dp[5 - 4] = dp[1] = 2
            6              0110             4       6    1 + dp[6 - 4] = dp[2] = 2
            7              0111             4       7    1 + dp[7 - 4] = dp[3] = 3
            8              1000             8       8    1 + dp[8 - 8] = 1,  back to n = 0

            1.Create a dp array that will store n + 1 values
            2.initially all the values are 0, so no need to reevaluate dp[0] tp 0
            3.have an offset varuable starting at 1 that will help us evaluate our previus dp values
                our offset will look something like this
                2^0 = 1, 2^1 = 2, 2^2 = 4, 2^3 = 8 ...
            4.traverse from i = 1 to i <=n
                if offset * 2 == i, them offset = i
            5.store our results
            dp[i] = 1 + dp[i - offset]

            Time Complexity O(n)
            Space Complexity O(n)
        */

        int[] dp = new int[n + 1];
        int offset = 1;
        for(int i = 1; i <= n; i++){
            if(offset * 2 == i){
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}

