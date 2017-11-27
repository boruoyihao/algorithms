package com.pku.leetcode.common;

/**
 * Created by zhaolizhen on 17-11-27.
 */
public class BinarySerarch {
    public static void main(String args[]){
        int[]array={1,1,1,1,1,2,3,3,4,5};
        BinarySerarch binarySerarch=new BinarySerarch();
        System.out.println(binarySerarch.search(array,3));
    }

    /**
     * 二分查找
     * @param array
     * @param data
     * @return
     */
    public int search(int []array,int data){
        int i=0,j=array.length;
        while(i<j){
            int middle=i+(j-i)/2;
            if(array[middle]<data){
                i=middle+1;
            }else if(array[middle]>data){
                j=middle-1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
