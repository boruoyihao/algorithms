package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-4-4.
 */

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".

 */
public class Longest_Palindromic_Subsequence_516 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("abc"));
        System.out.println(solution.longestPalindromeSubseq("a"));
        System.out.println(solution.longestPalindromeSubseq("abac"));
        System.out.println(solution.longestPalindromeSubseq("caba"));
        System.out.println(solution.longestPalindromeSubseq("abba"));
        System.out.println(solution.longestPalindromeSubseq("dabba"));
        System.out.println(solution.longestPalindromeSubseq("abbad"));
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }

    //DP Solution
    //https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99154/short-java-solutionbeats-99with-explanation
    private static class Solution1 {
        public int longestPalindromeSubseq(String s) {
            if (null == s || s.length() == 0) {
                return 0;
            }


            int[][] mem = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                mem[i][i] = 1;
            }

            return helper(mem, 0, s.length() - 1, s);

        }

        public int helper(int[][] mem, int i, int j, String s) {
            if (i > j || mem[i][j] != 0) {
                return mem[i][j];
            }

            if (s.charAt(i) == s.charAt(j)) {
                mem[i][j] = helper(mem, i + 1, j - 1, s) + 2;
            } else {
                mem[i][j] = Math.max(helper(mem, i + 1, j, s), helper(mem, i, j - 1, s));
            }
            return mem[i][j];
        }


    }

    //https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
    private static class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];

            for (int i = s.length() - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            System.out.println("result");
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
            return dp[0][s.length() - 1];
        }
    }

    //longest common subsequence
    //https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99151/Super-simple-solution-using-reversed-string
    private static class Solution2 {
        public int longestPalindromeSubseq(String s) {
            if (s == null || s.isEmpty()) return 0;
            int len = s.length();
            int[][] dp = new int[len + 1][len + 1];
            String t = new StringBuilder(s).reverse().toString();
            for (int i = len - 1; i >= 0; i--) {
                for (int j = len - 1; j >= 0; j--) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }

//            System.out.println("result");
//            for(int i=0;i<dp.length;i++){
//                for(int j=0;j<dp[0].length;j++){
//                    System.out.print(dp[i][j]+" ");
//                }
//                System.out.println();
//            }
            return dp[0][0];
        }
    }
}
