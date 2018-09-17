package com.pku.common;

import java.util.Arrays;

/**
 * Created by zhaolizhen on 18-9-16.
 */
public class AirBnb2 {
    public static void main(String args[]){
        Practice1 practice1=new Practice1();
        System.out.println(practice1.maxStep(2,1));
    }

    public static void main1(String args[]){
        Practice2 practice2=new Practice2();
        String []inputs=new String[]{"ababaa"};
        int []result=practice2.usernameDisparity(inputs);
        System.out.println(Arrays.toString(result));
    }


    private static class Practice1{
        static int maxStep(int n, int k) {

            int result=0;
            int i=1;
            while(i<=n){
                if(result+i!=k){
                    result+=i;
                }else{
                    result=result+i-1;
                }
                i++;
            }
            return result;

        }
    }

    private static class Practice2{
        static int[] usernameDisparity(String[] inputs) {
            int []result=new int[inputs.length];
            if(null==inputs||0==inputs.length){
                return result;
            }

            for(int i=0;i<inputs.length;i++){
                int similarity=usernameDisparity(inputs[i]);
                result[i]=similarity;
            }
            return result;
        }

        static int usernameDisparity(String input){
            int result=input.length();
            for(int i=1;i<input.length();i++){
                int count=0;
                int k=i,j=0;
                while(k<input.length()&&input.charAt(k)==input.charAt(j)){
                    k++;
                    j++;
                    count++;
                }
                result+=count;
            }
            return result;
        }
    }

    private static class Practice3{

        public static void main3(String args[]){
            int [][]array=new int[][]{{1,1},{0,1}};
            System.out.println(numberOfPaths(array));
        }

        static void print(int[][]array){
            for(int i=0;i<array.length;i++){
                for(int j=0;j<array[i].length;j++){
                    System.out.print(array[i][j]+" ");
                }
                System.out.println();
            }
        }

        static int numberOfPaths(int[][] a) {
            if(a==null||0==a.length){
                return 0;
            }
            for(int i=1;i<a.length;i++){
                a[i][0]=Math.min(a[i-1][0],a[i][0]);
            }

            for(int j=1;j<a[0].length;j++){
                a[0][j]=Math.min(a[0][j-1],a[0][j]);
            }

            for(int i=1;i<a.length;i++){
                for(int j=1;j<a[i].length;j++){
                    if(a[i][j]==0) {
                        a[i][j]=0;
                    }else{
                        a[i][j] = a[i - 1][j]+a[i][j - 1];
                    }
                }
            }
//            print(a);
            return a[a.length-1][a[0].length-1];
        }

    }
}
