#include "bits/stdc++.h"
 
using namespace std;
 
typedef long long ll;
 
int main() {
	int q; cin>>q;
	while(q--){
	  ll k,base=1,count=9,digits=1;
	  cin >> k;
	  while(k > digits*count) {
	    k -= digits*count;
	    digits++;  // digits in each span
	    count*=10; // total numbers in one span
	    base*=10; // lower bound
	  }
	  base += (k-1)/digits;
	 
	  cout << to_string(base)[int((k-1)%digits)]<<"\n";
 	}
}