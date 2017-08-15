package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 17-8-13.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

 Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

 Example 1:
 Input: [1, 5, 2]
 Output: False
 Explanation: Initially, player 1 can choose between 1 and 2.
 If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 Hence, player 1 will never be the winner and you need to return False.
 Example 2:
 Input: [1, 5, 233, 7]
 Output: True
 Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
 Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 Note:
 1 <= length of the array <= 20.
 Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 If the scores of both players are equal, then player 1 is still the winner.

 */
public class Predict_the_Winner_486 {
    public static void main(String args[]){
        Solution s=new Solution();
        int []nums={1, 5, 2};
        System.out.println(s.PredictTheWinner(nums));

        int []nums1={1, 5, 233, 7};
        System.out.println(s.PredictTheWinner(nums1));

        int []nums2={1,1,1};
        System.out.println(s.PredictTheWinner(nums2));

    }

    private static class Solution {
        private static Map<String,Boolean> map=new HashMap<String,Boolean>();
        public boolean PredictTheWinner(int[] nums) {
            if(null==nums||0==nums.length){
                return false;
            }
            if(nums.length==1){
                return true;
            }
            int []state=new int[nums.length];
            return dfs(nums,state,0,0,0)||dfs(nums,state,nums.length-1,0,0);
        }

        public boolean dfs(int[] nums,int []state,int index,int count,int sum){
            if(count>= nums.length&&sum<=0){
                return false;
            }
            if(state[index]==1){
                return false;
            }
            state[index]=1;
            if(!dfs(nums,state,(index+1)%nums.length,count+1,0-sum+nums[index])
                    || !dfs(nums,state,(index-1+nums.length)%nums.length,count+1,0-sum+nums[index])){
                return true;
            }
            state[index]=0;
            return false;
        }

    }

    /*
    private static class Solution {
        private static Map<String,Boolean> map=new HashMap<String,Boolean>();
        public boolean PredictTheWinner(int[] nums) {
            if(null==nums||0==nums.length){
                return false;
            }
            if(nums.length==1){
                return true;
            }
            int []state=new int[nums.length];
            return dfs(nums,state,0,0,true,0,0)||dfs(nums,state,nums.length-1,0,true,0,0);
        }

        public boolean dfs(int[] nums,int []state,int index,int count,boolean status,int player1,int player2){
            if(count>=nums.length&&player1>=player2){
                return true;
            }else if(count>=nums.length&&player1<player2){
                return false;
            }

            if(state[index]==1){
                return false;
            }

            state[index]=1;
            if(status==true){
                player1+=nums[index];
            }else{
                player2+=nums[index];
            }

            System.out.println("player1="+player1+",player2="+player2+",status="+status);
            if(dfs(nums,state,(index+1)%nums.length,count+1,!status,player1,player2)
                    || dfs(nums,state,(index-1+nums.length)%nums.length,count+1,!status,player1,player2)){
                return true;
            }
            state[index]=0;
            return false;
        }

    }*/
}
