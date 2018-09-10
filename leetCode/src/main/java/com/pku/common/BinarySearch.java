package com.pku.common;

/**
 * Created by zhaolizhen on 18-7-19.
 */
public class BinarySearch {

    public static void main(String args[]){
        int array[]={9,10,1,2,3,4,5,6,7};
        System.out.println(find(array,10));
        System.out.println(find(array,6));
        System.out.println(find(array,4));

        System.out.println("next line");
        int array1[]={3,4,5,6,7,8,9,10,1,2};
        System.out.println(find(array1,2));
        System.out.println(find(array1,4));
        System.out.println(find(array1,10));

        System.out.println("next line");
        int array2[]={3,4};
        System.out.println(find(array2,3));
        System.out.println(find(array2,4));

        System.out.println("next line");
        int array3[]={3,3,3,3,4,5,6,7,8,9,10,1,2};
        System.out.println(find(array3,3));
        System.out.println(find(array3,4));
        System.out.println(find(array3,10));



    }

    public static int find(int array[],int n){
        if(0>=array.length){
            return -1;
        }
        int i=0,j=array.length-1;
        while(i<=j){
            int middle=i+(j-i)/2;
            if(array[middle]==n){
                return middle;
            }else if(array[middle]<array[j]){
                if(array[middle]<=n&&n<=array[j]){
                    i=middle+1;
                }else{
                    j=middle-1;
                }
            }else{
                if(array[i]<=n&&n<=array[middle]){
                    j=middle-1;
                }else{
                    i=middle+1;
                }
            }
        }

        return -1;
    }
}
