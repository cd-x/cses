#include "bits/stdc++.h"

using namespace std;

int main(){
	int n; cin>>n;
	long int arr[n];

	for(int i=0;i<n;i++)
		cin>>arr[i];
	long int result = arr[0];
	for(int i=1;i<n;i++){
		arr[i] = max(arr[i],arr[i]+arr[i-1]);
		result = max(result,arr[i]);
	}
	cout<<result;
}