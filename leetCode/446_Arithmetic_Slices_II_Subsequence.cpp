/**
 *A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.

The function should return the number of arithmetic subsequence slices in the array A.

The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.


Example:

Input: [2, 4, 6, 8, 10]

Output: 7

Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
 *
 * */

#include "common.h"

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
		if(A.size()<3){
			return 0;
		}

	   vector<map<int,int>>mem(A.size());
	   int res=0;
	   for(int i=0;i<A.size();i++){
	   		for(int j=0;j<i;j++){
				if((long)A[i]-(long)A[j]>INT_MAX||(long)A[i]-(long)A[j]<INT_MIN){
					continue;
				}
				int diff=A[i]-A[j];
				mem[i][diff]+=1;
				if(mem[j].find(diff)!=mem[j].end()){
					mem[i][diff]+=mem[j][diff];
					res+=mem[j][diff];	
				}
			}
	   }

	  return res;	   
    }
};

int main(){
	int array[]={1,3,4,4,5,7};
	vector<int>A(array,array+6);
	Solution*s=new Solution;
	cout<<s->numberOfArithmeticSlices(A)<<endl;
	cout<<INT_MAX<<endl;
	cout<<long(INT_MAX+2);
	return 0;
}
