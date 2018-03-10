package com.pku.leetcode.bits;

/**
 * Created by zhaolizhen on 18-3-10.
 */

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 */
public class Hamming_Distance_461 {

    public static void main(String args[]){
//        int a=3;
//        int b=5;
//        System.out.println(a^b);
        Solution solution=new Solution();
        System.out.println(solution.hammingDistance(1,4));

    }

    private static class Solution {
        public int hammingDistance(int x, int y) {
            int z=x^y;
            int result=0;
            for(int i=0;i<32;i++){
                if((z&0x1)==1){
                    result++;
                }
                z=z>>1;
            }
            return result;
        }
    }
}
