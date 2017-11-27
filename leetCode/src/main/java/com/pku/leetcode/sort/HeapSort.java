package com.pku.leetcode.sort;

/**
 * Created by zhaolizhen on 17-11-20.
 */

import java.util.Arrays;

/**
 * 堆排序 从小到大排序
 */
public class HeapSort {
    public static void main(String args[]) {
//        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int array[] = {8, 1, 10, 9, 8, 7, 6, 3, 4, 5, 4, 3, 2, 1, 0, 8};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 堆排序核心入口
     *
     * @param array
     */
    public void sort(int array[]) {
        for (int i = array.length >> 1; i >= 0; i--) {
            ajust(array, i, array.length);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            ajust(array, 0, i);
        }
    }

    private void ajust(int array[], int target, int length) {
        while (target < length) {
            int k = target * 2;
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (k < length && array[k] > array[target]) {
                swap(array, k, target);
                target = k;
            } else {
                break;
            }

        }
    }

    /**
     * 交换数组中两个数值
     *
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
