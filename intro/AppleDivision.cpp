#include<bits/stdc++.h>

using namespace std;

int main(){

	int n; cin>>n;
	vector<int> arr;
	long int totalSum =0;
	for(int i=0;i<n;i++){
		int tmp; cin>>tmp;
		arr.push_back(tmp);
		totalSum+=tmp;
	}
	
	long int diff = INT_MAX;
	for(long int i=0;i<(1<<n);i++){
		long int sumPossible = 0;
		for(long int j=0;j<n;j++){
			if(i & (1<<j)) sumPossible+=arr[j];
		}
		diff = min(diff, abs(totalSum- 2*sumPossible));
	}
	cout<<diff;
}