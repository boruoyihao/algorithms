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
         return dfs(mem,0,desiredTotal);
    }

    bool dfs(vector<bool>&mem,int sum,int desiredTotal){
       /*int i=mem.size()-1;
       for(;i>=1;i--){
           if(mem[i]){
               continue;
           }
           if(i+sum>=desiredTotal){
               return true;
           }
           break;
       }*/
       if(sum>=desiredTotal){
            return 1;
       }
       for(int j=1;j<mem.size();j++){
           if(mem[j]){
               continue;
           }
           mem[j]=true;
           if(dfs(mem,sum+j,desiredTotal)){
                return true;
           }
           mem[j]=false;
       }
       return false;
    }
};
#endif

#if 0
class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
         if(maxChoosableInteger>=desiredTotal){
              return true;
         }

         if((maxChoosableInteger+1)*maxChoosableInteger/2<desiredTotal){
              return false;
         }
         vector<bool>mem(maxChoosableInteger+1,false);
         return dfs(mem,maxChoosableInteger,desiredTotal,true);
    }

    bool dfs(vector<bool>&mem,int maxNo,int desiredTotal,bool status){
       if(desiredTotal<=0){
            return false;
       }
       for(int i=1;i<=maxNo;i++){
           if(mem[i]){
               continue;
           }
           mem[i]=true;
           if(!dfs(mem,maxNo,desiredTotal-i,!status)&&status){
                return true;
           }
           mem[i]=false;
       }
       return false;
    }
};

#endif

//the answer from leetcode discussion part
class Solution {
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        if(!desiredTotal) return 1;
        if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return 0;
        map<int,char> mem;
        return canWin(~0<<maxChoosableInteger, maxChoosableInteger, desiredTotal, mem);
    }
    bool canWin(int pool, int maxint, int tot, map<int,char>& mem) {
        if(tot<=0) return 0;
        if(mem.find(pool) != mem.end()) 
            return mem[pool];
        for(int i=0;i<maxint;i++) {
            int mask = 1<<i;
            if(pool & mask) continue;
            pool|=mask;
            if(!canWin(pool,maxint,tot-i-1,mem)) return mem[pool^=mask]=1;
            pool^=mask;
        }
        return mem[pool] = 0;
    }
};

int main(){
   Solution s;
   cout<<s.canIWin(10,11)<<endl;
   cout<<s.canIWin(18,79)<<endl;
   cout<<s.canIWin(10,40)<<endl;

   //int num=0;
   //cout<<(num<<=1)<<endl;
   //cout<<((-1)<<10)<<endl;
   cout<<(~0<<10)<<endl;
return 0;
}
