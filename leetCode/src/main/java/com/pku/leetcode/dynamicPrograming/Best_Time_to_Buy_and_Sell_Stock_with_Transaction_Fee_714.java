package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 17-12-30.
 */

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

 You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

 Return the maximum profit you can make.

 Example 1:
 Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 Output: 8
 Explanation: The maximum profit can be achieved by:
 Buying at prices[0] = 1
 Selling at prices[3] = 8
 Buying at prices[4] = 4
 Selling at prices[5] = 9
 The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 Note:

 0 < prices.length <= 50000.
 0 < prices[i] < 50000.
 0 <= fee < 50000.

 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee_714 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int array[]=new int[]{1,3,2,8,10,4,9};
        System.out.println(solution.maxProfit(array,2));
    }

    private static class Solution {
        public int maxProfit(int[] prices, int fee) {
            if(null==prices||prices.length<1){
                return 0;
            }

            int cash=0;
            int holder=-prices[0];
            for(int i=1;i<prices.length;i++){
                cash=Math.max(cash,prices[i]+holder-fee);
                holder=Math.max(holder,cash-prices[i]);
            }
            return cash;
        }
    }
}
