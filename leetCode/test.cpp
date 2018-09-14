#include "common.h"



void testStack(){
    cout<<"test stack"<<endl;
    stack<int>s;
    for(int i=0;i<10;i++){
    	s.push(i);
    }
    
    while(!s.empty()){
        int data=s.top();
        cout<<data<<" ";
        s.pop();   
    }
    cout<<endl;
}


void testQueue(){
   cout<<"test queue"<<endl;
   queue<int>q;
   for(int i=0;i<10;i++){
      q.push(i);
   }

  while(!q.empty()){
  
     int data=q.front();
     cout<<data<<" ";
     q.pop();
  }

  cout<<endl;
}

void testList(){

  cout<<"test list"<<endl;
  list<int>lst;

  for(int i=0;i<10;i++){
     lst.push_back(i);
  }

  for(list<int>::iterator iter=lst.begin();iter!=lst.end();iter++){
     cout<<*iter<<" "; 
  }

  cout<<endl;
}


void testDeque(){
    cout<<"dequeue"<<endl;
    deque<int>q;
    for(int i=0;i<10;i++){
       q.push_back(i);
       q.push_front(i*i); 
    }

   for(deque<int>::iterator iter=q.begin();iter!=q.end();iter++){
      cout<<*iter<<" ";
  }
  cout<<endl;
}


void testMap(){
   cout<<"map"<<endl;
   map<int,int>m;
   for(int i=0;i<10;i++){
      m.insert(pair<int,int>(i,i*i));
   }

   for(map<int,int>::iterator iter=m.begin();iter!=m.end();iter++){
       cout<<iter->first<<"="<<iter->second<<"&";
   }
   cout<<endl;
}

int main(){
   testStack();

   testQueue();

   testList();

   testDeque();

   testMap();
}
