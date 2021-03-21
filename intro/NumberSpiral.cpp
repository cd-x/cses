#include <bits/stdc++.h>

using namespace std;

int main(){

	int test; cin>>test;
	while(test--){
		long int row,col; cin>>row>>col;

		long int val=0;
		if(col>=row){
			if(col&1)
				val = col*col - row +1;
			else
				val = (col-1)*(col-1) + row;
		}
		else{
			if(row&1)
				val = (row - 1)*(row - 1) + col;
			else
				val = row*row - col +1;
		}
		cout<<val<<"\n";
	}
}