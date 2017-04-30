#include<iostream>
#include<vector>
using namespace std;



void printArray(vector<vector<int>>&array){
	for(int i=0;i<array.size();i++){
		for(int j=0;j<array[i].size();j++){
			cout<<array[i][j]<<" ";
		}
		cout<<endl;
	}
}

void solve(vector<vector<int>>&array,int N,int M,int index,int i,int j){
	if(index>M){
		return;
	}
	while(j+1<N&&array[i][j+1]==0&&index<M){
		array[i][j+1]=1;
		j++;
		index++;
	}
    if(index==M){
		cout<<i+1<<" "<<j+1<<endl;
		return;		
	}
	//printArray(array);
	while(i+1<N&&array[i+1][j]==0&&index<M){
		array[i+1][j]=1;
		i++;
		index++;
	}
	if(index==M){
        cout<<i+1<<" "<<j+1<<endl;
        return;
    }

	while(j-1>=0&&array[i][j-1]==0&&index<M){
		array[i][j-1]=1;
		j--;
		index++;
	}
   if(index==M){
        cout<<i+1<<" "<<j+1<<endl;
        return;
    }

	while(i-1>=0&&array[i-1][j]==0&&index<M){
		array[i-1][j]=1;
		i--;
		index++;
	}
    if(index==M){
        cout<<i+1<<" "<<j+1<<endl;
        return;
    }

	solve(array,N,M,index,i,j);
}
int main(){

	int N,M;
	cin>>N>>M;
	vector<vector<int>>array(N,vector<int>(N,0));
	solve(array,N,M,0,0,-1);
	return 0;
}
