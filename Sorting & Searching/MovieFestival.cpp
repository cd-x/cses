#include "bits/stdc++.h"

using namespace std;

int main(){

	int n; cin>>n;
	vector<pair<int,int>>time;
	for(int i=0;i<n;i++){
		int f,s; cin>>f>>s;
		time.push_back({f,s});
	}
	sort(begin(time),end(time),[](auto t1,auto t2){
		if(t1.first == t2.first)
			return t1.second<t2.second;
		return t1.first<t2.first;
	});

	int res=0,outerLimit=0;
	for(auto ele: time){
		if(outerLimit<=ele.first){
			res++;
			outerLimit = ele.second;
		}
	}
	cout<<res;
}