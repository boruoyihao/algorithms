/*
 *
 *Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

Subscribe to see which companies asked this question.

Show Tags
Show Similar Problems

 *
 *
 **/

#include "common.h"

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
    Trie*trie=new Trie;
	trie->insert("abc");
	trie->insert("abcd");
	trie->insert("a");
	trie->insert("abde");
	cout<<trie->search("ab")<<endl;
	cout<<trie->startsWith("ab")<<endl;
	cout<<trie->search("abc")<<endl;
	cout<<trie->startsWith("abdef")<<endl;
	cout<<trie->search("b")<<endl;
	return 0;
}
