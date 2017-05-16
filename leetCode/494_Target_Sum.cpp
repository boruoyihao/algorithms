#include "common.h"

/**
 *
 *You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 *
 */
#if 0
class Solution {

public:

    int findTargetSumWays(vector<int>& nums, int S) {
		int sum=0;
		findTargetSumWays(nums,S,0,sum,0);
		return sum;
    }

	void findTargetSumWays(vector<int>& nums,int S,int index,int& sum,int count){
		if(index>nums.size()){
			return;
		}

		if(count==nums.size()&&S==0){
			sum++;
			return;
		}

		for(int i=index;i<nums.size();i++){
			findTargetSumWays(nums,S-nums[i],i+1,sum,count+1);
			findTargetSumWays(nums,S+nums[i],i+1,sum,count+1);
		}
	}

};
#endif

class Solution {

public:

    int findTargetSumWays(vector<int>& nums, int S) {
        if(nums.size()==0){
			return 0;
		}
		map<int,int>m1;
		m1[0]=0;
		map<int,int>m2;
		

		for(int i=0;i<nums.size();i++){
			for(map<int,int>::iterator it=m1.begin();it!=m1.end();it++){
				if(m2.find((it->first)+nums[i])==-1){
					m2[it->first+nums[i]]=1;	
				}else{
					m2[it->first+nums[i]]++;
				}

				if(m2.find((it->first)-nums[i])==-1){
					m2[it->first-nums[i]]=1;
				}else{
					m2[it->first-nums[i]]++;
				}
			}
			m1.clear();
			//m1.insert(m2);
			m2.clear();
		}

		int result=0;
		for(map<int,int>::iterator it=m1.begin();it!=m1.end();it++){
			if(S==it->first){
				result+=it->second;
			}
		}
		return result;
    }

};

int main(){
	Solution*s=new Solution;
	int array[]={1, 1, 1, 1, 1};
	vector<int>v(array,array+5);
	cout<<s->findTargetSumWays(v,1)<<endl;
	return 0;
}
