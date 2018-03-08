package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-7.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Find_All_Anagrams_in_a_String_438 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.findAnagrams("abab","ab"));
        System.out.println(solution.findAnagrams("cbaebabacd","abc"));
        System.out.println(solution.findAnagrams("abaa","aab"));


    }

    private static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result=new ArrayList<Integer>();
            if(p.length()>s.length()){
                return result;
            }
            int letters[]=new int[26];
            for(int i=0;i<p.length();i++){
                letters[p.charAt(i)-'a']++;
            }

            for(int i=0;i<s.length();i++){
                int j=0;
                int copy[]= Arrays.copyOf(letters,letters.length);
                for(;j<p.length()&&(i+j)<s.length();j++){
                    if(copy[s.charAt(i+j)-'a']>0){
                        copy[s.charAt(i+j)-'a']--;
                    }else{
                        break;
                    }
                }
                if(j==p.length()){
                    result.add(i);
                }
            }
            return result;
        }
    }
}
