package com.pku.leetcode.array;


/**
 * Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all test cases.
 */

/**
 * Created by zhaolizhen on 17-11-29.
 */
public class Super_Ugly_Number_313 {

    public static void main(String args[]){
        Solution s=new Solution();
        int primes[]={2, 7, 13, 19};
        System.out.println(s.nthSuperUglyNumber(5, primes));
    }

    private static class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int buffer[]=new int[n];
            int primesIndexArray[]=new int[primes.length];
            buffer[0]=1;
            int i=0;
            while(i<n-1){
                for(int j=0;j<primesIndexArray.length;j++){
                    while(primes[j]*buffer[primesIndexArray[j]]<=buffer[i]){
                        primesIndexArray[j]++;
                    }
                }
                buffer[++i]=getMinByIndex(primesIndexArray,buffer,primes);

            }

            return buffer[n-1];
        }

        /**
         *  得到所有指针指向的最小值
         * @param primesIndexArray 记录primes因子的下标
         * @param buffer
         * @param primes
         * @return
         */
        private int getMinByIndex(int[]primesIndexArray,int[]buffer,int []primes){
            int min=Integer.MAX_VALUE;
            for(int i=0;i<primesIndexArray.length;i++){
                if(primes[i]*buffer[primesIndexArray[i]]<min){
                    min=buffer[primesIndexArray[i]]*primes[i];
                }
            }
            return min;
        }

    }
}
