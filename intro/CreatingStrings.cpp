#include <bits/stdc++.h>

using namespace std;

void printAllPermutations(string s,long int & total){
	if(!prev_permutation(s.begin(), s.end())){
		cout<<total<<endl;
		return;
	}
	total++;
	printAllPermutations(s,total);
	cout<<s<<endl;
}
int main(){
	string s; cin>>s;
	sort(s.begin(), s.end(),greater<int>());
	long int total =1;
	printAllPermutations(s,total);
	cout<<s;
}	