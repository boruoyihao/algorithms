/**

A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.
Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.

*/

#include "common.h"

//TLE
#if 0
class Solution {
public:
    bool canCross(vector<int>& stones) {
        if(stones.size()<2){
           return false;
        }
        map<int,int>m;
        return dfs(stones,0,1,m);      
    }

    bool dfs(const vector<int>&stones,int index,int step,map<int,int>&m){
        if(step<1){
            return false;
        }

        if(m.find(index)!=m.end()&&m[index]==step){
             return false;
        }
        if(stones[index]+step==stones[stones.size()-1]){
           return true;
        }

        //cout<<"index="<<index<<"step="<<step<<endl;
        for(int i=index+1;i<stones.size();i++){
            if(stones[index]+step==stones[i]) {            
                 return dfs(stones,i,step-1,m)||dfs(stones,i,step,m)||dfs(stones,i,step+1,m);
            }else if(stones[index]+step>stones[i]&&(i-1)>0&&stones[index]+step<stones[i-1]){
                m[index]=step;
                return false;
            }
	}
       m[index]=step;
       return false;
    }
};

#endif

#if 1
class Solution {
public:
    bool canCross(vector<int>& stones) {
     	if(stones.size()<=1){
            return true;
        }
        map<int,int>indexMem;
        for(int i=0;i<stones.size();i++){
            if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;} // The two stones are too far away. 
            indexMem[stones[i]]=i;
        }

        map<int,set<int> > mem;
        set<int>v;
        v.insert(1);
        mem[0]=v;
        int step[]={-1,0,1};
        for(int i=0;i<stones.size();i++){
            for(set<int>::iterator it=mem[i].begin();it!=mem[i].end();it++){
                for(int k=0;k<3;k++){
                     int jump=(*it)+step[k];
                     int expected=stones[i]+jump;
                     //cout<<"expected:"<<expected<<",jump:"<<jump<<endl;
                     if(jump<stones.size()&&expected==stones[stones.size()-1]){
                        return true;        
                     }else if(jump>0){
                       if(indexMem.find(expected)!=indexMem.end()){
                           int index=indexMem[expected];
                           if(mem.find(index)==mem.end()){
                                set<int> vv;
                                vv.insert(jump);
                                mem[index]=vv;
                            }else{
                                mem[index].insert(jump);
                         }
                       } 
                  }
               }
            }
        }
      return false;   
    }
};
#endif

int main(){
   int array[]={0,1};
   //int array[]={0,1,3,5,6,8,12,17};
   //int array[]={0,1,2,3,4,8,9,11};
   vector<int>stones(array,array+2);
   Solution *s =new Solution;
   cout<<s->canCross(stones)<<endl;


   //unordered_map<int, unordered_set<int>> steps;
   //cout<<steps[1].size()<<endl;  
   return 0;
}
