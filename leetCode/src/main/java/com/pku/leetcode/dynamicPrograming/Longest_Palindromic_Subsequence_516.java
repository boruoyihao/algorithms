package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-4-4.
 */

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".

 */
public class Longest_Palindromic_Subsequence_516 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.longestPalindromeSubseq("abc"));
        System.out.println(solution.longestPalindromeSubseq("a"));
        System.out.println(solution.longestPalindromeSubseq("abac"));
        System.out.println(solution.longestPalindromeSubseq("caba"));
        System.out.println(solution.longestPalindromeSubseq("abba"));
        System.out.println(solution.longestPalindromeSubseq("dabba"));
        System.out.println(solution.longestPalindromeSubseq("abbad"));
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
    }

    private static class Solution {
        public int longestPalindromeSubseq(String s) {
            if(null==s||s.length()==0){
                return 0;
            }

            int max=0;
            for(int i=0;i<s.length();i++){
                int value=getlongestRadius(s,i,i);
                if(max<value*2-1){
                    max=value*2-1;
                }

                value=getlongestRadius(s,i,i+1);
                if(max<value*2){
                    max=value*2;
                }
            }
            return max;
        }

        public int getlongestRadius(String s,int left,int right){
            int j=0;
            while(right+j<s.length()&&left-j>=0&&s.charAt(right+j)==s.charAt(left-j)){
                j++;
            }
            return j;
        }
    }
}
