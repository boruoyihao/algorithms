package com.pku.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaolizhen on 18-3-6.
 */

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */
public class Find_All_Numbers_Disappeared_in_an_Array_448 {

    public static void main(String args[]){
        Solution s=new Solution();
        int nums[]={4,3,2,7,8,2,3,1};
        System.out.println(s.findDisappearedNumbers(nums));

        int nums1[]={3,1,2};
        System.out.println(s.findDisappearedNumbers(nums1));
    }


    private static class Solution {

        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer>result=new ArrayList<Integer>();
            if(null==nums||nums.length<=1){
                return result;
            }

            for(int i=0;i<nums.length;i++){
                int index=nums[i];
                if(nums[Math.abs(index)-1]>0){
                    nums[Math.abs(index)-1]=-nums[Math.abs(index)-1];
                }
            }

            System.out.println(Arrays.toString(nums));
            for(int i=0;i<nums.length;i++){
                if(nums[i]>0){
                    result.add(i+1);
                }
            }
            return result;
        }
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer>result=new ArrayList<Integer>();
            if(null==nums||0==nums.length){
                return result;
            }

            for(int i=0;i<nums.length;i++){
                int next=nums[i];
                while(nums[next-1]!=next){
                    int temp=nums[next-1];
                    nums[next-1]=next;
                    next=temp;
                }
            }
//            System.out.println(Arrays.toString(nums));

            for(int i=0;i<nums.length;i++){
                if(i+1!=nums[i]){
                    result.add(i+1);
                }
            }
            return result;
        }
    }
}
