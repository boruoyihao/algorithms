package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 17-8-13.
 */

import java.util.Arrays;
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
        public boolean PredictTheWinner(int[] nums) {
            return dfs(nums,0,nums.length-1,0,0,1);
        }

        public boolean dfs(int [] nums,int start,int end,int sum1,int sum2,int status){
            if(end==start){
                if(status==1){
                    return sum1+nums[start]>=sum2;
                }else{
                    return sum2+nums[start]>sum1;
                }
            }
            if(status==1){
                return !dfs(nums,start+1,end,sum1+nums[start],sum2,2)||!dfs(nums,start,end-1,sum1+nums[end],sum2,2);
            }else{
                return !dfs(nums,start+1,end,sum1,sum2+nums[start],1)||!dfs(nums,start,end-1,sum1,sum2+nums[end],1);
            }
        }
    }
    /**
    private static class Solution {
        public boolean PredictTheWinner(int[] nums) {
            if(null==nums||0==nums.length){
                return false;
            }
            if(nums.length==1){
                return true;
            }
            Integer mem[][]=new Integer[nums.length][nums.length];
            return PredictTheWinner(nums,0,nums.length-1,mem)>=0;
        }

        public int PredictTheWinner(int[] nums,int i,int j,Integer[][]mem){
            if(mem[i][j]!=null){
                return mem[i][j];
            }
            if(i==j){
                return nums[i];
            }
            int left=nums[i]-PredictTheWinner(nums,i+1,j,mem);
            int right=nums[j]-PredictTheWinner(nums,i,j-1,mem);
            System.out.println("nums[i]="+nums[i]+",nums[j]="+nums[j]+",left="+left+",right="+right);
            mem[i][j]=Math.max(left,right);
            return mem[i][j];
        }

    }
     */

}
