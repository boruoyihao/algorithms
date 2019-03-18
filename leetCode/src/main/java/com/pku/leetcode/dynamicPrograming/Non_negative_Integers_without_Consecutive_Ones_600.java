package com.pku.leetcode.dynamicPrograming;

/**
 * Created by zhaolizhen on 18-5-15.
 */

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a positive integer n, find the number of non-negative integers less than or equal to n,
 * whose binary representations do NOT contain consecutive ones.

 Example 1:
 Input: 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 */
public class Non_negative_Integers_without_Consecutive_Ones_600 {

    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.findIntegers(5));

    }

    //Memory Limit Exceeded 27/527 test cases passed
    //consutruct a tree to solve this problem
    private static class Solution1 {
        public int findIntegers(int num) {
            if(num<=0){
                return 0;
            }

            int value=1;
            while(value<=num){
                value=value<<1;
            }

            int mem[]=new int[value*2];

            mem[0]=0;
            Queue<Node> queue=new ArrayDeque<Node>(value*2);
            queue.add(new Node(0,0));
            while(!queue.isEmpty()){
                Node previous=queue.poll();
                if(previous.index*2+2>=mem.length){
                    break;
                }
                if(previous.value==0){
                    mem[previous.index*2+1]=0;
                    mem[previous.index*2+2]=1;
                }else if(previous.value==1){
                    mem[previous.index*2+1]=0;
                    mem[previous.index*2+2]=2;
                }else{
                    mem[previous.index*2+1]=2;
                    mem[previous.index*2+2]=2;
                }

                queue.add(new Node(previous.index*2+1,mem[previous.index*2+1]));
                queue.add(new Node(previous.index*2+2,mem[previous.index*2+2]));
            }

            int sum=0;
            for(int j=value-1;j<mem.length;j++){
                if(mem[j]!=2&&(j-(value-1))<=num){
                    sum++;
                }
            }
//            System.out.println(Arrays.toString(mem));
            return sum;
        }

        private static class Node{
            int index;
            int value;
            public Node(int index,int value){
                this.index=index;
                this.value=value;
            }
        }

    }

//https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/solution/
    private static class Solution {
        public int findIntegers(int num) {
            int f[]=new int[32];
            f[0]=1;
            f[1]=2;
            for(int i=2;i<32;i++){
                f[i]=f[i-2]+f[i-1];
            }

            int sum=0;
            boolean previous=false;
            int i=30;
            while(i>=0){
                if((num&(1<<i))!=0){
                    sum+=f[i];
                    if(previous){
                        sum--;
                        break;
                    }
                    previous=true;
                }else{
                    previous=false;
                }
                i--;
            }
            return sum+1;
        }
    }
}
