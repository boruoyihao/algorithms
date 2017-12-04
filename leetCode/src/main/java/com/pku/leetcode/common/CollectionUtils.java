package com.pku.leetcode.common;

import java.util.List;

/**
 * Created by zhaolizhen on 17-12-4.
 */
public class CollectionUtils {


    public  static <T> void print(List<List<T>> list){
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

}
