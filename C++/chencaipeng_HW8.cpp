#include <iostream>
#include <cmath>
#include<cstdlib>

using namespace std;

void backtrack(int &c){
    c--;
    if(c==-1)
        {system("pause"), exit(1);};
}

void print(int cross[]) {
	static int slns = 0;

	cout << "Solution #" << ++slns << "\n  "
		 << cross[1] << ' ' << cross[2] << '\n'
		 << cross[0] << ' ' << cross[3] << ' ' << cross[4] << ' ' << cross[5] << "\n  "
		 << cross[6] << ' ' << cross[7] << endl;
}

bool ok(int q[], int c){
    int test[8][5] = {{-1},{0,-1},{0,-1},{0,1,2,-1},{0,1,3,-1},{1,4,-1},{2,3,4,-1},{3,4,5,6,-1}};
    for(int i = 0; i < c; i++){
        if(q[c] == q[i]) {
            return false;
        }
    }
    for(int i = 0; i < 5; i++){
        int z = test[c][i];
        if(z == -1) return true;
        if(abs(q[c] - q[z]) == 1) return false;
    }
}

int main()
{
   int q[8] = {0};
   int c = 0;
   bool from_backtrack = false;
   while(true){
       while(c < 8){
            if(!from_backtrack)
                q[c] = 0;
            from_backtrack = false;
            while(q[c] < 9){
                q[c]++;
                if(q[c] == 9){
                    backtrack(c);
                    continue;
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

   return 0;
}


