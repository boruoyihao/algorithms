package com.pku.leetcode.array;

/**
 * Created by zhaolizhen on 18-3-7.
 */

/**
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

 The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

 The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

 Example 1:

 Input: row = [0, 2, 1, 3]
 Output: 1
 Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 Example 2:

 Input: row = [3, 2, 0, 1]
 Output: 0
 Explanation: All couples are already seated side by side.
 Note:

 len(row) is even and in the range of [4, 60].
 row is guaranteed to be a permutation of 0...len(row)-1.
 */
public class Couples_Holding_Hands_765 {

    public static void main(String args[]){
        Solution solution=new Solution();
        int nums1[]={0, 2, 1, 3};
        System.out.println(solution.minSwapsCouples(nums1));

        int nums2[]={3, 2, 0, 1};
        System.out.println(solution.minSwapsCouples(nums2));


        int nums3[]={3, 1, 2, 5,4,0};
        System.out.println(solution.minSwapsCouples(nums3));


        int nums4[]={0,2,4,6,7,1,3,5};
        System.out.println(solution.minSwapsCouples(nums4));
    }

    private static class Solution {
        public int minSwapsCouples(int[] row) {
            if(null==row||0==row.length){
                return 0;
            }
            int mem[]=new int[row.length];
            for(int i=0;i<row.length;i++){
                mem[row[i]]=i;
            }

            int result=0;
            for(int i=0;i<row.length;i=i+2){
                if((row[i]>>1)==(row[i+1]>>1)){
                    continue;
                }

                int targetCouple=((row[i]&0x1)==1)?row[i]-1:row[i]+1;
                swap(row,i+1,mem[targetCouple]);//swap data
                swap(mem,row[i+1],row[mem[targetCouple]]); //update mem array
                result++;
            }

            return result;
        }


        void swap(int []array,int i,int j){
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }

    }
}
