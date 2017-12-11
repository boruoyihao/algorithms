package com.pku.leetcode.dynamicPrograming;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 */
/**
 * Created by zhaolizhen on 17-12-11.
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {

    public static void main(String args[]){
        int array[]={7,6,6,1,30};
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(array));
    }

    //TLE
    private static class Solution1 {
        public int maxProfit(int[] prices) {
            int maxProfix=0;
            for(int i=0;i<prices.length;i++){
                for(int j=i+1;j<prices.length;j++){
                    maxProfix=Math.max(maxProfix,prices[j]-prices[i]);
                }
            }
            return maxProfix;
        }
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length<=1){
                return 0;
            }
            int maxProfix=0;
            int minI=prices[0];
            int i=1;
            while(i<prices.length){
                maxProfix=Math.max(maxProfix,prices[i]-minI);
                minI=Math.min(minI,prices[i]);
                i++;
            }
            return maxProfix;
        }
    }
}
