#include<iostream>
#include<map>
#include<string>
using namespace std;

map<string,int>m;
string baseUrl="http://tinyurl.com/";
string convert210bits(unsigned long id){
	char array[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
            'v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	unsigned long index=0;
	string result="";
	for(int i=0;i<6;i++){
	    index=id%62;
		id=id/62;
	    result=array[index]+result;
	}
	return result;
}

string getTinyUrl(string longUrl){
	if(m.find(longUrl)==m.end()){
		m.insert(pair<string,int>(longUrl,m.size()+1));
	}
	return baseUrl+convert210bits(m[longUrl]);
}


int main(){
	string originUrl="https://leetcode.com/problems/design-tinyurl";
	cout<<getTinyUrl(originUrl)<<endl;
	return 0;
}
