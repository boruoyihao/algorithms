#include "common.h"
#if 0
//TLE
class Solution {
public:
    bool isMatch(string s, string p) {
		return isMatch(s,0,p,0);
	}
	bool isMatch(string s,int sIndex,string p,int pIndex){
		if(sIndex==s.size()&&pIndex==p.size()){
			return true;
		}
	    if(p[pIndex]=='*'){
			while(pIndex<p.size()&&p[pIndex+1]=='*'){
				pIndex++;
			}
			if(isMatch(s,sIndex,p,pIndex+1)){
				return true;
			}
			return sIndex!=s.size()&&isMatch(s,sIndex+1,p,pIndex);
		}	
		else if(s[sIndex]==p[pIndex]||p[pIndex]=='?'){
			return sIndex!=s.size()&&pIndex!=p.size()&&isMatch(s,sIndex+1,p,pIndex+1);
		}
		return false;
	}

};
#endif

#if 1
class Solution {

public:

    bool isMatch(string s, string p) {      
	    int m=s.size();
	    int n=p.size();
	    int i=0,j=0;
		int memi=-1,memj=-1;
		while(i<m){
			if(s[i]==p[j]||p[j]=='?'){
				i++,j++;
			}else if(p[j]=='*'){
				memi=i;
				memj=j++;
			}else if(memj!=-1){
				i=memi+1;
				j=memj;
			}else{
				return false;
			}
		}
		
		while(j<n&&p[j]=='*'){
			j++;
		}
		return j==p.size();
    }

};
#endif

#if 0
class Solution {
public:
    bool isMatch(string s, string p) {
        int m = s.length(), n = p.length();
        int i = 0, j = 0, asterisk = -1, match;
        while (i < m) {
            if (j < n && p[j] == '*') {
                match = i;
                asterisk = j++;
            }
            else if (j < n && (s[i] == p[j] || p[j] == '?')) {
                i++;
                j++;
            }
            else if (asterisk >= 0) {
                i = ++match;
                j = asterisk + 1;
            }
            else return false;
        }
        while (j < n && p[j] == '*') j++;
        return j == n;
    }
};
#endif
int main(){
    Solution*s=new Solution;
	cout<<(s->isMatch("abcded","*")==true)<<endl;
    cout<<(s->isMatch("aa","aa")==true)<<endl;
	cout<<(s->isMatch("aa","a")==false)<<endl;
	cout<<(s->isMatch("aaa","aa")==false)<<endl;
	cout<<(s->isMatch("aa","a*")==true)<<endl;
	cout<<(s->isMatch("aa","*")==true)<<endl;
	cout<<(s->isMatch("ab","?*")==true)<<endl;
	cout<<(s->isMatch("aab","c*a*b")==false)<<endl;
	cout<<(s->isMatch("zacabz","*a?b*")==false)<<endl;
	cout<<(s->isMatch("b","*?*?")==false)<<endl;
	cout<<(s->isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","a*******b"))<<endl;
	return 0;
}
