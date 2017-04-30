#include "common.h"

/**
 *Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
[7],
[2, 2, 3]
]
 * */

class Solution {

public:

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<vector<int>>result;
		vector<int>v;
		combinationSum(result,v,candidates,0,target);
		return result;
    }

	void combinationSum(vector<vector<int>>&result,vector<int>&v,vector<int>& candidates,int index,int target){
        if(index>=candidates.size()||target<0){
			return;
		}
		
		if(target==0){
			result.push_back(v);
			return;
		}
		v.push_back(candidates[index]);
		combinationSum(result,v,candidates,index,target-candidates[index]);
        v.pop_back();
		combinationSum(result,v,candidates,index+1,target);
	}

};
int main(){
    Solution *s=new Solution;
	int array[]={2,3,6,7};
	vector<int>candidates(array,array+4);
	vector<vector<int>> result=s->combinationSum(candidates,7);
	printVector(result);
	return 0;
}
