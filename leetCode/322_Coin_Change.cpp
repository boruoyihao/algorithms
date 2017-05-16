#include "common.h"
/**
 *
 *You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 *
 * */
class Solution {

	public:

		int coinChange(vector<int>& coins, int amount) {
			vector<int>v(amount+1,0);
			sort(coins.begin(),coins.end());
			for(int i=1;i<=amount;i++){
				int min=amount+1;
				for(auto data:coins){
					if(i<data)
						continue;
					if(min>v[i-data]){
						min=v[i-data]+1;
					}
				}
				v[i]=min;
			}
			return v[amount]==(amount+1)?-1:v[amount];
		}

};


int main(){
	int array[]={2};
	vector<int>coins(array,array+1);
	Solution*s=new Solution;
	cout<<s->coinChange(coins,3)<<endl;
	return 0;
}
