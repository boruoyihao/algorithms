package com.pku.leetcode.hash;

/**
 * Created by zhaolizhen on 18-4-5.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Longest_Substring_Without_Repeating_Characters_3 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abcad"));
        System.out.println(solution.lengthOfLongestSubstring("abafcade"));




    }

    //sliding window
    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(null==s||0==s.length()){
                return 0;
            }

            int i=0,j=0;
            Map<Character,Integer> mem=new HashMap<Character,Integer>();
            int max=0;
            while(i<=j&&j<s.length()){
                if(mem.get(s.charAt(j))==null||mem.get(s.charAt(j))<=0){
                    mem.put(s.charAt(j),1);
                    j++;
                    max=Math.max(max,j-i);
                }else{
                    mem.put(s.charAt(i),mem.get(s.charAt(i))-1);
                    i++;
                }
            }
            return max;
        }
    }

    //Sliding Window Opimized
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
    //use map value to memorize the character's index
    public class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<Character,Integer>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }


}
