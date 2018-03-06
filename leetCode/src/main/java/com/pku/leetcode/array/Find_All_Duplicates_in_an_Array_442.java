package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-6.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 */
public class Find_All_Duplicates_in_an_Array_442 {

    public static void main(String args[]){
        Solution s=new Solution();
        int nums[]={4,3,2,7,8,2,3,1};
        System.out.println(s.findDuplicates(nums));

        int nums1[]={3,3,3};
        System.out.println(s.findDuplicates(nums1));

    }


    private static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer>result=new ArrayList<Integer>();
            if(null==nums||nums.length<=1){
                return result;
            }

            for(int i=0;i<nums.length;i++){
                int index=nums[i];
                if(nums[Math.abs(index)-1]>0){
                    nums[Math.abs(index)-1]=-nums[Math.abs(index)-1];
                }else{
                    result.add(Math.abs(index));
                }
            }
            return result;
        }
    }
}
