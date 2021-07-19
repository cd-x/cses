#include "bits/stdc++.h"

using namespace std;

int main(){

	int n,m,k; cin>>n>>m>>k;
	int a[n],s[m];
	for(int i=0;i<n;i++)
		cin>>a[i];
	for(int i=0;i<m;i++)
		cin>>s[i];

	sort(a,a+n); sort(s,s+m);

	int result = 0;

	int i=0,j=0;
	while(i<m && j<n){
		if(s[i]>=a[j]-k && s[i]<= a[j]+k){
			result++;
			i++,j++;
		}
		else if(s[i]>a[j]+k) j++;
		else i++;
	}
	cout<< result;
}