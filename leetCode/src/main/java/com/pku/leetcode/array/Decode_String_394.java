package com.pku.leetcode.array;


/**
 * Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

import java.util.Stack;

/**
 * Created by zhaolizhen on 17-12-1.
 */
public class Decode_String_394 {

    public static void main(String args[]){
        System.out.println(new Solution().decodeString("2[2[b]]"));
    }

    private static class Solution {
        public String decodeString(String s) {
            if(null==s||0==s.length()){
                return s;
            }
            String result="";
            int i=0;
            Stack<String> stack=new Stack<String>();
            while(i<s.length()){
                if(s.charAt(i)>='1'&&s.charAt(i)<='9'){
                    int j=i;
                    for(;j<s.length();){
                        if(s.charAt(j)>=1&&s.charAt(j)<='9'){
                            j++;
                        }else{
                            break;
                        }
                    }
                    String no=s.substring(i,j);
                    stack.push(no);
                    i=j;
                }else if(s.charAt(i)=='['){
                    stack.push("[");
                    i++;
                }else if((s.charAt(i)>='a'&&s.charAt(i)<='z')||s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                    int j=i;
                    for(;j<s.length();){
                        if((s.charAt(j)>='a'&&s.charAt(j)<='z')||s.charAt(j)>='A'&&s.charAt(j)<='Z'){
                            j++;
                        }else{
                            break;
                        }
                    }
                    String str=s.substring(i,j);
                    if(!stack.isEmpty()&&!stack.peek().equals("[")&&!stack.peek().equals("]")){
                        String preStr=stack.pop();
                        stack.push(preStr+str);
                    }else {
                        stack.push(str);
                    }
                    i=j;
                }else{
                    String str=stack.pop();
                    stack.pop();
                    int no=Integer.parseInt(stack.pop());
                    String preStr="";
                    if(!stack.isEmpty()&&!stack.peek().equals("[")&&!stack.peek().equals("]")) {
                        preStr = stack.pop();
                    }
                    StringBuilder sb=new StringBuilder(no*str.length()+1);
                    sb.append(preStr);
                    for(int j=0;j<no;j++){
                        sb.append(str);
                    }
                    stack.push(sb.toString());
                    i++;
                }
            }
            return stack.peek();
        }
    }
}
