/**
 *Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples:
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 *
 *
 * */

#include "common.h"
using namespace std;



class Solution {

	public:

		vector<string> addOperators(string num, int target) {

			vector<string> result;
			getOperators(num,0,target,result,"",0,'#',0);
			sort(result.begin(),result.end());
			return result;

		}

		void getOperators(string&num,int index,int target,vector<string>&result,string str,long sum,char preOp,long preNo){
	        if(index>num.size()){
				return;
			}
			
			if(target==sum&&index==num.size()){
				result.push_back(str);
			}

			for(int i=index;i<num.size();i++){
			  string s=num.substr(index,i-index+1);
              long cur=stol(s);
			  string curStr=to_string(cur);
			  if(curStr.size()!=s.size()){
			  	continue;
			  }

			  if(index==0){
                getOperators(num,i+1,target,result,curStr,cur,'#',cur);
                continue;
              }

			  getOperators(num,i+1,target,result,str+"+"+curStr,sum+cur,'+',cur);//+
			  getOperators(num,i+1,target,result,str+"-"+curStr,sum-cur,'-',cur);//-
			  getOperators(num,i+1,target,result,str+"*"+curStr,preOp=='-'?sum+preNo-cur*preNo:preOp=='+'?sum-preNo+cur*preNo:preNo*cur,preOp,preNo*cur);//*
			}
		}

};



int main(){
	Solution s;
	vector<string>result=s.addOperators("123456789",45);
	printVector1(result);
	//string str="zhaolizhen";
	//cout<<str.substr(1,2)<<endl;
	//cout<<atoi("12")+1<<endl;
	return 0;
}
