package com.pku.leetcode.search;

/**
 * Created by zhaolizhen on 17-11-7.
 */


/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

    public static void main(String args[]){
        int [][]matrix=new int[][]{{1,1,1},{1,2,4},{1,3,5}};
        Solution s=new Solution();
        System.out.println(s.kthSmallest(matrix, 9));
    }

    private static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
            while(lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int count = 0,  j = matrix[0].length - 1;
                for(int i = 0; i < matrix.length; i++) {
                    while(j >= 0 && matrix[i][j] > mid) j--;
                    count += (j + 1);
                }
                System.out.println("mid="+mid+",lo="+lo+",hi="+hi+",count="+count);
                if(count < k) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }

/*    private static class Solution{
        public int kthSmallest(int[][] matrix, int k) {
            MaxHeap maxHeap=new MaxHeap(k);
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    maxHeap.push(matrix[i][j]);
                }
            }

            return maxHeap.getMax();
        }

    }

    private static class MaxHeap {
        private int[] array;
        private int size = 0;

        public MaxHeap(int size) {
            this.array = new int[size];
        }

        *//**
         * 入队
         *
         * @param data
         *//*
        public void push(int data) {
            if(size<array.length){
                array[size] = data;
                up(size);
                size++;
            }else if(array[0]>data){
                array[0]=data;
                sink(0);
            }

        }


        *//**
         * 获取堆最大值
         *
         * @return
         *//*
        public int getMax() {
            if (size <= 0) {
                throw new IllegalArgumentException("没有数据");
            }
            return array[0];
        }

        *//**
         * 下沉操作
         *
         * @param targetIndex
         *//*
        private void sink(int targetIndex) {
            int i = targetIndex;
            while (2 * i < size) {
                int child = i * 2;
                if (child + 1 < size && array[child] < array[child + 1]) {
                    child++;
                }
                if (array[child] > array[i]) {
                    swap(child, i);
                    i = child;
                } else {
                    break;
                }
            }
        }

        *//**
         * 上浮操作
         *
         * @param targetIndex
         *//*
        private void up(int targetIndex) {
            int i = targetIndex;
            while (i > 0) {
                int parent = i >>> 1;
                if (array[i] > array[parent]) {
                    swap(i, parent);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        private void printHeap() {
            System.out.println(Arrays.toString(array));
        }


    }*/


}

