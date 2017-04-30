#include "common.h"

/**
 *Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 *
 */


class Solution {

public:

    vector<vector<int>> combinationSum3(int k, int n) {

		vector<vector<int>>result;
		vector<int>v;
		combinationSum3(result,v,1,k,n);
		return result;
    }

	void combinationSum3(vector<vector<int>>&result,vector<int>&v,int index,int k,int n){
		if(n<0){
			return;
		}
		if(v.size()>k){
			return;
		}
		if(n==0&&v.size()==k){
			result.push_back(v);
		}
		for(int i=index;i<=9;i++){
			v.push_back(i);
			combinationSum3(result,v,i+1,k,n-i);
			v.pop_back();
		}
	}

};

int main(){
	Solution*s=new Solution;
	vector<vector<int>> result=s->combinationSum3(3,9);
	printVector(result);
	return 0;
}
