package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-10.
 */

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False
 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 */
public class Permutation_in_String_567 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.checkInclusion("ab","eidbaooo"));
        System.out.println(solution.checkInclusion("ab","eidboaoo"));
    }

    //use slide window to solve this problem
    private static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if(null==s1||null==s2||s1.length()>s2.length()){
                return false;
            }

            int letters[]=new int[26];

            for(char c:s1.toCharArray()){
                letters[c-'a']++;
            }


            int start=0,end=0,diff=s1.length();
            for(;end<s1.length();end++){
                char temp=s2.charAt(end);
                letters[temp-'a']--;
                if(letters[temp-'a']>=0){
                    diff--;
                }
            }
            if(diff==0){
                return true;
            }

            for(;end<s2.length();){
                char temp=s2.charAt(start);
                if(letters[temp-'a']>=0){
                    diff++;
                }
                letters[temp-'a']++;
                start++;

                temp=s2.charAt(end);
                letters[temp-'a']--;
                if(letters[temp-'a']>=0){
                    diff--;
                }
                end++;

                if(0==diff){
                    return true;
                }
            }
            return false;
        }
    }
}
