package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-11.
 */

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.
 */
public class Shortest_Unsorted_Continuous_Subarray_581 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int nums[]={2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution.findUnsortedSubarray(nums));


        int nums1[] = {0, 2, 6, 4, 1, 100, 8, 10, 9, 15, 400, 600};
        System.out.println(solution.findUnsortedSubarray(nums1));


        int nums2[] = {10,9,8,7};
        System.out.println(solution.findUnsortedSubarray(nums2));


        int nums3[] = {1,2,3,4};
        System.out.println(solution.findUnsortedSubarray(nums3));
    }

    private static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            if(null==nums||nums.length<=1){
                return 0;
            }
            int start=0;
            for(;start<nums.length-1;start++){
                if(nums[start]>nums[start+1]){
                    break;
                }
            }
            if(start==nums.length-1){
                return 0;
            }

            int end=nums.length-1;
            for(;end>0;end--){
                if(nums[end]<nums[end-1]){
                    break;
                }
            }

            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i=start;i<=end;i++){
                min=Math.min(min,nums[i]);
                max=Math.max(max,nums[i]);
            }

            int startIndex=start;
            for(int i=0;i<start;i++){
                if(nums[i]>min){
                    startIndex=i;
                    break;
                }
            }

            int endIndex=end;
            for(int i=nums.length-1;i>end;i--){
                if(nums[i]<max){
                    endIndex=i;
                    break;
                }
            }

//            System.out.println("min="+min+"max="+max+"startIndex="+startIndex+",endIndex="+endIndex);
            return endIndex-startIndex+1;

        }
    }
}
