package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 17-9-3.
 */

/**
 * Given a positive integer n, find the number of non-negative integers less than or equal to n,
 * whose binary representations do NOT contain consecutive ones.

 Example 1:
 Input: 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 Note: 1 <= n <= 109
 */
public class Nonnegative_Integers_without_Consecutive_Ones_600 {

    public static void main(String args[]){
//        Solution s=new Solution();
//        System.out.println(s.findIntegers(1000000000));
    }

//    //brute way to solve this problem
//
//    private static class Solution {
//        public int findIntegers(int num) {
//            int count=0;
//            for(int i=0;i<=num;i++){
//                if (isValid(i)){
//                    count++;
//                }
//            }
//            return count;
//        }
//
//        /**
//         * 判断一个数有没有连续的1
//         * @param no
//         * @return
//         */
//        public boolean isValid(int no){
//            int pre=no&0x1;
//            int now=0;
//            while(no>0){
//                no>>=1;
//                now=no&0x1;
//                if(1==now&&now==pre){
//                    return false;
//                }else{
//                    pre=now;
//                }
//            }
//            return true;
//        }
//    }


    private static class Solution {
        public int findIntegers(int num) {
            return 0;
        }
    }
}
