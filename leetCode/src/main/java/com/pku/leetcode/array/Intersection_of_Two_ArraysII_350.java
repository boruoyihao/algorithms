package com.pku.leetcode.array;
/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaolizhen on 17-11-27.
 */
public class Intersection_of_Two_ArraysII_350 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int nums1[]={1,2,4,5,2,1};
        int nums2[]={1,1,2,3,2,3,5,5};
        int result[]=solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    private static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i=0,j=0;
            List<Integer> result=new ArrayList<Integer>();
            while(i<nums1.length&&j<nums2.length){
                if(nums1[i]<nums2[j]){
                    i++;
                }else if(nums1[i]>nums2[j]){
                    j++;
                }else{
                    result.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            int resultArray[]=new int[result.size()];
            i=0;
            for(int no:result){
                resultArray[i++]=no;
            }
            return resultArray;
        }
    }

}
