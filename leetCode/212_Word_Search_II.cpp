/**
 *
 *Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
 *
 *
 * */

#include "common.h"


#if 0
//706ms too  no trie
class Solution {

public:

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {

  		set<string>resultSet;
        sort(words.begin(),words.end());

		for(int k=0;k<words.size();k++){
		    if(k-1>=0&&words[k]==words[k-1]){
				continue;
			}
		  for(int i=0;i<board.size();i++){
			  for(int j=0;j<board[i].size();j++){
				if(words[k][0]==board[i][j]){
				    bool flag=findWords(board,i,j,words[k],0);
					if(flag){
						resultSet.insert(words[k]);
					}
				}
			  }
		  }
		}

		vector<string>result(resultSet.begin(),resultSet.end());
        return result;		

    }

	//DFS
	bool findWords(vector<vector<char>> &board,int i,int j,const string& word,int index){
		if(i<0||i>=board.size()||j<0||j>=board[0].size()||index>=word.size()||word[index]!=board[i][j]){
			return false;
		}

        if(word[index]==board[i][j]&&index==word.size()-1){
			return true;
		}
		char temp=board[i][j];
		board[i][j]='-';
		bool flag= findWords(board,i-1,j,word,index+1)||findWords(board,i+1,j,word,index+1)||findWords(board,i,j-1,word,index+1)||findWords(board,i,j+1,word,index+1);
		board[i][j]=temp;
		return flag;
	}

};
#endif

struct TrieNode{
	char value;
    TrieNode * next[26];
	int status;//status=1表示中间节点，status=2表示叶子节点
	TrieNode(){
		status=1;
		for(int i=0;i<26;i++){
			next[i]=NULL;
		}
	}
};

class Trie {


private:
	TrieNode *root;
public:
    Trie() {
        root=new TrieNode();
    }
    void insert(string word) {

		TrieNode*p=root;
		for(int i=0;i<word.size();i++){
			int index=word[i]-'a';
			if(p->next[index]!=NULL){
				p=p->next[index];
			}else{
		        TrieNode*tempNode=new TrieNode();
                tempNode->value=word[i];
                p->next[index]=tempNode;
                p=tempNode;
			}
		}        

		if(NULL!=p){
			p->status=2;
		}
    }

    bool search(string word) {

		TrieNode*p=getNode(word);
		return p!=NULL&&p->status==2?true:false;
    }

    bool startsWith(string prefix) {
		TrieNode *p=getNode(prefix);
		return p!=NULL?true:false;	
    }

	TrieNode * getNode(string prefix){
		if(prefix.size()==0){
			return NULL;
		}
		TrieNode*p=root;
		int i=0;
        for(;i<prefix.size();i++){
            p=p->next[prefix[i]-'a'];
            if(p==NULL)
                break;
        }
	   return p; 	
	}

};

int main(){
  char array[][4]={
	  {'o','a','a','n'},
	  {'e','t','a','e'},
	  {'i','h','k','r'},
	  {'i','f','l','v'}
  };

  vector<vector<char>> board(4,vector<char>(4));

  for(int i=0;i<board.size();i++){
  	for(int j=0;j<board[i].size();j++){
		board[i][j]=array[i][j];
	}
  }
  

  string str[]={"oath","pea","eat","rain","iiet","iiet"};
  vector<string>words(str,str+6);
  Solution s;
  vector<string> result=s.findWords(board,words);
  printVector1(result);
  return 0;
}
