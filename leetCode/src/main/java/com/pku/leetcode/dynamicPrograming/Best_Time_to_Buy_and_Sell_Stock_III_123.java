package com.pku.leetcode.dynamicPrograming;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


 */

/**
 * Created by zhaolizhen on 17-12-12.
 */
public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

    public static void main(String args[]){
        int prices[]={3,9,1,9,8,7,6,5,4,3,2,1};
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(prices));
    }

    private static class Solution1 {
        public int maxProfit(int[] prices) {
            if(prices.length<=1){
                return 0;
            }
            int fromStart[]=new int[prices.length];
            int fromEnd[]=new int[prices.length];
            int sofarMin=prices[0];
            for(int i=1;i<prices.length;i++){
                fromStart[i]=Math.max(fromStart[i-1],prices[i]-sofarMin);
                sofarMin=Math.min(sofarMin,prices[i]);
            }

            int sofarMax=prices[prices.length-1];
            for(int i=prices.length-2;i>=0;i--){
                fromEnd[i]=Math.max(sofarMax-prices[i],fromEnd[i+1]);
                sofarMax=Math.max(sofarMax,prices[i]);
            }

            int max=0;
            for(int i=0;i<prices.length;i++){
                max=Math.max(max,fromStart[i]+fromEnd[i]);
            }
            return max;
        }
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length<=1){
                return 0;
            }

        }
    }
}
