#include <bits/stdc++.h>

using namespace std;

int main(){
	string s; cin>>s;

	long int res =0;
	long int i=0;
	while(i<s.length()){
		long int cur = i;
		do{
			i++;
		}while(i<s.length() and s[i]==s[cur]); 
		res = max(res,i- cur);
	}
	cout<<res;
}