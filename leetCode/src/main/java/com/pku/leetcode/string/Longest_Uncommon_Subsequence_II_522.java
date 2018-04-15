package com.pku.leetcode.string;

/**
 * Created by zhaolizhen on 18-4-13.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

 A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

 The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

 Example 1:
 Input: "aba", "cdc", "eae"
 Output: 3
 Note:

 All the given strings' lengths will not exceed 10.
 The length of the given list will be in the range of [2, 50].
 */
public class Longest_Uncommon_Subsequence_II_522 {

    public static void main(String args[]){
        Solution solution=new Solution();
        String str1[]=new String[]{"ab", "cdc", "eae"};
        String str2[]={"aaa","aaa","aaa"};
        String str3[]={"aabbcc", "aabbcc","cb"};
        String str4[]={"aabbcc", "aabbcc","c","e","aabbcd"};
        System.out.println(solution.findLUSlength(str1));
        System.out.println(solution.findLUSlength(str2));
        System.out.println(solution.findLUSlength(str3));
        System.out.println(solution.findLUSlength(str4));




    }

    private static class Solution {
        public int findLUSlength(String[] strs) {
            if(null==strs||strs.length==0){
                return -1;
            }

            Arrays.sort(strs, new Comparator<String>() {
                public int compare(String a, String b) {
                    return a.length() != b.length() ? a.length() - b.length() : a.compareTo(b);
                }
            });


            for(int i = strs.length - 1; i >= 0; i--) {
                if(i > 0 && !strs[i].equals(strs[i - 1]) || i == 0) {
                    int j = i+1;
                    for(; j < strs.length; j++)
                        if(isSubsequence(strs[i], strs[j]))
                            break;
                    if(j == strs.length)
                        return strs[i].length();
                }
            }

            return -1;
        }

        private boolean isSubsequence(String s,String t){
            if(s.equals(t)){
                return true;
            }
            int p=0;
            for(int i=0;i<t.length()&&p<s.length();i++){
                if(s.charAt(p)==t.charAt(i)){
                    p++;
                }
            }
            return p==s.length();
        }
    }
}
