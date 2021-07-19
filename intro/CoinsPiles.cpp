#include<bits/stdc++.h>

using namespace std;

int main(){

	int t; cin>>t;
	while(t--){
		long int a,b; cin>>a>>b;
		bool possible=true;
		while(possible and a>0 and b>0){
			if(b>a) swap(a,b);
			cout<<a<<" "<<b<<endl;
			if(b<a/2) possible =false;
			b-=a/2;
			a-=2*(a/2);
		}
		if(!possible or a or b)
			cout<<"NO";
		else
			cout<<"YES";
		cout<<endl;
	}
}