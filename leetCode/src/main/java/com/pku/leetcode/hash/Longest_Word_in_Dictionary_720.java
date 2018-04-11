package com.pku.leetcode.hash;

/**
 * Created by zhaolizhen on 18-4-9.
 */

import java.util.*;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

 If there is no answer, return the empty string.
 Example 1:
 Input:
 words = ["w","wo","wor","worl", "world"]
 Output: "world"
 Explanation:
 The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 Example 2:
 Input:
 words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 Output: "apple"
 Explanation:
 Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 Note:

 All the strings in the input will only contain lowercase letters.
 The length of words will be in the range [1, 1000].
 The length of words[i] will be in the range [1, 30].
 */
public class Longest_Word_in_Dictionary_720 {

    public static void main(String args[]){
//        String words[]={"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String words[]={"a", "a", "a", "a", "a", "a", "a"};

        Solution solution=new Solution();
        System.out.println(solution.longestWord(words));
    }

    private static class Solution {
        public String longestWord(String[] words) {
            if(null==words||0==words.length){
                return "";
            }

            Map<String,Integer> mem=new HashMap<String,Integer>();

            for(String word:words){
                mem.put(word,0);
            }

            String max="";
            for(String word:words){
                List<String>path=new ArrayList<>();
                String temp=word;
                while(temp.length()>0){
                    if(mem.containsKey(temp)){
                        if(mem.get(temp)==0) {
                            temp = word.substring(0, temp.length() - 1);
                            path.add(temp);
                        }else if(mem.get(temp)==1){
                            break;
                        }else{
                            path.add(temp);
                            break;
                        }
                    }else{
                        break;
                    }
                }
                if(temp.length()==0){
                    for(String filter:path){
                        mem.put(filter,2);
                    }
                    if(max.length()<word.length()||(max.length()==word.length()&&max.compareTo(word)>0)){
                        max=word;
                    }
                }else{
                    for(String filter:path){
                        mem.put(filter,1);
                    }
                }
            }

            return max;
        }
    }
}
