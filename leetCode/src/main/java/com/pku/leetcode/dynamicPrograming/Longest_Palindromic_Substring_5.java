package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-4-4.
 */

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.


 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class Longest_Palindromic_Substring_5 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome("abc"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("abac"));
        System.out.println(solution.longestPalindrome("caba"));
        System.out.println(solution.longestPalindrome("abba"));
        System.out.println(solution.longestPalindrome("dabba"));
        System.out.println(solution.longestPalindrome("abbad"));
        System.out.println(solution.longestPalindrome("cbbd"));


    }



    //O(N*N) solution
    private static class Solution1 {

        public String longestPalindrome(String s) {
            if(null==s||s.length()==0){
                return "";
            }

            int start=0;
            int max=0;
            for(int i=0;i<s.length();i++){
                int value=getlongestRadius(s,i,i);
                if(max<value*2-1){
                    max=value*2-1;
                    start=i+1-value;
                }

                value=getlongestRadius(s,i,i+1);
                if(max<value*2){
                    max=value*2;
                    start=i+1-value;
                }
            }
            return s.substring(start,start+max);
        }

        public int getlongestRadius(String s,int left,int right){
            int j=0;
            while(right+j<s.length()&&left-j>=0&&s.charAt(right+j)==s.charAt(left-j)){
                j++;
            }
            return j;
        }
    }

    //Manacher's algorithm
    private static class Solution {

        public String longestPalindrome(String s) {
            if(null==s||s.length()==0){
                return "";
            }

            char buffer[]=new char[s.length()*2+2];
            int j=0;
            buffer[j++]='$';
            buffer[j++]='#';
            for(int i=0;i<s.length();i++){
                buffer[j++]=s.charAt(i);
                buffer[j++]='#';
            }

            int mem[]=new int[s.length()*2+2];

            int right=0;
            int center=0;

            int max=0;
            int start=0;
            for(int i=1;i<buffer.length;i++){
                if(i<right){
                    right=Math.min(mem[2*center-i],right-i);
                }else{
                    mem[i]=1;
                }

                while(i+mem[i]<buffer.length&&i-mem[i]>=0&&buffer[i+mem[i]]==buffer[i-mem[i]]){
                    mem[i]++;
                }

                if(i+mem[i]<right){
                    right=i+mem[i];
                    center=i;
                }

                if(max<mem[i]*2-1){
                    start=i+1-mem[i];
                    max=mem[i]*2-1;
                }
            }

            char resultBuffer[]=new char[max/2];
            j=0;
            for(int i=start;i<start+max;i++){
                if(buffer[i]!='#') {
                    resultBuffer[j++] = buffer[i];
                }
            }
            return new String(resultBuffer);

        }

    }
}
