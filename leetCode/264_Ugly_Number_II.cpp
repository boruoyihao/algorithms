/**
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
*/

#include "common.h"

class Solution {
public:
    int nthUglyNumber(int n) {
        int factor2=1;
        int factor3=1;
        int factor5=1;
        int start=1;
        for(int i=0;i<n;i++){
           factor2*2
        }    
    }
};


int main(){

    Solution *s =new Solution;
    cout<<s->nthUglyNumber(3)<<endl;
    cout<<s-nthUglyNumber(5)<<endl;
    return 0;
}
