#include "bits/stdc++.h"

using namespace std;

int main(){
	int tmp,n,m; cin>>n>>m;

	multiset<int,greater<int>>h;
	while(n--){
		cin>>tmp;
		h.insert(tmp);
	}

	while(m--){
		cin>>tmp;
		auto it = h.lower_bound(tmp);
		if(it == h.end()){
			cout<<-1;
		}
		else{
			cout<<*(it);
			h.erase(it);
		}
		cout<<"\n";
	}
}