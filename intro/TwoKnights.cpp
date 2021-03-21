#include<bits/stdc++.h>

using namespace std;

/*
The idea is out of all possible options n^2C2
remove all positions where both knights attack
each other. which is nothing but two rectangles
of 3x2 and 2x3 having 2 attacks each. so if we can
count total 3x2 & 2x3 rectangles in nxn matrix,
doubling it will give total attacks.

count(3x2) = (n-1)*(n-2)
count(2x3) = (n-2)*(n-1)
*/

int main(){

	int n; cin>>n;
	cout<<0; // for 1x1 matrix
	for(int i=2;i<=n;i++){
		long long int ixi = 1LL*(i*i)*(i*i-1)/2 - 4LL*(i-1)*(i-2);
		cout<<"\n"<<ixi;
	}
}