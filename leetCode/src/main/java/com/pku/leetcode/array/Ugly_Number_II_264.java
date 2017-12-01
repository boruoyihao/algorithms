package com.pku.leetcode.array;


/**
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
/**
 * Created by zhaolizhen on 17-11-29.
 */
public class Ugly_Number_II_264 {

    public static void main(String args[]){
        Solution s= new Solution();
        System.out.println(s.nthUglyNumber(10));
    }

    private static class Solution {
        public int nthUglyNumber(int n) {
            int buffer[]=new int[n];
            buffer[0]=1;
            int i=0;
            int ugly2=0,ugly3=0,ugly5=0;
            while(i<n-1){
                while(2*buffer[ugly2]<=buffer[i]){
                    ugly2++;
                }
                while(3*buffer[ugly3]<=buffer[i]){
                    ugly3++;
                }
                while(5*buffer[ugly5]<=buffer[i]){
                    ugly5++;
                }
                buffer[++i]=getMin3(2*buffer[ugly2],3*buffer[ugly3],5*buffer[ugly5]);
            }
            return buffer[n-1];
        }

        private int getMin3(int data1,int data2,int data3){
            int middle1=Math.min(data1,data2);
            int midele2=Math.min(data2,data3);
            return middle1>midele2?midele2:middle1;
        }
    }



}
