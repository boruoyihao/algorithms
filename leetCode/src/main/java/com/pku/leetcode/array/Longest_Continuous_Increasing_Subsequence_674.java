package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-4-8.
 */

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

 Example 1:
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 Example 2:
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 Note: Length of the array will not exceed 10,000.
 */
public class Longest_Continuous_Increasing_Subsequence_674 {

    public static void main(String args[]){
//        int nums[]={1,3,5,4,7,9,10,8};
        int nums[]={2,2,2,2,2};
        Solution solution=new Solution();
        System.out.println(solution.findLengthOfLCIS(nums));
    }

    private static class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(null==nums||0==nums.length){
                return 0;
            }

            int ans=1;
            int previous=0;
            for(int i=1;i<nums.length;i++){
                if(nums[i]>nums[i-1]){
                    ans=Math.max(ans,i-previous+1);
                }else{
                    previous=i;
                }
            }
            return ans;
        }
    }
}
