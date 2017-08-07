/**

In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.

*/

#include "common.h"

#if 0
class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
  	 vector<bool>mem(maxChoosableInteger+1,false);
         return dfs(mem,0,desiredTotal,true);
    }

    bool dfs(vector<bool>&mem,int sum,int desiredTotal,bool status){


       //cout<<"sum:"<<sum<<",status:"<<status<<endl;
       int i=mem.size()-1;
       for(;i>=1;i--){
           if(mem[i]){
               continue;
           }
           if(status&&i+sum>=desiredTotal){
               return true;
           }
           if(!status&&i+sum>=desiredTotal){
               return false;
           }
           break;
       }

       for(int j=1;j<=i;j++){
           if(mem[j]){
               continue;
           }
           mem[j]=true;
           if(dfs(mem,sum+j,desiredTotal,!status)){
                return true;
           }
           mem[j]=false;
       }
       return false;
    }
};
#endif

class Solution {
public:
       bool canIWin(int maxChoosableInteger, int desiredTotal) {
        if(!desiredTotal) return 1;
        return canWin(~0<<maxChoosableInteger, maxChoosableInteger, desiredTotal);
    }
    bool canWin(int pool, int maxint, int tot) {
        if(tot<=0) return 0;
        for(int i=0;i<maxint;i++) {
            int mask = 1<<i;
            if(pool & mask) continue;
            pool|=mask;
            if(!canWin(pool,maxint, tot-i-1)) return 1;
            pool^=mask;
        }
        return 0;
    }
};


int main(){
   Solution s;
   cout<<s.canIWin(10,15)<<endl;
   cout<<((-1)<<10)<<endl;
   cout<<(1<<10)<<endl;
return 0;
}