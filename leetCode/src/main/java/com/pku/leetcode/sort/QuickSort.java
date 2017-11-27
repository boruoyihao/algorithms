package com.pku.leetcode.sort;

import java.util.Arrays;

/**
 * Created by zhaolizhen on 17-11-20.
 */
public class QuickSort {
    public static void main(String args[]){
        int array[]={10,9,8,7,6,5,4,3,2,1,6,5,4,3,10};
        QuickSort quickSort=new QuickSort();
        quickSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 默认对数组全排序
     * @param array
     */
    public void sort(int array[]){
        sort(array,0,array.length-1);
    }

    /**
     *
     * @param array 要排序数组
     * @param start 起始位置
     * @param end 结束位置
     */
    public void sort(int array[],int start,int end){
        int i=start;
        int j=end;
        if(i>=j){
            return;
        }
        int temp=array[i];
        while(i<j){
            while(i<j&&array[j]>=temp){
                j--;
            }
            if(array[j]<temp) {
                array[i++] = array[j];
            }
            while(i<j&&array[i]<temp){
                i++;
            }
            if(array[i]>=temp) {
                array[j--] = array[i];
            }
        }
        array[i]=temp;
        sort(array,start,i-1);
        sort(array,i+1,end);
    }
}
