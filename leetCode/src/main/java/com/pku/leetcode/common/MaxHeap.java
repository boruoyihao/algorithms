package com.pku.leetcode.common;


/**
 * 大顶堆
 */
public class MaxHeap {

    private int[] array;
    private int index=-1;

    public MaxHeap(int k) {
        array = new int[k];
    }

    public void push(int data) {
        if(index==array.length){
            if(array[0]>data) {
                array[0] = data;
                ajust(0, array.length);
            }
        }else{
            array[++index]=data;
            ajust(index,index);
        }
    }

    /**
     * 获取大顶堆最大值
     * @return
     */
    public int getMax() {
        if(index==-1){
            return Integer.MIN_VALUE;
        }
        return array[0];
    }

    /**
     * 调整
     * @param k
     * @param length
     */
    private void ajust(int k,int length){

    }

    /**
     * 交换两个数
     * @param i
     * @param j
     */
    private void swap(int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
}