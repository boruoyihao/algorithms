package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-6-29.
 */

/**
 * We partition a row of numbers A into at most K adjacent (non-empty) groups,
 * then our score is the sum of the average of each group. What is the largest score we can achieve?
 * <p>
 * Note that our partition must use every number in A,
 * and that scores are not necessarily integers.
 * <p>
 * Example:
 * Input:
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation:
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class Largest_Sum_of_Averages_813 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        int A[] = {9, 1, 2, 3, 9};
        System.out.println(solution.largestSumOfAverages(A, 3));

        int A1[] = {1,9,9,1,2,10};
        System.out.println(solution.largestSumOfAverages(A1, 4));

        int A2[] = {1,2};
        System.out.println(solution.largestSumOfAverages(A2, 1));

        int A3[]={4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698};
        System.out.println(solution.largestSumOfAverages(A3, 27));

    }


    //Time limit exceeded
    private static class Solution1 {
        public double largestSumOfAverages(int[] A, int K) {
            return findMaxAverage(A, 0, A.length, K);
        }

        private double findMaxAverage(int[] A, int start, int end, int K) {

            if (start >= end || 0 == K) {
                return 0.0;
            } else if (1 == K) {
                return getAverage(A, start, end);
            }
            double max = 0;
            for (int i = start + 1; i < end; i++) {
                double average1 = getAverage(A, start, i);
                double average2 = findMaxAverage(A, i, end, K - 1);
                max = Math.max(max, average1 + average2);
            }
            return max;
        }


        /**
         * 求平均值
         *
         * @param A
         * @param start
         * @param end
         * @return
         */
        private double getAverage(int A[], int start, int end) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                sum += A[i];
            }
            return sum / (end - start);
        }

    }


    private static class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            return 0;
        }
    }
}
