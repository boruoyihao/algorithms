package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 17-12-13.
 */

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Credits:
 Special thanks to @Freezen for adding this problem and creating all test cases.
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV_188 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int array[]=new int[]{7,1,5,7,4,9,3,10,2,10};
        System.out.println(solution.maxProfit(3,array));
    }

    private static class Solution {

        public int maxProfit(int k, int[] prices) {
            if(null==prices||1>=prices.length){
                return 0;
            }

            //如果可以的交易次数大于数组的一半，则意味着可以任意买卖
            int length=prices.length;
            if(k>=length/2){
                int max=0;
                for(int i=1;i<prices.length;i++){
                    if(prices[i]-prices[i-1]>0){
                        max+=prices[i]-prices[i-1];
                    }
                }
                return max;
            }

            int mem[][]=new int[k+1][prices.length];
            for(int i=1;i<=k;i++){
                int localMax=mem[i][0]-prices[0];
                for(int j=1;j<prices.length;j++){
                    mem[i][j]=Math.max(mem[i][j-1],localMax+prices[j]);
                    localMax=Math.max(localMax,mem[i-1][j]-prices[j]);
                }
            }
            return mem[k][length-1];
        }

        static void print(int[][]array){
            for(int i=0;i<array.length;i++){
                for(int j=0;j<array[i].length;j++){
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
