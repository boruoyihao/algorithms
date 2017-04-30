#include<iostream>
#include<string>
#include<map>
using namespace std;

class Solution {

	private:
		char array[62]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
                'v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		map<string,int>m;
		map<int,string>memory;
		string baseUrl;
	public:
		Solution(){
		   baseUrl="http://tinyurl.com/";
		}


		// Encodes a URL to a shortened URL.
		string encode(string longUrl) {
			return getTinyUrl(longUrl);
		}



		// Decodes a shortened URL to its original URL.
		string decode(string shortUrl) {
			int index=shortUrl.find_last_of(baseUrl);
			string shortStr=shortUrl.substr(index+1,shortUrl.size());
			return memory[getNoofTinyUrl(shortStr)];
		}

		//convert
		string convert210bits(unsigned long id){
			unsigned long index=0;
			string result="";
			for(int i=0;i<6;i++){
				index=id%62;
				id=id/62;
				result=array[index]+result;
			}
			return result;
		}

		unsigned long getNoofTinyUrl(string shortUrl){
			unsigned long sum=0;
			for(int i=0;i<shortUrl.size();i++){
			    int bits=shortUrl[i]-'0';
				sum=sum*62+bits;
			}
			return sum;
		}

		string getTinyUrl(string longUrl){
			int size=m.size()+1;
			if(m.find(longUrl)==m.end()){
				m.insert(pair<string,int>(longUrl,size));
				memory.insert(pair<int,string>(size,longUrl));
			}
			return baseUrl+convert210bits(m[longUrl]);
		}


};

// Your Solution object will be instantiated and called as such:

// Solution solution;

// solution.decode(solution.encode(url));


int main(){
	Solution solution;
	string url="https://leetcode.com/problems/design-tinyurl";
	cout<<solution.encode(url)<<endl;
	cout<<solution.decode(solution.encode(url))<<endl;
	return 0;
}
