#include <bits/stdc++.h>

using namespace std;

int main(){
	int n; cin>>n;
	vector<bool> v(n,false);
	for(int i=0;i<n-1;i++){
		int tmp; cin>>tmp;
		v[tmp-1] = true;
	}
	for (int i = 0; i < n; ++i)
	{
		if(v[i] == false){
			cout<<i+1;
			break;
		}
	}
}