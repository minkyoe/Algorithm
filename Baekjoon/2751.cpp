#include <iostream>
#define MAX 1000001

using namespace std;

int main(){
    ios_base::sync_with_stdio;
    
    int count=0;
    cin>>count;
    int tempCount = count;

    int array[MAX] = {-1};

    // 배열 채워넣기
    for(int i=1; i<=count; i++){
        cin>>array[i];
    }

    // 수 비교하여 정렬하기
    for(int l=1; l<=tempCount; l++){
        count = tempCount;
        for(int k=l; k<count; --count){
            if(array[l]>array[count]) {
                int temp = array[l];
                array[l] = array[count];
                array[count] = temp;
            }
        }
    }


    // 배열 출력하기
    for(int j=1; j<=tempCount; j++){
        cout<<array[j]<<"\n";
    }

    return 0;

}