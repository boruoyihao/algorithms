#include "common.h"


/**
 *
 *Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * */

/*My Soluciton*/
#if 0
class Solution {

public:

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>>result;
        vector<int>v;
		sort(candidates.begin(),candidates.end());
        combinationSum2(result,v,candidates,0,target);
        return result;
    }   

    void combinationSum2(vector<vector<int>>&result,vector<int>&v,vector<int>& candidates,int index,int target){
        if(target<0){
            return;
        }
    
        if(target==0){
            result.push_back(v);
            return;
        }
		if(index>=candidates.size()){
			return;
		}
        v.push_back(candidates[index]);
        combinationSum2(result,v,candidates,index+1,target-candidates[index]);
        v.pop_back();
		if(index+1<candidates.size()&&candidates[index]==candidates[index+1]){
            while(index+1<candidates.size()&&candidates[index+1]==candidates[index]){
				index++;
			}
			combinationSum2(result,v,candidates,index+1,target);
			return;
        }
        combinationSum2(result,v,candidates,index+1,target);
    }   

};
#endif

class Solution {

public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {      
		vector<vector<int>>result;
        vector<int>v;
        sort(candidates.begin(),candidates.end());
        combinationSum2(result,v,candidates,0,target);
        return result;
    }

	void combinationSum2(vector<vector<int>>&result,vector<int>&v,vector<int>& candidates,int index,int target){
		if(target<0){
			return;
		}
		if(target==0){
			result.push_back(v);
			return;
		}
		for(int i=index;i<candidates.size()&&candidates[i]<=target;i++){
			if(i>index&&candidates[i]==candidates[i-1]){
				continue;
			}
			v.push_back(candidates[i]);
			combinationSum2(result,v,candidates,i+1,target-candidates[i]);
			v.pop_back();
		}
	}
};

int main(){
	Solution *s=new Solution;
    int array[]={10, 1, 2, 7, 6, 1, 5};
    vector<int>candidates(array,array+7);
    //int array[]={1,1,1,1};
    //vector<int> candidates(array,array+4);
	vector<vector<int>> result=s->combinationSum2(candidates,8);
    printVector(result);

	return 0;
}
