#include <bits/stdc++.h>

using namespace std;
vector<string> grayCodeGenerator(int n){
	if(n==1)
		return {"0","1"};
	vector<string> tmp = grayCodeGenerator(n-1);
	vector<string> res;

	for(auto it = begin(tmp);it!=end(tmp);it++)
		res.push_back("0"+(*it));
	for(auto it = rbegin(tmp);it!=rend(tmp);it++)
		res.push_back("1"+(*it));
	return res;
}
int main(){
	int n; cin>>n;
	vector<string> res = grayCodeGenerator(n);
	for(string ele: res)
		cout<<ele<<endl;
}