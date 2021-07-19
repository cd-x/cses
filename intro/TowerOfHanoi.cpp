#include <bits/stdc++.h>

using namespace std;

void printMoves(int n,int source,int spare,int dest){
	if(n==1){
		cout<<source<<" "<<dest<<endl;
		return;
	}
	printMoves(n-1,source,dest,spare);
	cout<<source<<" "<<dest<<endl;
	printMoves(n-1,spare,source,dest);
}

int main(){
	int n; cin>>n;
	long int total = 1<<n;
	cout<<total-1<<endl;
	printMoves(n,1,2,3);
}