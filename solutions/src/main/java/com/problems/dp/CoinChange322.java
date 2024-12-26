package main.java.com.problems.dp;

import java.util.Arrays;

public class CoinChange322 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
//        Output: 3

        int[] coins2 = {2};
        int amount2 = 3;
//        Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
//        Output: 0
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange(coins2, amount2));
        System.out.println(coinChange(coins3, amount3));
    }
    public static int coinChange(int[] coins, int amount) {
        /*
            coins = [1,2,5], amount = 11
            dp[0] = 0
            i = 1; i < amount.length; i++;
            dp[i] = min(dp[i], dp[i] + 1)
            how many coins to make
            Take the min as you build up to the answer
            coin 1          coin 2 and 1      coin 5 , 1 and 2
            0 - 0           0 - 0               0 - 0
            1 - 1           1 - 1               1 - 1
            2 - 2           2 - 1               2 - 1
            3 - 3           3 - 2               3 - 2
            4 - 4           4 - 2               4 - 2
            5 - 5.          5 - 3               5 - 1
            6 - 6           6 - 3               6 - 2
            7 - 7           7 - 4               7 - 2
            8 - 8           8 - 4               8 - 3
            9 - 9           9 - 5               9 - 3
            10 - 10         10 - 5              10 - 2
            11 - 11         11 - 6              11 - 3

            1.create a table to store values that add up to a specific coin
            dp[amount + 1] add 1 to the size because we need to build to the amount
            0 to 11 is 12 indexes long, dp[amount] returns the last index 11
            2.traverse each coin, to fill in the table from coin to amount
            3.traverse from i = coin to i <= coin, because we can't make
            smaller value change with a bigger value coin
            4.if dp[i - coin] != Integer.MAX_VALUE
            take the minimum dp[i] = MIN(dp[i], dp[i - coin] + 1)

            Time Complexity O(n * m) coins length * amount
            Space Complexity O(n), for the dp array
        */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int coin: coins){
            for(int i = coin; i <= amount; i++){
                if(dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? - 1: dp[amount];
    }
}
