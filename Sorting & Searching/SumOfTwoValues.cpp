#include "bits/stdc++.h"

using namespace std;

int main(){
	int tmp,n,x; cin>>n>>x;
	map<int,int>ump;
	bool found = false;
	for(int i=0;i<n;i++){
		cin>>tmp;
		if(ump.find(x-tmp)!=ump.end()){
			cout<<ump[x-tmp]+1<<" "<<i+1;
			found = true;
			break;
		}
		else{
			ump[tmp]=i;
		}
	}
	if(!found)
		cout<<"IMPOSSIBLE";
}