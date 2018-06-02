package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-5-19.
 */

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 Example 1:

 Input: [2,3,2]
 Output: 3
 Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 because they are adjacent houses.
 Example 2:

 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.
 */
public class House_Robber_II_213 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int nums[]={2,3,2,2};
        System.out.println(solution.rob(nums));
        int nums1[]={1,1,1,4};
        System.out.println(solution.rob(nums1));
        int nums2[]={2,7,9,3,1};
        System.out.println(solution.rob(nums2));
    }

    private static class Solution {
        public int rob(int[] nums) {
            if(null==nums||0==nums.length){
                return 0;
            }
            if(1==nums.length){
                return nums[0];
            }

            int mem1[]=new int[nums.length+1];
            mem1[0]=0;
            mem1[1]=nums[0];

            int mem2[]=new int[nums.length+1];
            mem2[0]=nums[nums.length-1];
            mem2[1]=nums[nums.length-1];
            for(int i=2;i<nums.length;i++){
                mem1[i]=Math.max(mem1[i-1],mem1[i-2]+nums[i-1]);
                mem2[i]=Math.max(mem2[i-1],mem2[i-2]+nums[i-1]);
            }

//            System.out.println(Arrays.toString(mem1));
//            System.out.println(Arrays.toString(mem2));

            return Math.max(mem1[nums.length-1],mem2[nums.length-2]);


        }
    }
}
