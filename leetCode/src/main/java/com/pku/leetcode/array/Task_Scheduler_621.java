package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-11.
 */

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.

 Example 1:
 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 Note:
 The number of tasks is in the range [1, 10000].
 The integer n is in the range [0, 100].
 */
public class Task_Scheduler_621 {

    public static void main(String args[]){
        char tasks[]={'A','A','A','B','B','B'};

        Solution solution=new Solution();
        System.out.println(solution.leastInterval(tasks,2));
    }

    private static class Solution {
        public int leastInterval(char[] tasks, int n) {
            if(null==tasks||tasks.length<=1){
                return 0;
            }
            //如果不需要间隔
            if(0==n){
                return tasks.length;
            }

            int []taskCount=new int[26];
            for(char task:tasks){
                taskCount[task-'A']++;
            }

            int intervals=0;
            for(int i=0;i<tasks.length;i++){
                
            }

            return 0;
        }
    }
}
