package com.pku.leetcode.hash;

/**
 * Created by zhaolizhen on 18-4-8.
 */

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Longest_Palindrome_409 {

    public static void main(String args[]){
        String s="ABCDBCDA";
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome(s));
    }

    private static class Solution {
        public int longestPalindrome(String s) {
            if(null==s||0==s.length()){
                return 0;
            }


            int mem[]=new int[52];
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)>='a'&&s.charAt(i)<='z') {
                    mem[s.charAt(i) - 'a']++;
                }
                if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                    mem[s.charAt(i)-'A'+26]++;
                }
            }

            int sum=0;
            boolean flag=true;
            for(int unit:mem){
                if((unit&0x1)==1){
                    sum+=(unit-1);
                    flag=false;
                }else{
                    sum+=unit;
                }
            }
            return flag?sum:sum+1;
        }



    }
}
