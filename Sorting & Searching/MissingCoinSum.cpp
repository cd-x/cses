#include "bits/stdc++.h"

using namespace std;

int main(){

	int n; cin>>n;
	vector<int> v; 
	for(int i=0;i<n;i++){
		int tmp; cin>>tmp;
		v.push_back(tmp);
	}

	sort(begin(v),end(v));


	long int curSum = 0;
	for(int curElement: v){
		//cout<<curSum<<" "<<curElement<<endl;
		if(curElement > curSum + 1)
			break;
		curSum += curElement;
	}

	cout<<curSum+1;
}