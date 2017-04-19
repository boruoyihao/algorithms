#include<iostream>

using namespace std;

void swap(int &data1,int &data2){
    int temp=data1;
    data1=data2;
    data2=temp;
}

void printArray(int * array,int start,int end){
   for(int i=start;i<=end;i++){
       cout<<array[i]<<" ";
   }
   cout<<endl;
}

/*快速排序*/
void quickSort(int *array,int start,int end){
   if(start>=end){
      return;
   }
   
   int i=start,j=end;
   int target=array[start];
   while(i<j){
       while(i<j&&target<=array[j]){
           j--;
       }
       if(target>array[j]){
          array[i++]=array[j];
       }
       
      while(i<j&&array[i]<target){
          i++;
      }
      if(array[i]>=target){
         array[j--]=array[i];
      }
   }
   array[i]=target;
   quickSort(array,start,i-1);
   quickSort(array,i+1,end);
}


void heapAdjust(int *array,int index,int length){
   	
}

/*堆排序*/
void heapSort(int *array,int length){
    for(int i=length>>1;i>=0;i--){
         heapAdjust(array,i,length);
    }

    for(int i=length;i>=0;i--){
	swap(array[0],array[i]);
        heapAdjust(array,0,i);
    }
}

int main(){

   int array[]={10,9,8,7,6,10,5,4,3,2,1,10};
   quickSort(array,0,11);
   printArray(array,0,11);
   return 0;
}
