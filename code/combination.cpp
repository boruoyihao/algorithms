#include<iostream>
#include<vector>
#include<string.h>
#include<string>
#include<cmath>
#include<list>
using namespace std;


/*递归算法-打印字符串的排列*/
void permutation(char * str,char * start){
	if(*start=='\0'){
		cout<<str<<endl;
	}

	char temp;
	for(char * p=start;*p!='\0';p++)	{
		temp=*p;
		*p=*start;
		*start=temp;
		permutation(str,start+1);
		temp=*p;
		*p=*start;
		*start=temp;
	}
}

void swap(char*str,char* i,char* j){
	char temp=*i;
	*i=*j;
	*j=temp;
}

void reverse(char*str,char* start,char* end){
	char* i=start;
	char* j=end;
	while(i<j){
		swap(str,i,j);
		i++,j--;
	}
}

/*非递归算法-求一个组合的下一个组合*/
char* next_permutation(char *str){
	if(NULL==str){
		return NULL;
	}
	char * p=str;
	if(*(p+1)=='\0'){
		return NULL;
	}

	char * end=str+strlen(str);

	char *i=end-1,*ii=end;
	while(true){
		ii--;
		i--;
		if(*i<*ii){
			char*j=end;
			while(!(*i<*(--j)));
			swap(str,i,j);
			reverse(str,ii,end-1);
			break;
		}

		if(i==p){
			//reverse(str,p,end-1);
			//break;
			return NULL;
		}
	}
	return str;
}

void getPermutation(char *str){
	char*p=str;
	while(p!=NULL){
		cout<<p<<" ";
		p=next_permutation(p);
	}
}

/*非递归的组合 缺点是不能避免重复*/
void combination(char * str){
	int length=strlen(str);
	for(int i=1;i<=pow(2,length)-1;i++){
		int data=1;
		for(int j=0;j<length;j++){
			if(i&(data<<j)){
				cout<<str[j];
			}
		}
		cout<<endl;
	}
}

vector<string> combination2(string str){
	int length=str.size();
	vector<string>result;
	for(int i=1;i<=pow(2,length)-1;i++){
		int data=1;
		string strResult="";
		for(int j=0;j<length;j++){
			if(i&(data<<j)){
				strResult+=str[j];
			}
		}
		result.push_back(strResult);
	}
	return result;
}

void combination4(vector<string>&result,string str,string&one,int index,int number){
	if(0==number){
		result.push_back(one);
		return;
	}
	if(index>=str.size()){
		return;
	}
	one.push_back(str[index]);
	combination4(result,str,one,index+1,number-1);
	one.pop_back();

	combination4(result,str,one,index+1,number);
}

/*组合递归实现*/
vector<string> combination3(string str){
	vector<string>result;
	if(str.size()==0){
		return result;
	}

	for(int i=1;i<=str.size();i++){
		string one="";
		combination4(result,str,one,0,i);
	}
	return result;
}

void findSumM3(int M,int N,vector<vector<int> >&result,vector<int>&v){
	if(M<=0||N<=0){
		return;
	}
	if(N==M){
		v.push_back(N);
		result.push_back(v);
		v.pop_back();
	}

	v.push_back(N);
	findSumM3(M-N,N-1,result,v);
	v.pop_back();
	findSumM3(M,N-1,result,v);
}

void findSumM2(int M,int N,vector<vector<int> >&result,vector<int>&v){
	if(M<0||N<0){
		return;
	}
	if(0==M){
		result.push_back(v);
		return;
	}

	v.push_back(N);
	findSumM2(M-N,N-1,result,v);
	v.pop_back();
	findSumM2(M,N-1,result,v);
}


/*从N个数中找出和等于M的数*/
vector<vector<int> > findSumM(int M,int N){
	vector<vector<int> >result;
	vector<int>v;
	findSumM2(M,N,result,v);
	return result;
}

