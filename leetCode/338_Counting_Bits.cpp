/**
 *Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 *
 * */

#include "common.h"

#if 0
class Solution {

public:

    vector<int> countBits(int num) {
		vector<int>result;
		for(int i=0;i<=num;i++){
			result.push_back(getOneNums(i));	
		}

		return result;
    }

	int getOneNums(int no){
		int count=0;
		int bits=1;
		while(bits<=no){
			if((no&bits)!=0){
				count++;
			}
			bits<<=1;
		}
		return count;
	}

};
#endif

//DP
class Solution {

public:

	vector<int> countBits(int num) {
    vector<int> bits(num+1, 0);
    for (int i = 1; i <= num; i++) bits[i] += bits[i & (i-1)] + 1;
    return bits;
 }
};
int main(){
	Solution* s=new Solution;
	vector<int>result=s->countBits(5);
	printVector1(result);
	//cout<<s->getOneNums(3)<<endl;
	return 0;
}
