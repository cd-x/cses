#include "bits/stdc++.h"
using namespace std;

int main(){
	int n; cin>>n;
	int arr[n];
	for(int i=0;i<n;i++)
		cin>>arr[i];
	sort(arr,arr+n);
	long int result = 0;
	int val = arr[n/2];
	for(int i=0;i<n;i++)
		result+= abs(arr[i]-val);
	cout<<result;
}