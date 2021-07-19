#include "bits/stdc++.h"

using namespace std;
typedef pair<int,int> cell;
unordered_map<char,cell>dir={
	{'U',{0,1}},
	{'D',{0,-1}},
	{'L',{-1,0}},
	{'R',{1,0}}
};
// validator
bool inline valid(cell val){
	if(val.first<0 or val.first>6)
		return false;
	if(val.second<0 or val.second>6)
		return false;
	return true;
}

//using bfs to solve 
int bfs(string s,cell cur){
	queue<cell> q;
	q.push(cur);
	int result =0;
	int actionIndex =0;
	while(!q.empty() and actionIndex<48){

		int size = q.size();
		string actions = s[actionIndex]=='?'?
					"LURD":string(s[actionIndex],1);
		while(size>0){
			cell cur  = q.front(); q.pop();
			size--;
			if(cur.first == 6 and cur.second==0){
				result++;
				continue;
			}

			for(char ch: actions){
				cell move = dir[ch];
				cell tmp = {cur.first + move.first,
							cur.second + move.second};
				if(valid(tmp))
					q.push(tmp);
			}

			//vis[cur.first][cur.second]=true;
		}
		actionIndex++;
	}
	return result;
}

int main(){
	string s; cin>>s;
	//vector<vector<bool>> vis(7,vector<bool>(7,0));
	int result = bfs(s,{0,0});
	cout<<result;
}