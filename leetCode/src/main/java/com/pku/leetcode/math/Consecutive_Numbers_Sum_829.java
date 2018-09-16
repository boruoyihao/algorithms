package com.pku.leetcode.math;

/**
 * Created by zhaolizhen on 18-9-16.
 */
public class Consecutive_Numbers_Sum_829 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.consecutiveNumbersSum1(246854111));
    }

    private static class Solution {

        //TLE
        public int consecutiveNumbersSum1(int N) {
            if(N<=0){
                return 0;
            }
            if(N==1){
                return 1;
            }
            long length=((N+1)>>1);
            int result=1;

            int i=1,j=2;
            int sum=i;
            while(i<j&&j<=(length+1)){
                if(sum==N){
//                    System.out.println("i="+i+",j="+j);
                    result++;
                    sum+=(j++);
                    sum-=(i++);
                }else if(sum>N){
                    sum-=(i++);
                }else{
                    sum+=(j++);
                }
//                System.out.println("i="+i+",j="+j+",sum="+sum);

            }
            return result;
        }

        public int consecutiveNumbersSum(int N) {
            return 0;
        }
    }
}
