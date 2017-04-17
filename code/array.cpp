#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;



/*求一个数组连续最大的数,非DP算法*/
int getSeries(vector<int>&v){
   if(v.size()==0){
     return 0;
   }
   int sum=v[0];
   int max=v[0];
   for(int i=1;i<v.size();i++){
     if(sum+v[i]>0){
        sum+=v[i];
     }else{
        sum=v[i];
     }
     if(max<sum){
        max=sum;
     }
   }
   return max;
}


/*求一个数组连续最大的数，DP算法*/
int getSeriesDP(vector<int>&v){
    if(v.size()==0){
       return 0;
    }
    vector<int>status(v.begin(),v.end());
    status[0]=v[0];
    for(int i=1;i<v.size();i++){
       if(status[i-1]<0){
           status[i]=v[i];
       }else{
           status[i]=v[i]+status[i-1];
      }
    }
    int max=status[0];
    for(int i=1;i<status.size();i++){
       max=max>status[i]?max:status[i];
    }
    
    return max;
}



int main(){
   int array[]={-9,3,1,-5,4,6,2,-10};
   vector<int> v(array,array+8);
   cout<<getSeriesDP(v)<<endl;
   return 0;
}
