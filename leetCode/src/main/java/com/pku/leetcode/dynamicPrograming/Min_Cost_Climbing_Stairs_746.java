package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-6-29.
 */

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

 Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

 Example 1:
 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 Example 2:
 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 Note:
 cost will have a length in the range [2, 1000].
 Every cost[i] will be an integer in the range [0, 999].
 */
public class Min_Cost_Climbing_Stairs_746 {

    public static void main(String args[]){
        Solution solution=new Solution();
//        int array[]={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        System.out.println(solution.minCostClimbingStairs(array));
        int array[]={0,0,0,1};
        System.out.println(solution.minCostClimbingStairs(array));
    }


    //Accepted
    private static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int mem[]=new int[cost.length];

            if(cost.length==1){
                return cost[0];
            }else if (cost.length==2){
                return Math.min(cost[0],cost[1]);
            }
            mem[0]=cost[0];
            mem[1]=cost[1];
            for(int i=2;i<cost.length;i++){
                mem[i]=Math.min(mem[i - 1] + cost[i], mem[i - 2] + cost[i]);
            }
            return Math.min(mem[cost.length-2],mem[cost.length-1]);
        }
    }
}
