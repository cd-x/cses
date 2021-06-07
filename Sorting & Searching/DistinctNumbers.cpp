#include "bits/stdc++.h"

using namespace std;

int main(){

	int n; cin>>n;
	set<int> uset;
	for(int i=0;i<n;i++){
		int tmp; cin>>tmp;
		uset.insert(tmp);
	}
	cout<<uset.size();
}