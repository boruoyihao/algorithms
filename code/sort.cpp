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
    while(index*2<length){
       int i=index*2;
       if(i+1<length&&array[i]<array[i+1]){
            i++;
       }
       if(array[index]<array[i]){
	   swap(array[index],array[i]);
           index=i;
       }else{
           break;
        }
   }	
}

/*堆排序*/
void heapSort(int *array,int length){
    for(int i=length>>1;i>=0;i--){
         heapAdjust(array,i,length);
    }

    for(int i=length-1;i>=0;i--){
	swap(array[0],array[i]);
        heapAdjust(array,0,i);
    }
}

void merge(int *sourceArray,int * tempArray,int s1,int e1,int s2,int e2){
     if(s1<0||s2<0||s1>e1||s2>e2){
        return;
     }
     int i=s1,j=s2,k=s1;
     while(i<=e1&&j<=e2){
         if(sourceArray[i]<sourceArray[j]){
               tempArray[k++]=sourceArray[i++];
         }else{
               tempArray[k++]=sourceArray[j++];
         }
     }
     while(i<=e1){
           tempArray[k++]=sourceArray[i++];
     }

    while(j<=e2){
         tempArray[k++]=sourceArray[j++];
   }

    for(int k=s1;k<=e2;k++){
        sourceArray[k]=tempArray[k];
   }
}
void mergeSort(int *sourceArray,int * tempArray,int start,int end){
    if(start>=end){
       return;
    }
   // int middle=(end+start)>>1;
    int middle=start+((end-start)>>1);
    mergeSort(sourceArray,tempArray,start,middle);
    mergeSort(sourceArray,tempArray,middle+1,end);
    merge(sourceArray,tempArray,start,middle,middle+1,end);
}

int main(){

   int array[]={10,9,8,7,6,10,5,4,3,2,1,10};
   //quickSort(array,0,11);
  // heapSort(array,12);
   int temp[12]={0};
   //printArray(temp,0,11);
   mergeSort(array,temp,0,11);
   printArray(array,0,11);
   return 0;
}
