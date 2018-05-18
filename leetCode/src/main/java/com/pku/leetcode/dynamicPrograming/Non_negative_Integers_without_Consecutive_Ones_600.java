package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-5-15.
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
 */
public class Non_negative_Integers_without_Consecutive_Ones_600 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.findIntegers(5));

    }


    private static class Solution {
        public int findIntegers(int num) {
            return 0;
        }
    }
}
