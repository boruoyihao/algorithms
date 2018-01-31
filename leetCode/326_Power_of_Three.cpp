/**
 *Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 *
 *
 * */

#include "common.h"

using namespace std;


class Solution {

public:

    bool isPowerOfThree(int n) {
		return fmod(log10(n)/log10(3),1)==0;
    }

};

int main(){
	Solution *s=new Solution;
	cout<<s->isPowerOfThree(3)<<endl;
	return 0;
}
