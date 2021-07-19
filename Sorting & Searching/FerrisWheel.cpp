#include "bits/stdc++.h"

using namespace std;

int main(){
	int n,x; cin>>n>>x;
	int arr[n];
	for(int i=0;i<n;i++)
		cin>>arr[i];
	sort(arr,arr+n,greater<int>());
	int gondola = 0;
	int i=0,j=n-1;
	while(i<j){
		if(arr[i]+arr[j]<=x)
			i++,j--;
		else
			i++;
		gondola++;
	}
	if(i==j) gondola++;
	cout<<gondola;
}