list<int> list1;
void find_factor(int sum,int n)
{
	//递归出口
	if(n<=0||sum<=0)
		return;
	//输出找到的数
	if(sum==n)
	{
		list1.reverse();
		for(list<int>::iterator iter=list1.begin();iter!=list1.end();iter++)
			cout<<*iter<<"+";
		cout<<n<<endl;
		list1.reverse();
	}
	list1.push_front(n);
	find_factor(sum-n,n-1);//n放在里面
	list1.pop_front();
	find_factor(sum,n-1);//n不放在里面
}



/*递归-八皇后问题*/
int sum=0;
template<typename T>
void printVector(vector<vector<T> >&v){
	for(int i=0;i<v.size();i++){
		for(int j=0;j<v[i].size();j++){
			cout<<v[i][j]<<" ";
		}
		cout<<endl;
	}
	sum++;
}

bool valid(int i,int j,vector<bool>&rowStatus,vector<bool>&obliqueStatus,vector<bool>&obliqueStatus1,int length){
	if(rowStatus[j]||obliqueStatus[i+j]||obliqueStatus1[length-1-i+j]){
		return false;
	}
	return true;
}

void printNQueue(vector<vector<char> >&board,int i,vector<bool>&rowStatus,vector<bool>&obliqueStatus,vector<bool>&obliqueStatus1){
	if(i==board.size()){
		printVector(board);
		cout<<endl;
	}

	for(int j=0;j<board.size();j++){
		if(valid(i,j,rowStatus,obliqueStatus,obliqueStatus1,board.size())){
			board[i][j]='Q';
			rowStatus[j]=true;
			obliqueStatus[i+j]=true;
			obliqueStatus1[board.size()-1-i+j]=true;
			printNQueue(board,i+1,rowStatus,obliqueStatus,obliqueStatus1);
			obliqueStatus[i+j]=false;
			rowStatus[j]=false;
			obliqueStatus1[board.size()-1-i+j]=false;
			board[i][j]='*';
		}
	}
}

/*非递归-八皇后问题*/
void printQueue(int n){
	vector<vector<char> > board(n,vector<char>(n,'*'));
	if(n<=3){
		return;
	}

	vector<bool>rowStatus(n,false);
	vector<bool>obliqueStatus(2*n-1,false);
	vector<bool>obliqueStatus1(2*n-1,false);
	printNQueue(board,0,rowStatus,obliqueStatus,obliqueStatus1);
}
int main(){
#if 0
	char str[]="aaab";
	char *p=str;
	permutation(str,p);
	char * result=next_permutation(str);
	cout<<"next_permutation:"<<result<<endl;

	char str1[]="aaab";
	cout<<"getPermutation:\n";
	getPermutation(str1);
	cout<<endl;


	char str2[]="abc";
	combination(str2);

	vector<string>vv=combination2("abc");
	for(int i=0;i<vv.size();i++){
		cout<<vv[i]<<" ";
	}
	cout<<endl;

	cout<<"递归的组合实现：\n";
	vector<string>vvv=combination3("aac");
	for(int i=0;i<vvv.size();i++){
		cout<<vvv[i]<<" ";
	}
	cout<<endl;

	cout<<"从N个数中找出几个数相加=M:\n";
	vector<vector<int>>vvvv=findSumM(10,5);
	for(int i=0;i<vvvv.size();i++){
		for(int j=0;j<vvvv[i].size();j++){
			cout<<vvvv[i][j]<<" ";
		}
		cout<<endl;
	}

	find_factor(10,5);

	vector<vector<int>> tmp(3,vector<int>(3,-1));
	for(int i=0;i<tmp.size();i++){
		for(int j=0;j<tmp[i].size();j++){
			cout<<tmp[i][j]<<" ";
		}
		cout<<endl;
	}
#endif

	printQueue(13);
	cout<<"sum="<<sum<<endl;
	return 0;
}
