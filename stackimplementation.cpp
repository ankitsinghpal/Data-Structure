#include <iostream>
using namespace std;

int top=-1;
void push(int arr[], int x, int n)
{
    if(top==n-1)	//full
    {
        cout<<"\nstack ful"<<top;
    }
    else 
    {
        top=top+1;
        arr[top]=x;
    }
}

void pop()
{
    if(top==-1) cout<<"\nEmpty Stack";
    else top=top-1;
}
int size()
{
    return top+1;
}
int main() {
	int n;
	cin>>n;
	
	int arr[n];
	push(arr,20,n);
	push(arr,30,n);
	push(arr,40,n);
	push(arr,50,n);
	cout<<size()<<endl;
	pop();
	cout<<size();
	return 0;
}
