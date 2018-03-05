package com.pku.leetcode.array;


/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaolizhen on 17-11-27.
 */
public class Intersection_of_Two_Arrays_349 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int nums1[]={1};
        int nums2[]={2,3};
        int []result=solution.intersection(nums1,nums2);
        System.out.println(Arrays.toString(result));
    }

    private static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if(null==nums1||null==nums2){
                return null;
            }
            Set<Integer> set=new HashSet<Integer>(nums1.length);
            for(int no:nums1){
                set.add(no);
            }

            Set<Integer>result=new HashSet<Integer>(nums1.length);

            for(int no:nums2){
                if(set.contains(no)){
                    result.add(no);
                }
            }

            int []resultArray=new int[result.size()];
            int i=0;
            for(Integer no:result){
                resultArray[i++]=no;
            }
            return resultArray;

        }
    }
}
