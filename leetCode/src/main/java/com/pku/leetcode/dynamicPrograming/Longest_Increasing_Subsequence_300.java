package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-4-5.
 */

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?

 Credits:
 Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class Longest_Increasing_Subsequence_300 {

    public static void main(String args[]){
        Solution solution=new Solution();
//        int nums[]={10,9,2,5,3,4};
        int nums[]={2};
        System.out.println(solution.lengthOfLIS(nums));
    }

    //dp solution
    //https://leetcode.com/problems/longest-increasing-subsequence/solution/
    private static class Solution {
        public int lengthOfLIS(int[] nums) {
            if(null==nums||0==nums.length){
                return 0;
            }

            int result=1;
            int []dp=new int[nums.length];
            dp[0]=1;
            for(int i=1;i<nums.length;i++){
                int max=0;
                for(int j=0;j<i;j++){
                    if(nums[j]<nums[i]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i]=max+1;
                result=Math.max(result,dp[i]);
            }

            return result;
        }
    }

     //dp Solution
    //https://leetcode.com/problems/longest-increasing-subsequence/solution/
    private static  class Solution2 {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int i = Arrays.binarySearch(dp, 0, len, num);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = num;
                if (i == len) {
                    len++;
                }
            }
            return len;
        }
    }
}
