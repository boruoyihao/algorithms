package com.pku.leetcode.dynamicPrograming;


/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Example 1:

 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.
 Example 2:

 Input: [2,7,9,3,1]
 Output: 12
 Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 Total amount you can rob = 2 + 9 + 1 = 12.
 */
/**
 * Created by zhaolizhen on 18-5-19.
 */
public class House_Robber_198 {
    public static void main(String args[]){
        Solution solution=new Solution();
        int []nums={1,2,3,1};
        System.out.println(solution.rob(nums));

        int []nums1={2,7,9,3,1};
        System.out.println(solution.rob(nums1));

        int []nums2={2,7};
        System.out.println(solution.rob(nums2));
    }

    private static class Solution1 {
        public int rob(int[] nums) {
            if(null==nums||0==nums.length){
                return 0;
            }

            if(1==nums.length){
                return nums[0];
            }else if(2==nums.length){
                return nums[0]>nums[1]?nums[0]:nums[1];
            }

            int mem[]=new int[nums.length];
            mem[0]=nums[0];
            mem[1]=nums[1];
            mem[2]=mem[0]+nums[2];
            for(int i=3;i<nums.length;i++){
                mem[i]=(mem[i-2]>mem[i-3]?mem[i-2]:mem[i-3])+nums[i];
            }

//            System.out.println(Arrays.toString(mem));
            return mem[mem.length-1]>mem[mem.length-2]?mem[mem.length-1]:mem[mem.length-2];
        }
    }


    //https://leetcode.com/problems/house-robber/discuss/124253/Simple-JAVA-Solution-beat-100
    private static class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int sum[] = new int[n];
            if(nums.length==0) return 0;
            if(nums.length==1) return nums[0];
            if(nums.length==2) return Math.max(nums[0],nums[1]);
            sum[0] = nums[0];
            sum[1] =  Math.max(nums[0],nums[1]);
            for(int i=2;i<nums.length;i++){
                sum[i] = Math.max(sum[i-1],sum[i-2]+nums[i]);
            }
            return sum[n-1];
        }
    }
}
