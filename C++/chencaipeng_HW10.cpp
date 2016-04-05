//============================================================================
// Name        : Stable.cpp
// Author      :
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cstdlib>
using namespace std;

void backtrack(int &c){
    c--;
    if(c==-1)
        {system("pause"), exit(1);};
}
void print(int q[]){
	static short slns = 0;

	cout << "Match #" << ++slns << ":\n"
		 << "Man\tWoman" << endl;

	for (int i = 0; i < 3; ++i)
		cout << i << '\t' << q[i] << endl;

	cout << endl;
}

bool ok(int q[], int col){
	int mp[3][3]={0,2,1,
                    0,2,1,
                    1,2,0};
	int wp[3][3]={2,1,0,
                    0,1,2,
                    2,0,1};
	int nm = col;
	int nw = q[nm];
	for(int i = 0; i < col; i ++){
		int cm = i, cw = q[cm];
		if(q[nm] == q[cm]) return false;
		if(mp[cm][nw] < mp[cm][cw] && wp[nw][cm] < wp[nw][nm]) return false;
		if(mp[nm][cw] < mp[nm][nw] && wp[cw][nm] < wp[cw][cm]) return false;
	}
return true;
}

int main() {
	int q[3] = {0,0,1};
	int c = 1;
	bool from_backtrack = false;
	while(true){
		while(c < 3){
			if(!from_backtrack)
	            q[c] = -1;
	        from_backtrack = false;
	        while(q[c] < 3){
	           q[c]++;
	           while(q[c] == 3){
	           backtrack(c);
	           q[c]++;
	           }
	           if(ok(q,c)) {
	        	   break;
	           }
	        }
	       c++;
	       }
	print(q);
	backtrack(c);
	from_backtrack = true;
    }
}
