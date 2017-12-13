package com.pku.leetcode.dynamicPrograming;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Seen this question in a real interview before?
 */
/**
 * Created by zhaolizhen on 17-12-12.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

    public static void main(String args[]){
        int array[]={1,2,3,0,2};
//        int array[]={1,9,6,9,1,7,1,1,5,9,9,9};
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(array));

    }
    private static class Solution1 {

        public int maxProfit(int[] prices) {
            if(prices.length<=1){
                return 0;
            }

            int localMin=prices[0];
            int maxProfit=0;
            int i=1;
            while(i<prices.length){
                if(prices[i]<prices[i-1]){
                    maxProfit+=prices[i-1]-localMin;
                    localMin=prices[i];
                }
                i++;
            }
            if(prices.length>=2&&prices[i-1]>=prices[i-2]){
                maxProfit+=prices[i-1]-localMin;
            }
            return maxProfit;
        }
    }


    private static class Solution {

        public int maxProfit(int[] prices) {
            if(prices.length<=1){
                return 0;
            }

            int maxProfit=0;
            int i=1;
            while(i<prices.length){
                maxProfit=Math.max(maxProfit+prices[i]-prices[i-1],maxProfit);
                i++;
            }
            return maxProfit;
        }
    }
}
