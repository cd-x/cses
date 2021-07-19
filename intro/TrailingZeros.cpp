#include<bits/stdc++.h>

using namespace std;

int main(){
	int n; cin>>n;

	int res =0;
	while(n>0){
		int tmp =n;
		while(tmp>0 and tmp%10 == 0){
			res++;
			tmp/=10;
		}
		while(tmp>0 and tmp%5 == 0){
			res++;
			tmp/=5;
		}
		n--;
	}
	cout<<res;
}