package com.pku.leetcode.dynamicPrograming;


/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
/**
 * Created by zhaolizhen on 18-6-28.
 */
public class Integer_Break_343 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.integerBreak(2));
        System.out.println(solution.integerBreak(10));
        System.out.println(solution.integerBreak(58));
        System.out.println(solution.integerBreak(12));

    }

    //Accepted
    private static class Solution1 {
        public int integerBreak(int n) {

            int max=0;
            for(int i=2;i<=((n>>1)+1);i++){
                int consult=n/i;
                int remainder=n%i;
                if(remainder==0){
                    max=Math.max(max,pow(consult,i));
                }else{
                    int tempResult=pow(consult,i-remainder)*pow(consult+1,remainder);
                    max=Math.max(tempResult,max);
                }
            }
            return max;
        }

        private int pow(int no,int n){
            int sum=1;
            for(int i=0;i<n;i++){
                sum*=no;
            }
            return sum;
        }
    }

    //https://leetcode.com/problems/integer-break/discuss/134051/Java-beat-100
    private static class Solution2 {
        public int integerBreak(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            int mul = 0;
            return helper(n);
        }
        private int helper(int n){
            if (n == 2) return 2;
            if (n == 3) return 3;
            if (n == 4) return 4;
            return helper(n - 3) * 3;
        }
    }

    //https://leetcode.com/problems/integer-break/discuss/80785/O(log(n))-Time-solution-with-explanation
    //O(nlogn)
    private static class Solution {
        public int integerBreak(int n) {
            if(n == 2)
                return 1;
            else if(n == 3)
                return 2;
            else if(n%3 == 0)
                return (int)Math.pow(3, n/3);
            else if(n%3 == 1)
                return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
            else
                return 2 * (int) Math.pow(3, n/3);
        }

    }
}
