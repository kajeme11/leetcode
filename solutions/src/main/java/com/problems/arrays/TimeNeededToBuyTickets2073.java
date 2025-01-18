package main.java.com.problems.arrays;


/*

https://leetcode.com/problems/time-needed-to-buy-tickets/description/

Easy
    There are n people in a line queuing to buy tickets,
    where the 0th person is at the front of the line
    and the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length
n where the number of tickets that the ith person would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket.
A person can only buy 1 ticket at a time and has to go
 back to the end of the line (which happens instantaneously)
  in order to buy more tickets. If a person
does not have any tickets left to buy, the person will leave the line.
 */
public class TimeNeededToBuyTickets2073 {

    public static void main(String[] args) {

        int[] a = {2, 3, 5, 7, 8};
        System.out.println(timeRequiredToBuy(a, 2));

    }

    /**


     a            [3, 2, 3, 5, 1]
     i             ^
     k                ^
     n = 0
     to get from index 0 to k, we need to make a[k] passes
     we can take the minimum between a[i] and a[k]
     else
     if i > k then there are a[k] - 1 passes
     so we take the minimum between a[k] - 1, a[i]

     [5,1,1,1] k = 0
     4 0 0 0
     3
     2
     1
     i            ^
     n = 0


     Time Complexity O(n),
     Space Complexity O(1)
     */
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for(int i = 0; i < tickets.length; i++){
            if(i <= k){
                time += Math.min(tickets[k], tickets[i]);
            }else{
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return time;
    }

    public static int timeRequiredToBuy1(int[] tickets, int k) {

        int time = 0;
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i] < tickets[k]){
                time += tickets[i];
            }else{
                time += tickets[k];
            }
            if(i > k && tickets[i] >= tickets[k]){
                time--;
            }
        }

        return time;
    }
}
