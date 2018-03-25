package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-3-20.
 */

/**
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:
 The input string length won't exceed 1000.
 */
public class Palindromic_Substrings_647 {

    public static void main(String args[]){
//        Solution solution=new Solution();
        System.out.println(new Solution().countSubstrings("abc"));
        System.out.println(new Solution().countSubstrings("aac"));
        System.out.println(new Solution().countSubstrings("aaa"));



    }

    //brute way to solve this problem
    private static class Solution1 {
        public int countSubstrings(String s) {
            if(null==s||0==s.length()){
                return 0;
            }
            int result=0;
            for(int i=0;i<s.length();i++){
                for(int j=i;j<s.length();j++){
                    if(justPalindromic(s,i,j)){
                        result++;
                    }
                }
            }
            return result;
        }

        private boolean justPalindromic(String s, int i, int j) {
            while(i<=j){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    private static class Solution {
        int result=0;

        public int countSubstrings(String s) {
            if(null==s||0==s.length()){
                return 0;
            }

            for(int i=0;i<s.length();i++){
                getPalindromic(s,i,i);//奇数情况
                getPalindromic(s,i,i+1);//偶数情况
            }
            return result;
        }

        public void getPalindromic(String s,int left,int right){
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                result++;
                left--;
                right++;
            }
        }
    }
}
