package com.pku.leetcode.array;
/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 */

import java.util.Arrays;

/**
 * Created by zhaolizhen on 17-12-1.
 */
public class Move_Zeroes_283 {

    public static void main(String args[]){
        Solution s=new Solution();
        int nums[]={0,1,0,0,3};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static class Solution1 {
        public void moveZeroes(int[] nums) {
            if(null==nums||nums.length==0){
                return;
            }
            int i=0,j=0;//i指针在前，j指针在后
            while(j<nums.length){
                if(nums[j]!=0){
                    nums[i++]=nums[j];
                }
                j++;
            }

            while(i<nums.length){
                nums[i++]=0;
            }
        }
    }

    private static class Solution{
        public void moveZeroes(int[] nums) {

            int j = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                }
            }
        }
    }
}
