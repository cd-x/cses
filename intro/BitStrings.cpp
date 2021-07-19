#include <bits/stdc++.h>

using namespace std;

int main(){

	int n; cin>>n;
	long long int res = 1;
	while(n--){
	 res = (res*2)%int(1e9+7); 
	}
	cout<<res;
}