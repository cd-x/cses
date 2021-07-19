#include "bits/stdc++.h"

using namespace std;

int main(){
	int n; cin>>n;
	vector<pair<int,bool>>v;
	for(int i=0;i<n;i++){
		int tmp; cin>>tmp;
		v.push_back({tmp,true});
		cin>>tmp;
		v.push_back({tmp,false});
	}

	
	sort(v.begin(),v.end(),
		[](pair<int,bool> p1,pair<int,bool> p2){
			if(p1.first == p2.first)
				return p1.second > p2.second;
			return p1.first < p2.first;
	});


	int result = 0,cur = 0;
	for(pair<int,bool> ele: v){
		if(ele.second)
			cur+=1;
		else
			cur-=1;
		result = max(result,cur);
	}
	cout<<result;
}