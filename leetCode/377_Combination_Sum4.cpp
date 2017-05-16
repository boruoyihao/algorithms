#include "common.h"

/**
 *
 *Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 * */

#if 0
class Solution {

	public:

		int combinationSum4(vector<int>& nums, int target) {
			vector<vector<int> >result;
			vector<int>v;
			combinationSum4(result,v,nums,target,0);
			//printVector(result);
			return result.size();
		}

		void combinationSum4(vector<vector<int> >&result,vector<int>&v,vector<int>&nums,int target,int index){

			if(target<0){
				return;
			}
			if(target==0){
				result.push_back(v);
				return;
			}

			if(index>=nums.size()){
				return;
			}
			for(int i=0;i<nums.size();i++){
				v.push_back(nums[i]);
				combinationSum4(result,v,nums,target-nums[i],i);
				v.pop_back();
			}
			/* v.push_back(nums[index]);
			   combinationSum4(result,v,nums,target-nums[index],index);
			   v.pop_back();
			   combinationSum4(result,v,nums,target,index+1);*/
		}

};
#endif

/*回溯算法时间超时 TLE*/
#if 0
class Solution {

	public:

		int combinationSum4(vector<int>& nums, int target) {
			int sum=0;
			combinationSum4(sum,nums,target,0);
			return sum;
		}

		void combinationSum4(int &sum,vector<int>&nums,int target,int index){

			if(target<0){
				return;
			}
			if(target==0){
				sum++;
				return;
			}

			if(index>=nums.size()){
				return;
			}
			for(int i=0;i<nums.size();i++){
				combinationSum4(sum,nums,target-nums[i],i);
			}
		}

};



#endif

#if 0
class Solution {

	public:

		int combinationSum4(vector<int>& nums, int target) {
			int sum=0;
			vector<int>v;
			combinationSum4(sum,v,nums,target,0);
			return sum;
		}

		void combinationSum4(int &sum,vector<int>&v,vector<int>&nums,int target,int index){

			if(target<0){
				return;
			}
			if(target==0){
				sum++;
				printVector1(v);
				return;
			}

			if(index>=nums.size()){
				return;
			}
			for(int i=0;i<nums.size();i++){
				v.push_back(nums[i]);
				combinationSum4(sum,v,nums,target-nums[i],i);
				v.pop_back();
			}
		}

};

#endif

#if 1
class Solution {
	public:
		int combinationSum4(vector<int>& nums, int target) {
			vector<int>v(target+1,0);
			v[0]=1;
			sort(nums.begin(),nums.end());
			for(int i=1;i<=target;i++){
				for(int j=0;j<nums.size();j++){
					if(i>=nums[j]){
						v[i]=v[i]+v[i-nums[j]];
					}
				}
			}
			return v[target];
		}

};
#endif
int main(){
	Solution*s=new Solution;
	int array[]={1,2,3};
	vector<int>nums(array,array+3);
	cout<<s->combinationSum4(nums,32)<<endl;


	return 0;
}
