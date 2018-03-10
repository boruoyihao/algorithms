package com.pku.leetcode.bits;

/**
 * Created by zhaolizhen on 18-3-10.
 */

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Now your job is to find the total Hamming distance between all pairs of the given numbers.

 Example:
 Input: 4, 14, 2

 Output: 6

 Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 showing the four bits relevant in this case). So the answer will be:
 HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 Note:
 Elements of the given array are in the range of 0 to 10^9
 Length of the array will not exceed 10^4.
 */
public class Total_Hamming_Distance_477 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int nums[]={4,14,2};
        System.out.println(solution.totalHammingDistance(nums));
    }

    //brute way TLE
    private static class Solution1 {
        public int totalHammingDistance(int[] nums) {
            int result=0;
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    result+=hammingDistanceBetween2data(nums[i],nums[j]);
                }
            }
            return result;
        }

        public int hammingDistanceBetween2data(int x,int y){
            int z=x^y;
            int result=0;
            while(z>0){
                result++;
                z=z&(z-1);
            }
            return result;
        }
    }


    private static class Solution {
        public int totalHammingDistance(int[] nums) {
            int result=0;
            if(null==nums||0==nums.length){
                return result;
            }
            int bisCount[]=new int[32];
            for(int no:nums){
                for(int i=0;i<32;i++){
                    if((no&0x1)==1) {
                        bisCount[i] += 1;
                    }
                    no=no>>1;
                }
            }

            int length=nums.length;
            for(int i=0;i<32;i++){
                result+=bisCount[i]*(length-bisCount[i]);
            }
            return result;
        }

        //simple way to solve this problem from leetcode
        //https://leetcode.com/problems/total-hamming-distance/discuss/96226/Java-O(n)-time-O(1)-Space
        public int totalHammingDistance2(int[] nums) {
            int total = 0, n = nums.length;
            for (int j=0;j<32;j++) {
                int bitCount = 0;
                for (int i=0;i<n;i++)
                    bitCount += (nums[i] >> j) & 1;
                total += bitCount*(n - bitCount);
            }
            return total;
        }
    }

}
