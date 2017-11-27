package com.pku.leetcode.array;
/**
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".


 */
/**
 * Created by zhaolizhen on 17-11-27.
 */
public class Reverse_String_344 {
    public static void main(String args[]) {
        Solution s=new Solution();
        System.out.println(s.reverseString("dda"));
    }

    private static class Solution {
        public String reverseString(String s) {
            if(null==s||"".equals(s)){
                return s;
            }
            char []chars=new char[s.length()];
            int j=s.length()-1;
            for(int i=0;i<=s.length()-1;i++){
                chars[j--]=s.charAt(i);
            }
            return new String(chars);
        }
    }
}
