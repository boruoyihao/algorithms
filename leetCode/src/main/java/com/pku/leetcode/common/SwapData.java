package com.pku.leetcode.common;

import java.util.Arrays;

/**
 * Created by zhaolizhen on 17-11-27.
 */
public class SwapData {
    public static void main(String args[]){
        int array[]={1,2,3,4,5};
        SwapData swapData=new SwapData();
        swapData.swap(array,0,4);
        System.out.println(Arrays.toString(array));
    }

    public void swap(int []array,int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
}
