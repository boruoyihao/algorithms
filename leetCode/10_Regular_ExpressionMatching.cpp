#include "common.h"

/**
 *Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 *
 */

class Solution {

	public:

		bool isMatch(string s, string p) {
			return isMatch(s,0,p,0);
		}
		bool isMatch(string&s,int sIndex,string&p,int pIndex){
			if(s.size()<=sIndex&&pIndex>=p.size()){
				return true;
			}

            
			if(pIndex+1<p.size()&&p[pIndex+1]=='*'){
				if(isMatch(s,sIndex,p,pIndex+2)){
					return true;
				}
				if(p[pIndex]=='.'){
					return sIndex!=s.size()&&isMatch(s,sIndex+1,p,pIndex);
				}
				return s[sIndex]==p[pIndex]&&isMatch(s,sIndex+1,p,pIndex);
			}else if(s[sIndex]==p[pIndex]||p[pIndex]=='.'){
				return sIndex!=s.size()&&isMatch(s,sIndex+1,p,pIndex+1);
			}
			return false;
		}
};


int main(){

	Solution *s =new Solution;
	cout<<s->isMatch("aaaaaaaaaaaa","a*c")<<endl;
	return 0;
}
