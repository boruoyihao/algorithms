package com.pku.leetcode.greedy;

/**
 * Created by zhaolizhen on 18-4-23.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.


 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Queue_Reconstruction_by_Height_406 {

    public static void main(String args[]){
        int [][]people={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution solution=new Solution();
        int [][]result=solution.reconstructQueue(people);
        print(result);

    }

    public static void print(int [][]people){
        System.out.println("new Print");
        for(int i=0;i<people.length;i++){
            for(int j=0;j<people[0].length;j++){
                System.out.print(people[i][j] + ",");
            }
            System.out.println();
        }
    }

    private static class Solution1 {
        public int[][] reconstructQueue(int[][] people) {
            if(null==people||people.length<=1){
                return people;
            }

            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]!=o2[1]){
                        return o1[1]-o2[1];
                    }
                    return o1[0]-o2[0];
                }
            });


            for(int i=1;i<people.length;i++){
                int count=0;
                for(int j=0;j<i;j++){
                    if(count<people[i][1]&&people[i][0]<=people[j][0]){
                        count++;
                    }
                    else if(count==people[i][1]&&count!=0&&people[i][0]<=people[j][0]){
                        int k=i;
                        int temp[]=new int[2];
                        temp[0]=people[i][0];
                        temp[1]=people[i][1];
                        while(k>j){
                            people[k]=people[k-1];
                            k--;
                        }
                        people[j]=temp;
                        break;
                    }
                }
            }
            return people;
        }
    }


    private static class Solution2 {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] person1, int[] person2) {
                    return (person1[0] == person2[0]) ? person1[1] - person2[1] : person2[0] - person1[0];
                }
            });

            print(people);
            List<int[]> list = new ArrayList<int[]>();
            for (int[] cur : people) {
                list.add(cur[1], cur);
            }
            return list.toArray(new int[people.length][2]);
        }
    }


    private static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] person1, int[] person2) {
                    return (person1[0] == person2[0]) ? person1[1] - person2[1] : person2[0] - person1[0];
                }
            });

            List<int[]> list = new ArrayList<int[]>();
            for (int[] cur : people) {
                list.add(cur[1], cur);
            }
            return list.toArray(new int[people.length][2]);
        }
    }
}
