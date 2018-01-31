/**
 *Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.

 *
 * */

#include "common.h"
using namespace std;

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n=matrix.size();
		int i=(k-1)/n;
		int j=(k-1)%n;
		return matrix[i][j];
    }
};

int main(){
	int array[3][3]={{1,5,9},{10,11,13},{12,13,15}};
	vector<vector<int>> matrix(3,vector<int>(3,0));
	for(int i=0;i<matrix.size();i++){
		for(int j=0;j<matrix[i].size();j++){
			matrix[i][j]=array[i][j];
		}
		
	}

	Solution*s=new Solution;
	cout<<s->kthSmallest(matrix,8)<<endl;

	printVector(matrix);
	return 0;
}
