#include <bits/stdc++.h>

using namespace std;


void solve(){
	int n, q; cin>>n>>q;
	vector<vector<int>> dp(n+1,vector<int>(n+1,0));
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			char ch; cin>>ch;
			dp[i][j] = ch=='*';
		}
	}

	

	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			dp[i][j] += dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
		}
	}

	// for(int i=0;i<=n;i++){
	// 	for(int j=0;j<=n;j++)
	// 		cout<<dp[i][j]<<" ";
	// 	cout<<endl;
	// }

	while(q--){
		int y1,x1,y2,x2;
		cin>>y1>>x1>>y2>>x2;
		cout<<dp[y2][x2] - dp[y2][x1-1] - dp[y1-1][x2] + dp[y1-1][x1-1]<<endl;
	}
}

int main(){
	solve();
	return 0;
}