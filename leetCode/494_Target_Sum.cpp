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

#if 0
//265ms
class Solution {

public:

    int findTargetSumWays(vector<int>& nums, int S) {
        if(nums.size()==0){
			return 0;
		}
		map<int,int>m1;
		m1[0]=1;
		map<int,int>m2;
		

		for(int i=0;i<nums.size();i++){
			for(map<int,int>::iterator it=m1.begin();it!=m1.end();it++){
				if(m2.find((it->first)+nums[i])==m2.end()){
					m2[it->first+nums[i]]=it->second;	
				}else{
					m2[it->first+nums[i]]=m2[it->first+nums[i]]+it->second;
				}

				if(m2.find((it->first)-nums[i])==m2.end()){
					m2[it->first-nums[i]]=it->second;
				}else{
					m2[it->first-nums[i]]=m2[it->first-nums[i]]+it->second;
				}
			}
			m1.clear();
			for(map<int,int>::iterator it=m2.begin();it!=m2.end();it++){
				m1[it->first]=it->second;
				//cout<<it->first<<" "<<it->second<<" "<<endl;
			}
			//cout<<endl;
			m2.clear();
		}

		int result=0;
		for(map<int,int>::iterator it=m1.begin();it!=m1.end();it++){
			if(S==it->first){
				result+=it->second;
			}
			//cout<<it->first<<" "<<it->second<<endl;
		}
		return result;
    }

};

#endif
#if 0
class Solution {

public:

    int findTargetSumWays(vector<int>& nums, int S) {

        vector<int>v(2000,0);

		v[0]=1;
		for(int i=0;i<nums.size();i++){
			for(int j=0;j<2000;j++){
				if(v[j]==0||v[j]==-1){
					continue;
				}
				int plus,minus;
				if(j<1000){
					plus=j+nums[i];
					minus=j-nums[i];
				}else{
					plus=1000-j+nums[i];
					minus=1000-j-nums[i];
				}
				
				cout<<j<<"="<<v[j]<<" "<<plus<<" "<<minus<<"++"<<endl;
				if(plus>0){
					v[plus]+=v[j];
				}else{
					v[0-plus+1000]+=v[j];
				}

				if(minus>0){
					v[minus]+=v[j];
				}else{
					v[0-minus+1000]+=v[j];
				}

                		   

				v[j]=-1;

			}
			cout<<endl;
		}

		for(int i=0;i<50;i++){
			cout<<v[i]<<" ";
		}
		cout<<endl;
		return S>0?v[S]:v[0-S+1000];

    }

};

#endif

class Solution {

public:

    int findTargetSumWays(vector<int>& nums, int S) {      
		int sum=0;
		for(int i=0;i<nums.size();i++){
			sum+=nums[i];
		}
		return sum<S||(S+sum)&1?0:findTargetSum(nums,(S+sum)>>1);
    }

	int findTargetSum(vector<int>& nums,int sum){
		vector<int> dp(sum+1,0);
		dp[0]=1;
		for(auto no:nums){
			for(int i=sum;i>=no;i--){
				dp[i]+=dp[i-no];
			}
		}
        return dp[sum];
	}
};
int main(){
	Solution*s=new Solution;
	int array[]={1, 1, 1, 1, 1};
	vector<int>v(array,array+5);
	cout<<s->findTargetSumWays(v,3)<<endl;
	return 0;
}
