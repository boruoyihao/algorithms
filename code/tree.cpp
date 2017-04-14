#include<iostream>
#include<stack>
#include<queue>
#include<string>
#include<vector>
using namespace std;

struct Node{
	int value;
	Node*left;
	Node*right;
};

/*层序打印二叉树*/
void levelOrder(Node *root){
	if(NULL==root){
		return;
	}

	queue<Node*>q;
	q.push(root);
	while(!q.empty()){
		Node*temp=q.front();
		q.pop();
		cout<<temp->value<<" ";
		if(NULL!=temp->left){
			q.push(temp->left);
		}

		if(NULL!=temp->right){
			q.push(temp->right);
		}
	}
}

/*可以标记每一行的层序遍历*/
void levelOrderWithCursor(Node *root){
	if(NULL==root){
		return;
	}
	queue<Node*>q1;
	queue<Node*>q2;
	q1.push(root);
	int i=0;//每一层标号
	while(!q1.empty()){
		i++;
		cout<<"the "<<i<<" level:";
		while(!q1.empty()){
			Node*temp=q1.front();
			cout<<temp->value<<" ";
			q1.pop();
			if(NULL!=temp->left){
				q2.push(temp->left);
			}
			if(NULL!=temp->right){
				q2.push(temp->right);
			}
		}

		while(!q2.empty()){
			q1.push(q2.front());
			q2.pop();
		}
	}
}


/*先序打印二叉树*/
void preOrder(Node*root){
	if(NULL==root){
		return ;
	}

	cout<<root->value<<" ";
	preOrder(root->left);
	preOrder(root->right);
}

/*中序打印二叉树*/
void inOrder(Node*root){
	if(NULL==root){
		return;
	}
	inOrder(root->left);
	cout<<root->value<<" ";
	inOrder(root->right);
}

/*非递归的中序打印二叉树*/
void inOrderNotRecursion(Node *root){
	if(NULL==root){
		return;
	}
	stack<Node*>s;
	s.push(root);
	bool flag=true;
	while(!s.empty()){
		Node*p=s.top();
		while(p->left&&flag){
			s.push(p->left);
			p=p->left;
		}
		flag=false;
		p=s.top();
		s.pop();
		cout<<p->value<<" ";
		if(p->right){
			flag=true;
			s.push(p->right);
		}
	}
}

/*后序打印二叉树*/
void postOrder(Node*root){
	if(NULL==root){
		return;
	}
	postOrder(root->left);
	postOrder(root->right);
	cout<<root->value<<" ";
}


/*非递归的后序遍历二叉树*/
void postOrderNotRecursion(Node*root){
	if(NULL==root){
		return;
	}

	stack<Node*>s;
	s.push(root);
	bool flag=true;
	Node*pre=NULL;
	while(!s.empty()){
		Node*p=s.top();
		while(p->left&&flag){
			s.push(p->left);
			p=p->left;
		}
		flag=false;
		p=s.top();
		if(p->right&&p->right!=pre){
			flag=true;
			s.push(p->right);
		}else{
			s.pop();
			pre=p;
			cout<<p->value<<" ";
		}


	}
}


/*创建二叉树*/
Node* createTree(){
	int value;
	cin>>value;
	Node *node=NULL;
	if(value!=-1){
		node=new Node;
		node->value=value;
	}else{
		return node;
	}
	node->left=createTree();
	node->right=createTree();
	return node;
}

/*二叉树树高*/
int height(Node*root){
	if(NULL==root){
		return 0;
	}

	int left=height(root->left)+1;
	int right=height(root->right)+1;
	return left>right?left:right;
}

/*二叉树节点数*/
int noOfNode(Node * root){
	if(NULL==root){
		return 0;
	}
	int left=noOfNode(root->left);
	int right=noOfNode(root->right);
	return left+right+1;
}
/*二叉树叶子节点数*/
int noOfLeaftNode(Node *root){
	if(NULL==root){
		return 0;
	}

	if(NULL==root->left&&NULL==root->right){
		return 1;
	}

	int left=noOfLeaftNode(root->left);
	int right=noOfLeaftNode(root->right);
	return left+right;
}
/*二叉树非叶子节点数*/
int noOfNotLeafNode(Node*root){
	if(NULL==root){
		return 0;
	}

	if(NULL==root->left&&NULL==root->right){
		return 0;
	}


	int left =noOfNotLeafNode(root->left);
	int right=noOfNotLeafNode(root->right);
	return left+right+1;
}

/*拷贝一颗二叉树*/
Node * copy(Node *root){
	if(NULL==root){
		return NULL;
	}
	Node*node=new Node;
	node->value=root->value;

	node->left=copy(root->left);
	node->right=copy(root->right);
	return node;
}

/*二叉树镜像*/
void mirror(Node * root){
	if(NULL==root){
		return ;
	}

	Node * temp=root->left;

	root->left=root->right;
	root->right=temp;

	mirror(root->left);
	mirror(root->right);
}

/*根据数组建立一颗二叉搜索树*/

Node * buildBST(const vector<int>& v){
	Node * root=NULL;
	for(int i=0;i<v.size();i++){
		Node * temp=new Node;
		temp->value=v[i];
		temp->left=NULL;
		temp->right=NULL;
		if(i==0){
			root=temp;
		}else{
			Node*q=root;
			Node *pre=NULL;
			while(q){
				pre=q;
				if(q->value<=temp->value){
					q=q->right;
				}else if(q->value>temp->value){
					q=q->left;
				}
			}
			if(pre->value<=temp->value){
				pre->right=temp;
			}else{
				pre->left=temp;
			}
		}
	}

	return root;
}

