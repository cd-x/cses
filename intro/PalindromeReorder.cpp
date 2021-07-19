#include <bits/stdc++.h>
using namespace std;

int main(){

	string s; cin>>s;
	unordered_map<char,int>ump;
	for(char ch: s) ump[ch]++;

	string res="";
	char oneChar ='*';
	for(char ch='A';ch<='Z';ch++){
		if(!ump[ch]) 
			continue;

		res = res + string(ump[ch]/2,ch);
		
		if(ump[ch]&1){
			if(oneChar!='*'){
				res = "NO SOLUTION";
				break;
			}
			else
				oneChar = ch;
		}
	}
	if(res!="NO SOLUTION"){
		string tmp = res;
		reverse(begin(tmp),end(tmp));
		if(2*res.length()<s.length())
			res.push_back(oneChar);
		res = res + tmp;
	}
	cout<<res;
}