#include"common.h"
using namespace std;

/**
 *
 *Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * */

class Solution {

public:

    vector<vector<int>> combine(int n, int k) {      
		vector<vector<int> >result;
		vector<int>v;
		combine(result,v,k,n,1);
		return result;
    }

	void combine(vector<vector<int> >&result,vector<int>&v,int k, int n,int index){
		if(v.size()>k){
			return;
		}

		if(v.size()==k){
			result.push_back(v);
			return;
		}
		for(int i=index;i<=n;i++){
			v.push_back(i);
			combine(result,v,k,n,i+1);
			v.pop_back();
		}
	}

};


int main(){
	Solution*s=new Solution;

	vector<vector<int> >result=s->combine(3,2);
	printVector(result);
	return 0;
}
