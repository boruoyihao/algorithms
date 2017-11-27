package com.pku.leetcode.sort;

import java.util.Arrays;

/**
 * Created by zhaolizhen on 17-11-20.
 */

/**
 * 堆排序
 */
public class MergeSort {

    public static void main(String args[]) {
        int array[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1,1, 8,10};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.printf(Arrays.toString(array));
    }

    public void sort(int array[]) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int array[], int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + ((end - start) >> 1);
        sort(array, start, middle);
        sort(array, middle + 1, end);
        merge(array, start, middle, middle + 1, end);
    }

    /**
     * 合并过程
     *
     * @param array
     * @param start1 第一段开始
     * @param end1   第二段结束
     * @param start2 第二段开始
     * @param end2   第二段结束
     */
    public void merge(int[] array, int start1, int end1, int start2, int end2) {
        int temp[]=new int[end1-start1+end2-start2+2];
        int i=start1,j=start2;
        int k=0;
        while(i<=end1&&j<=end2){
            if(array[i]<array[j]){
                temp[k++]=array[i++];
            }else {
                temp[k++]=array[j++];
            }
        }
        while(i<=end1){
            temp[k++]=array[i++];
        }

        while(j<=end2){
            temp[k++]=array[j++];
        }
        k=0;
        for(i=start1;i<=end2;i++){
            array[i]=temp[k++];
        }
    }
}
