package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-6-29.
 */

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.

 Example 1:

 Input: 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step

 */
public class Climbing_Stairs_70 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.climbStairs(4));
    }

    private static class Solution {
        public int climbStairs(int n) {
            if(n<=2){
                return n;
            }
            int pre1=1;
            int pre2=2;
            for(int i=3;i<=n;i++){
                int temp=pre2;
                pre2=pre1+pre2;
                pre1=temp;
            }
            return pre2;
        }
    }
}
