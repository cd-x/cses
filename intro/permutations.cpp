#include <bits/stdc++.h>

using namespace std;

bool generatePermutations(set<int>& available,vector<int>& res){
	if(available.empty())
		return true;
	for(int ele: available){
		  if(ele==0) 
		  	return false;
		if(res.empty() or abs(res.back() - ele)>1){
			res.push_back(ele);
			available.erase(ele);

			if(generatePermutations(available,res)){
				return true;
			}
			else{
				available.insert(ele);
				res.pop_back();
			}
		}
	}
	return false;
}

int main(){

	int n; cin>>n;
	set<int>available;

	for(int i=1;i<=n;i++)
		available.insert(i);
	
	vector<int>res;

	if(generatePermutations(available,res))
		for(int ele: res) cout<<ele<<" ";
	else
		cout<<"NO SOLUTION";
}