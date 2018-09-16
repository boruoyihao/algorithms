package com.pku.common;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhaolizhen on 18-9-14.
 */
public class Airbnb {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int count=scanner.nextInt();
        String[]input=new String[count];
        scanner.nextLine();
        for(int i=0;i<count;i++){
            input[i]=scanner.nextLine();
        }

        Practice1 practice1=new Practice1();
        String result[]=practice1.doesCircleExist(input);

        for(String s:result){
            System.out.println(s);
        }
    }

    public static void main1(String args[]){
        Practice2 practice2=new Practice2();
        Node root=practice2.createTree();
        System.out.println("result:" + practice2.isPresent(root, 2));
    }

    public static void main2(String args[]){
        Practice3 practice3=new Practice3();
        int a[]={7,10,7};
        int b[]={2,3,4};
        int c[]={2,7,4};
        String result[]=practice3.triangleOrNot(a,b,c);
        System.out.println(Arrays.toString(result));
    }

    public static void main3(String args[]){
        System.out.println(Practice5.consecutive(10));
    }

    private static class Practice1{
        static String[] doesCircleExist(String[] commands) {
            String[]result=new String[commands.length];
            for(int i=0;i<commands.length;i++){
                if(doesCirccleExist(commands[i])){
                    result[i]="YES";
                }else{
                    result[i]="NO";
                }
            }
            return result;
        }

        static boolean doesCirccleExist(String command){
            int x=0,y=0;
            int x1=1,y1=0;
            int count=4;
            while((count--)>0) {
                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i) == 'G') {
                        x = x + x1;
                        y = y + y1;
                    } else if (command.charAt(i) == 'R') {
                        if (x1 == 1) {
                            x1 = 0;
                            y1 = -1;
                        } else if (x1 == -1) {
                            x1 = 0;
                            y1 = 1;
                        } else if (y1 == 1) {
                            x1 = 1;
                            y1 = 0;
                        } else {
                            x1 = -1;
                            y1 = 0;
                        }
                    } else {
                        if (x1 == 1) {
                            x1 = 0;
                            y1 = 1;
                        } else if (x1 == -1) {
                            x1 = 0;
                            y1 = -1;
                        } else if (y1 == 1) {
                            x1 = -1;
                            y1 = 0;
                        } else {
                            x1 = 1;
                            y1 = 0;
                        }
                    }
                }
            }
            if(x==0&&y==0){
                return true;
            }else{
                return false;
            }
        }
    }

    private static class Practice2{

        private static Scanner scanner=new Scanner(System.in);
        private int isPresent(Node root, int val){
            if(null==root){
                return 0;
            }
            Node p=root;
            while(p!=null){
                if(p.data>val){
                    p=p.left;
                }else if(p.data<val){
                    p=p.right;
                }else{
                    return 1;
                }
            }
            return 0;
        }

        private Node createTree() {
            Node root = null;
            int value = scanner.nextInt();
            if (value == -1) {
                return root;
            }
            root = new Node(value);
            root.left = createTree();
            root.right = createTree();

            return root;
        }


    }

    private static class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    private static class Practice3{

        private String[] triangleOrNot(int[] a, int[] b, int[] c) {
            if(null==a||null==b||null==c){
                return new String[0];
            }

            int length=a.length;
            String result[]=new String[length];

            for(int i=0;i<length;i++){
                if(isTriangle(a[i],b[i],c[i])){
                    result[i]="YES";
                }else{
                    result[i]="NO";
                }
            }
            return result;
        }

        private boolean isTriangle(int a,int b,int c){
            if(a<=0||b<=0||c<=0){
                return false;
            }

            if(a+b>c&&a+c>b&&b+c>a){
                return true;
            }
            return false;
        }

    }

    //TLE
    private static class Practice4{
        // Complete the consecutive function below.
        static int consecutive(long num) {
            if(num<=0){
                return 0;
            }
            long length=(num>>1);
            int result=0;
            for(int i=1;i<=length;i++){
                if(isConsecutiveStart(i,length+1,num)){
                    result++;
                }
            }
            return result;

        }

        static boolean isConsecutiveStart(int start,long length,long num){
            int sum=0;
            for(int i=start;i<=length;i++){
                sum+=i;
                if(sum==num){
                    return true;
                }else if (sum>num){
                    return false;
                }
            }
            return false;
        }
    }

    //TLE
    private static class Practice5{
        // Complete the consecutive function below.
        static int consecutive(long num) {
            if(num<=0){
                return 0;
            }
            long length=((num+1)>>1);
            int result=0;

            long i=1,j=2;
            long sum=i;
            while(i<j&&j<=(length+1)){
                if(sum==num){
//                    System.out.println("i="+i+",j="+j);
                    result++;
                    sum+=(j++);
                    sum-=(i++);
                }else if(sum>num){
                    sum-=(i++);
                }else{
                    sum+=(j++);
                }
//                System.out.println("i="+i+",j="+j+",sum="+sum);

            }
            return result;

        }

    }


}