void getResultPath(Node*root,vector<vector<int>>&result,vector<int>v,int sum,const int target);
/*二叉树中和为某一值的路径*/
vector<vector<int>> getPath(Node *root,const int target){
	vector<vector<int>>result;
	if(NULL==root){
		return result;
	}
	vector<int>buffer;
	int sum=0;
	getResultPath(root,result,buffer,sum,target);
	return result;
}

void getResultPath(Node*root,vector<vector<int>>&result,vector<int>v,int sum,const int target){
	if(NULL==root){
		return;
	}
	v.push_back(root->value);
	sum+=root->value;
	if(sum==target){
		result.push_back(v);
	}
	getResultPath(root->left,result,v,sum,target);
	getResultPath(root->right,result,v,sum,target);
}

void printVecotr(const vector<vector<int>>&v){
	for(int i=0;i<v.size();i++){
		for(int j=0;j<v[i].size();j++){
			cout<<v[i][j]<<" ";
		}
		cout<<endl;
	}
}
Node * buildChildTree(const vector<int>&preOrderVector,int start1,int end1,const vector<int>&inOrderVector,int start2,int end2);
/*根据中序遍历和先序遍历数组，确定一颗二叉树*/
Node*buildTree(const vector<int>& preOrderVector,const vector<int>& inOrderVector){
	if(preOrderVector.size()==0||inOrderVector.size()==0||preOrderVector.size()!=inOrderVector.size())	{
		return NULL;
	}
	return buildChildTree(preOrderVector,0,preOrderVector.size()-1,inOrderVector,0,inOrderVector.size()-1);
}

Node * buildChildTree(const vector<int>&preOrderVector,int start1,int end1,const vector<int>&inOrderVector,int start2,int end2){
	if(start1<0||start1>end1||end1>=preOrderVector.size()||start2<0||start2>end2||end2>=inOrderVector.size()){
		return NULL;
	}
	int rootData=preOrderVector[start1];
	Node*root=new Node;
	root->value=rootData;
	root->left=NULL;
	root->right=NULL;
	int i=start2;
	for(;i<=end2;i++){
		if(rootData==inOrderVector[i]){
			break;
		}
	}

	root->left=buildChildTree(preOrderVector,start1+1,i-start2+start1,inOrderVector,start2,i-1);
	root->right=buildChildTree(preOrderVector,i-start2+start1+1,end1,inOrderVector,i+1,end2);
	return root;
}


/*二叉树转化成双向链表*/
void convertTree2LinkedList(Node *root,Node*&p){
	if(NULL==root){
		return ;
	}

	convertTree2LinkedList(root->left,p);
	if(p==NULL){
		p=root;
		p->left=NULL;
	}else{
		root->left=p;
		p->right=root;
		p=root;
	}
	convertTree2LinkedList(root->right,p);
}

Node* convertTree2LinkedListMain(Node *root){
	if(NULL==root){
		return NULL;
	}

	Node * head=NULL;
	convertTree2LinkedList(root,head);
	while(head->left){
		head=head->left;
	}
	return head;
}

/*打印链表*/
void printLink(Node*head){
	while(head){
		cout<<head->value<<" ";
		head=head->right;
	}
}



int main(){
#if 1
	Node*root=createTree();
	cout<<"preOrder:\n";
	preOrder(root);
	cout<<endl;
	cout<<"inOrder:\n";
	inOrder(root);
	cout<<endl;
	cout<<"inOrderNotRecursion:\n";
	inOrderNotRecursion(root);
	cout<<endl;
	cout<<"postOrder:\n";
	postOrder(root);
	cout<<endl;
	cout<<"postOrderNotRecursion:\n";
	postOrderNotRecursion(root);
	cout<<endl;
	cout<<"levelOrder:\n";
	levelOrder(root);
	cout<<endl;
	cout<<"levelOrderWithCursor:\n";
	levelOrderWithCursor(root);
	cout<<endl;
	cout<<"height:"<<height(root);
	cout<<endl;
	cout<<"noOfNode:"<<noOfNode(root);
	cout<<endl;
	cout<<"noOfLeaftNode:"<<noOfLeaftNode(root);
	cout<<endl;
	cout<<"noOfNotLeafNode:"<<noOfNotLeafNode(root);
	cout<<endl;

	Node * rootcopy=copy(root);
	cout<<"after copy preOrder:\n";
	preOrder(rootcopy);

	cout<<endl;
	mirror(root);
	cout<<"after mirror,inOrder:\n";
	inOrder(root);
	cout<<endl;

	int target=10;
	vector<vector<int>> resultPath=getPath(root,target);
	cout<<"二叉树中和为"<<target<<"的路径：\n";
	printVecotr(resultPath);
	cout<<endl;


#endif
#if 0
	int array[]={3,1,4,2,5,6,0,5,4,10};
	vector<int>v(array,array+10);
	Node *rootBST=buildBST(v);
	cout<<"after build BST,inOrder:\n";
	inOrder(rootBST);
	cout<<endl;
	cout<<"after build BST,preOrder:\n";
	preOrder(rootBST);
	cout<<endl;

	int preOrderArray[]={3,1,0,2,4,5,7};
	int inOrderArray[]={0,1,2,3,4,5,7};
	vector<int>preOrderVector(preOrderArray,preOrderArray+7);
	vector<int>inOrderVector(inOrderArray,inOrderArray+7);
	Node * rootPreIn=buildTree(preOrderVector,inOrderVector);
	cout<<"根据先序、中序遍历构建二叉树后，后序遍历如下：\n";
	postOrder(rootPreIn);
	cout<<endl;

	Node*head=convertTree2LinkedListMain(rootPreIn);
	cout<<"convertTree2LinkedList:\n";
	//cout<<"head:"<<head->value<<endl;
	printLink(head);


#endif
	return 0;
}
