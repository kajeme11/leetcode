package main.java.com.problems.arrays;

public class BestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        int[] prices = { 7,1,5,3,6,4};
//        Output: 5

        int[] prices2 = {7,6,4,3,1};
//        Output: 0
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        /*
            1.create variable to hold maxProfix
            2.create varible that will have currentBut at proces[0]
            3.traverse prices from 1 to n,
            check if currentBuy is more than prices[i]
             if so make currentBuy = prices[i]
             else
            4.maxProfit = Math.max(maxProfit, currentProfit);
            move the current bought stock

            Time Complexity O(n)
            Space Complexity O(1)
        */

        //[7,1,5,3,6,4]


        int maxProfit = 0;
        int currentBuy = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(currentBuy > prices[i]){
                currentBuy = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - currentBuy);
            }
        }

        return maxProfit;

    }
    /*
        [7,1,5,3,6,4]
               ^
        current = 3
        7 < 1, no current = 1

        1 < 5, Yes MAX(profit, prices[i] - current)
        1 < 3, Yes, Max(profit, prices[i] - current)
        1 < 6, Yes, Max(profit, prices[i] - current)
        1 < 4, Yes, Max(profit, prices[i] - current)

        5 < 3, no current = 3

     */
}
