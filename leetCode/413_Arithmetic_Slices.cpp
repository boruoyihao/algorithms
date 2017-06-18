/**
 *A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

 *
 * */

#include "common.h"


#if 0
//O(N*N)
class Solution {

public:

    int numberOfArithmeticSlices(vector<int>& A) {
		if(A.size()<3){
			return 0;
		}

		int count=0;
		for(int i=0;i<A.size()-2;i++){
			int diff=A[i+1]-A[i];
			for(int j=i+2;j<A.size();j++){
				if(A[j]-A[j-1]==diff){
					count++;
				}else{
					break;
				}
			}
		}
		return count;
    }

};
#endif
#if 0
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
		if(A.size()<3){
			return 0;
		}
		int diff=A[1]-A[0];
		int count=0;
		int mem=0;
		for(int i=2;i<A.size();i++){
			if(diff==A[i]-A[i-1]){
				mem++;	
			}else{
				count+=compute(mem);
				mem=0;
				diff=A[i]-A[i-1];
			}
		}
		return count+compute(mem);
    }
	int compute(int n){
		int count=0;
		for(int i=1;i<=n;i++){
			count+=i;
		}
		return count;
	}
};
#endif
//O(N*N) time complexity O(1) Space complexity
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        if(A.size()<3){
            return 0;
        }
        int diff=A[1]-A[0];
        int count=0;
        int mem=0;
        for(int i=2;i<A.size();i++){
            if(diff==A[i]-A[i-1]){
                mem++;
			    count+=mem;	
            }else{
                mem=0;
                diff=A[i]-A[i-1];
            }
        }
        return count;
    }
};


int main(){
	int array[]={1,2,3,4,5,7,9,11,13};
	vector<int>A(array,array+9);
	Solution *s =new Solution;
	cout<<s->numberOfArithmeticSlices(A)<<endl;
	return 0;
}
