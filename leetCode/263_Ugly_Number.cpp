/**

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/

#include "common.h"

class Solution {
public:
    bool isUgly(int num) {
        if(num<1){
           return false; 
        }
        if(1==num){
           return true; 
        }
        while(num!=1){
           int num2=num%2;
           int num5=num%5;
           int num3=num%3;
           if(num2&&num5&&num3){
              return false;
           }
           if(num2==0){
           	num=num/2;
           }
           if(num3==0){
               num=num/3;
           }
           if(num5==0){
               num=num/5;
           }
        }
        return num==1?true:false;        
    }
};


int main(){
  Solution* s=new Solution;
  cout<<s->isUgly(2)<<endl;
}
