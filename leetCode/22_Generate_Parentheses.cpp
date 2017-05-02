#include "common.h"

/**
 *Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 *
 * */



class Solution {

public:

    vector<string> generateParenthesis(int n) {
		vector<string>result;
		if(0==n){
			return result;
		}
        generateParenthesis(result,"",n,n);
		return result;
    }

	void generateParenthesis(vector<string>&result,string str,int left,int right){
		if(0==left&&0==right){
			result.push_back(str);
		}

		if(left>0){
			generateParenthesis(result,str+"(",left-1,right);
		}

		if(right>0&&right>left){
			generateParenthesis(result,str+")",left,right-1);
		}
	}

};
int main(){
	Solution *s =new Solution;
	vector<string>result=s->generateParenthesis(3);
	printVector1(result);
	return 0;
}
