/**
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
*/

#include "common.h"
using namespace std;

class Solution {
public:
    int nthUglyNumber(int n) {
        if(n<=0){
           return 0;
        }
        int *mem=new int[n];
        mem[0]=1;
        int factor2=0;
        int factor3=0;
        int factor5=0;
        int next=1;
        while(next<n){
           int min=min3(mem[factor2]*2,mem[factor3]*3,mem[factor5]*5);
           mem[next]=min;
           while(mem[factor2]*2<=min){
                factor2++;
           }
           while(mem[factor3]*3<=min){
                factor3++;
           }
           while(mem[factor5]*5<=min){
                factor5++;
           }
           next++;
        }
       return mem[n-1];    
    }

    int min3(int no1,int no2,int no3){

	return no1>no2?(no2>no3?no3:no2):(no1>no3?no3:no1);
    }
};


int main(){

    Solution *s =new Solution;
    cout<<s->nthUglyNumber(3)<<endl;
    cout<<s->nthUglyNumber(10)<<endl;
    return 0;
}
