#include<bits/stdc++.h>
using namespace std;

int main(){
	int n,q; cin>>n>>q;
	vector<long long> v;
	v.push_back(0);
	while(n--){
		long long cur; cin>>cur;
		cur += v.back();
		v.push_back(cur);
	}
	while(q--){
		int l,r; cin>>l>>r;
		cout<<v[r] - v[l-1]<<endl;
	}
}