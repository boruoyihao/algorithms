package com.pku.leetcode.dynamicPrograming;


/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */

import java.util.Arrays;

/**
 * Created by zhaolizhen on 18-6-28.
 */
public class Range_Sum_Query_Immutable_303 {

    public static void main(String args[]){
//        int array[]={-2, 0, 3, -5, 2, -1};
//        NumArray numArray=new NumArray(array);
//        System.out.println(numArray.sumRange(0,2));
//        System.out.println(numArray.sumRange(2,5));
//
//        System.out.println(numArray.sumRange(0,5));

        int array1[]={-4,-5};
        NumArray numArray=new NumArray(array1);
        System.out.println(numArray.sumRange(0,0));
        System.out.println(numArray.sumRange(1,1));
        System.out.println(numArray.sumRange(0,1));
        System.out.println(numArray.sumRange(1,1));


    }

    //Memory Limit Exceeded
    private static class NumArray1 {

        int mem[][]=null;

        public NumArray1(int[] nums) {
            mem=new int[nums.length][nums.length];
            for(int i=0;i<nums.length;i++){
                mem[i][i]=nums[i];
                for(int j=i+1;j<nums.length;j++){
                    mem[i][j]=mem[i][j-1]+nums[j];
                }
            }
        }

        public int sumRange(int i, int j) {
            if(i>j){
                throw new IllegalArgumentException("");
            }
            return mem[i][j];
        }
    }


    //Time Limit Exceeded
    private static class NumArray2 {

        int mem[]=null;

        public NumArray2(int[] nums) {
            mem=nums;
        }

        public int sumRange(int i, int j) {
            int sum=0;
            for(int k=i;k<=j;k++){
                sum+=mem[k];
            }
            return sum;
        }
    }

    //Accepted
    private static class NumArray3 {

        int left[]=null;
        int right[]=null;
        int sum=0;

        public NumArray3(int[] nums) {
            left=new int[nums.length+1];
            right=new int[nums.length+1];
            for(int i=0;i<nums.length;i++){
                left[i+1]=left[i]+nums[i];
                sum+=nums[i];
            }

            for(int i=nums.length-1;i>=0;i--){
                right[i]=right[i+1]+nums[i];
            }

            System.out.println(Arrays.toString(right));
        }

        public int sumRange(int i, int j) {
            if(i>j){
                throw new IllegalArgumentException("参数错误");
            }
            return sum-left[i]-right[j+1];
        }
    }

    //https://leetcode.com/problems/range-sum-query-immutable/discuss/75192/Java-simple-O(n)-init-and-O(1)-query-solution
    //clever solution from the leetcode comment
    private static class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            for(int i = 1; i < nums.length; i++)
                nums[i] += nums[i - 1];

            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if(i == 0)
                return nums[j];

            return nums[j] - nums[i - 1];
        }
    }


}
