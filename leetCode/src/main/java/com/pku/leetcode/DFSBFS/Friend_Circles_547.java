package com.pku.leetcode.DFSBFS;


/**
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature. For example, if A is a direct friend of B,
 * and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other,
 * otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */

/**
 * Created by zhaolizhen on 17-11-30.
 */
public class Friend_Circles_547 {

    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] M = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(s.findCircleNum(M));
    }

/*    private static class Solution {
        public int findCircleNum(int[][] M) {
            if (null == M || M.length == 0 || M[0].length == 0) {
                return 0;
            }
            int[] flag = new int[M.length];
            int circles = 0;
            Stack<Integer> s = new Stack<Integer>();
            for (int i = 0; i < M.length; i++) {
                if (flag[i] != 1) {
                    flag[i] = 1;
                    for (int j = i; j < M[i].length; j++) {
                        if (i != j && M[i][j] == 1 && flag[j] == 0) {
                            flag[j] = 1;
                            s.push(j);
                        }
                    }
                    dfs(M, s, flag);
                    circles++;
                }
                s.clear();
            }
            return circles;
        }

        private void dfs(int[][] M, Stack<Integer> stack, int flag[]) {
            while (!stack.isEmpty()) {
                int index = stack.peek().intValue();
                stack.pop();
                for (int i = 0; i < M[index].length; i++) {
                    if (i!=index&&M[index][i] == 1 && flag[i] == 0) {
                        flag[i] = 1;
                        stack.push(i);
                    }
                }
            }
        }
    }*/

/*    private static class Solution {
        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (visited[i] == 0) {
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }
        public void dfs(int[][] M, int[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && visited[j] == 0) {
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
        }
    }*/

/*    private static class Solution{
        public int findCircleNum(int[][] M) {
            int []flag=new int[M.length];
            int circles=0;
            for(int i=0;i<M.length;i++){
                if(flag[i]==0){
                    dfs(M,flag,i);
                    circles++;
                }
            }
            return circles;
        }

        private void dfs(int[][]M,int[]flag,int i){
            for(int j=0;j<M[i].length;j++){
                if(i!=j&&M[i][j]==1&&flag[j]==0){
                    flag[j]=1;
                    dfs(M,flag,j);
                }
            }
        }
    }*/

    private static class Solution {
        public int findCircleNum(int[][] M) {
            int[] leads = new int[M.length];
            for (int i = 0; i < M.length; i++) {
                leads[i] = i;
            }
            int circles = M.length;
            for (int i = 0; i < M.length; i++) {
                for (int j = i + 1; j < M[i].length; j++) {
                    if (i != j && M[i][j] == 1) {
                        int parenti = findParent(i, leads);
                        int parentj = findParent(j, leads);
                        if (parenti != parentj) {
                            leads[parenti] = parentj;
                            circles--;
                        }
                    }
                }
            }
            return circles;
        }

        int findParent(int x, int[] M) {
            return M[x] == x ? x : findParent(M[x], M);
        }

    }
}
