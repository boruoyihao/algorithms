package com.pku.leetcode.dynamicPrograming;
/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

 For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

 Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

 Note:
 The given numbers of 0s and 1s will both not exceed 100
 The size of given string array won't exceed 600.
 Example 1:
 Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 Output: 4

 Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 Example 2:
 Input: Array = {"10", "0", "1"}, m = 1, n = 1
 Output: 2

 Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaolizhen on 17-9-2.
 */
public class Ones_and_Zeroes_474 {
    public static void main(String args[]){
        Solution s=new Solution();
        String str[]={"10", "0001", "111001", "1", "0"};
        System.out.println(s.findMaxForm(str,5,3));

//        String str1[]={"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0",
//                "0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"};
//        System.out.println(s.findMaxForm(str1,9,80));
    }

    private static class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int ones;
            int zeros;
            int mem[][]=new int[m+1][n+1];
            for(String s:strs){
                ones=0;
                zeros=0;
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='1'){
                        ones++;
                    }else{
                        zeros++;
                    }
                }

                for(int i=m;i>=zeros;i--){
                    for(int j=n;j>=ones;j--){
                        mem[i][j]=Math.max(mem[i][j],mem[i-zeros][j-ones]+1);
                    }
                }
//                printArray(mem);

            }
            return mem[m][n];
        }

        void printArray(int [][]mem){
            for(int i=0;i<mem.length;i++){
                for(int j=0;j<mem[i].length;j++){
                    System.out.print(mem[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    //TLE
    /*
    private static class Solution {
        private int mem1[]=null;
        private int mem0[]=null;
        private int m;
        private int n;
        private Map<String,Boolean> mem=null;
        private int status[]=null;
        int max=0;
        public int findMaxForm(String[] strs, int m, int n) {
            Arrays.sort(strs);
            mem1=new int[strs.length];
            mem0=new int[strs.length];
            this.m=m;
            this.n=n;
            for(int i=0;i<strs.length;i++){
                int no1=0;
                int no0=0;
                for(int j=0;j<strs[i].length();j++){
                    if(strs[i].charAt(j)=='1'){
                        no1++;
                    }else{
                        no0++;
                    }
                }
                mem1[i]=no1;
                mem0[i]=no0;
            }

            status=new int[strs.length];
            mem=new HashMap<String,Boolean>();

            dfs(0,0,0,0);
            return max;
        }

        void dfs(int index,int one,int zero,int current){
            if(index>status.length){
                return;
            }

            String str=toString(status,index);

            if(mem.get(str)!=null&&mem.get(str)==false){
                return;
            }

            if(one>n||zero>m){
                mem.put(str,false);
                return;
            }

            if(index==status.length&&one<=n&&zero<=m){
                if(current<=max){
                    mem.put(str,false);
                }else{
                    max=current;
                }
                return;
            }

            dfs(index+1,one,zero,current);

            status[index]=1;
            dfs(index+1,one+mem1[index],zero+mem0[index],current+1);
            status[index]=0;
        }

        private String toString(int status[],int index){
            StringBuffer sb=new StringBuffer(status.length+1);
            for(int i=0;i<index;i++){
                sb.append(status[i]);
            }
            return sb.toString();
        }

    }*/
}
