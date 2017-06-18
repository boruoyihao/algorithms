/**
 *
 *A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?
 *
 *
 * */

#include "common.h"

#if 0
//DP
class Solution {

public:

    int wiggleMaxLength(vector<int>& nums) {
		if(nums.size()<2){
			return nums.size();
		}
		vector<int>mem(nums.size()-1);
		for(int i=1;i<nums.size();i++){
			mem[i-1]=nums[i]-nums[i-1];
		}

		int preTag=mem[0]<0?-1:mem[0]>0?1:0;
		int count=preTag==0?0:1;
		int tag;
		for(int i=1;i<mem.size();i++){
			tag=mem[i]<0?-1:mem[i]>0?1:0;
			if(tag!=0&&tag==-preTag){
				preTag=tag;
				count++;
			}else if(tag!=0&&preTag==0){
				preTag=tag;
				count++;
			}
		}
		return count+1;
    }

};
#endif

//Greedy
class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        int size=nums.size(), f=1, d=1;
        for(int i=1; i<size; ++i){
                 if(nums[i]>nums[i-1]) f=d+1;
            else if(nums[i]<nums[i-1]) d=f+1;
        }
        return min(size, max(f, d));
    }
};

int main(){
    //int array[]={1,17,5,10,13,15,10,5,16,8};
	//vector<int>nums(array,array+10);
	int array[]={5,3,3,2,5};
	vector<int>nums(array,array+5);
	Solution*s=new Solution;
	cout<<s->wiggleMaxLength(nums)<<endl;
	return 0;
}
