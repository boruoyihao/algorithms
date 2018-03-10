package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-10.
 */

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Valid_Anagram_242 {



    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.isAnagram("anagram","nagarad"));
    }


    private static class Solution {
        public boolean isAnagram(String s, String t) {
            if(null==s||null==t||s.length()!=t.length()){
                return false;
            }

            int letters[]=new int[26];
            for(char c:s.toCharArray()){
                letters[c-'a']++;
            }

            for(char c:t.toCharArray()){
                letters[c-'a']--;
            }

            for(int count:letters){
                if(count>0){
                    return false;
                }
            }
            return true;
        }
    }
}
