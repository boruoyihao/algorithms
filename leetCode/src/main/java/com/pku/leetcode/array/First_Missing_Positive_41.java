package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-6.
 */

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class First_Missing_Positive_41 {

    public static void main(String args[]) {
        Solution s = new Solution();
        int nums[] = {1, 2, 0};
        System.out.println(s.firstMissingPositive(nums));

        int nums1[] = {3, 4, -1, 1};
        System.out.println(s.firstMissingPositive(nums1));

        int nums2[] = {3, 4, 2, 1};
        System.out.println(s.firstMissingPositive(nums2));

        int nums3[] = {3};
        System.out.println(s.firstMissingPositive(nums3));

    }

    private static class Solution {
        public int firstMissingPositive(int[] nums) {
            if (null == nums || 0 == nums.length) {
                return 1;
            }

            for (int i = 0; i < nums.length; i++) {
                int next = nums[i];
                while (next > 0 && next <= nums.length && nums[next - 1] != next) {
                    int temp = nums[next - 1];
                    nums[next - 1] = next;
                    next = temp;
                }
            }

            int result = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0 && nums[i] == result) {
                    result++;
                }
            }


            return result;
        }
    }
}
