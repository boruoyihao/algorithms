package com.pku.leetcode.common;


import java.util.Arrays;

/**
 * 大顶堆 适用于选取前K的数
 */
public class MaxHeap {
    private int[] array;
    private int size = 0;
    private int defaultSize = 10;

    public MaxHeap(int size) {
        this.array = new int[size];
    }

    public MaxHeap() {
        this.array = new int[defaultSize];
    }

    /**
     * 入队
     *
     * @param data
     */
    public void push(int data) {
        if (size >= array.length) {
            resize();
        }

        array[size] = data;
        up(size);
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    public int pop() {
        if (size <= 0) {
            throw new IllegalArgumentException("没有数据");
        }
        int max = getMax();
        array[0] = array[size - 1];
        array[size - 1] = 0;
        sink(0);
        size--;
        return max;
    }

    /**
     * 获取堆最大值
     *
     * @return
     */
    public int getMax() {
        if (size <= 0) {
            throw new IllegalArgumentException("没有数据");
        }
        return array[0];
    }

    /**
     * 下沉操作
     *
     * @param targetIndex
     */
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

    /**
     * 上浮操作
     *
     * @param targetIndex
     */
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

    /**
     * 调整数组大小
     */
    private void resize() {
        System.out.println("resize capacity*2");
        int newArray[] = Arrays.copyOf(array, array.length * 2);
        array = newArray;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void printHeap() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String args[]) {
        MaxHeap maxHeap = new MaxHeap(2);

        int array[] = {700, 20, 177, 3, 40, 30, 8, 6, 9, 10, 4, 100, 2, 400, -1};
        for (int data : array) {
            maxHeap.push(data);
        }

        maxHeap.printHeap();

        System.out.println(maxHeap.pop());
        System.out.println(maxHeap.pop());

        maxHeap.printHeap();
    }

}

//public class MaxHeap {
//
//    private int[] array;
//
//    private int index=0;
//
//    public MaxHeap(int k) {
//        array = new int[k];
//        for(int i=0;i<array.length;i++){
//            array[i]=Integer.MAX_VALUE;
//        }
//    }
//
//    public void push(int data) {
//        if(index>=array.length) {
//            if (array[0] > data) {
//                array[0] = data;
//                ajust(array, 0, array.length);
//            }
//        }else{
//            array[index++]=data;
//            if(index==array.length){
//                for(int i=array.length>>1;i>=0;i--){
//                    ajust(array,i,array.length);
//                }
//                printHeap();
//            }
//        }
//    }
//
//    public int getMax(){
//        return array[0];
//    }
//
//    public int getMin(){
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<array.length;i++){
//            if(min>array[i]){
//                min=array[i];
//            }
//        }
//        return min;
//    }
//
//
//    private void ajust(int array[], int target, int length) {
//        while (target < length) {
//            int k = target * 2;
//            if (k + 1 < length && array[k] < array[k + 1]) {
//                k++;
//            }
//            if (k < length && array[k] > array[target]) {
//                swap(array, k, target);
//                target = k;
//            } else {
//                break;
//            }
//
//        }
//    }
//
//    public void printHeap(){
//        System.out.println(Arrays.toString(array));
//    }
//
//    /**
//     * 交换数组中两个数值
//     *
//     * @param array
//     * @param i
//     * @param j
//     */
//    private void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//
//
//    public static void main(String args[]){
//        MaxHeap maxHeap=new MaxHeap(8);
//        int array[]={700,20,177,0,40,30,8,6,9,10,0,100,2,400,-1};
//
//        for(int data:array){
//            maxHeap.push(data);
//        }
//
//        System.out.println("max:"+maxHeap.getMax());
//        System.out.println("min:"+maxHeap.getMin());
//        maxHeap.printHeap();
//    }
//}
