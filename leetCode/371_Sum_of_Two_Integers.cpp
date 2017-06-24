/**
 *Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.


 * */

#include "common.h"

class Solution {

public:
    int getSum(int a, int b) {
		
		while(b){
			int sum=a^b;
			int sum1=(a&b)<<1;
			a=sum;
			b=sum1;
		}
		return a;
    }

};

int main(){
	Solution*s=new Solution;
	cout<<s->getSum(15,-3)<<endl;
	return 0;
}
