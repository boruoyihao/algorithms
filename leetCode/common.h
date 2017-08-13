#include<iostream>
#include<list>
#include<map>
//#include<unordered_map>
#include<string>
#include<algorithm>
#include<set>
#include<stack>
#include<queue>
//#include <unordered_map>
//#include <unordered_set>
#include<limits.h>
using namespace std;

template<typename T>
void printVector(vector<vector<T> >&v){
    for(int i=0;i<v.size();i++){
        for(int j=0;j<v[i].size();j++){
            cout<<v[i][j]<<" ";
        }
        cout<<endl;
    }   
}


template<typename T>
void printVector1(vector<T>&v){
	for(int i=0;i<v.size();i++){
		cout<<v[i]<<" ";
	}
	cout<<endl;
}


template<typename T>
void cinVector(vector<vector<T> >&v){

	for(int i=0;i<v.size();i++){
		for(int j=0;j<v[i].size();j++){
			cin>>v[i][j];
		}
	}
}
