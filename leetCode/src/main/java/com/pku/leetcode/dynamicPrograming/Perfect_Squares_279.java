package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-4-17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class Perfect_Squares_279 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.numSquares(17));
    }


    //Accepted
    private static class Solution {
        private int min=Integer.MAX_VALUE;
        public int numSquares(int n) {

            List<Integer> list=new ArrayList<Integer>();
            int i=1;
            for(;i*i<=n;i++){
                 list.add(i*i);
            }

            dfs(n,list,list.size()-1,0);

            return min;
        }

        private void dfs(int sum,List<Integer> list,int index,int step){
            if(sum==0){
                min=Math.min(min,step);
            }
            if(min<=step){
                return;
            }
            if(index<0||sum<0){
                return;
            }
            dfs(sum-list.get(index),list,index,step+1);
            dfs(sum,list,index-1,step);
        }
    }
}
