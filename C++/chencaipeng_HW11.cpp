#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;
bool ok(int, int);
void backtrack(int &);

bool ok(int q[], int col){
 for(int i=0; i<col; i++)
    if(q[col]==q[i] || (col-i)==abs(q[col]-q[i])) return false;

 return true;
};

int num_solutions(int n) {
    int* q = new int[n];
    q[0]=0;
    int c=1;
    int counter = 0;
    bool from_backtrack=false;
    while(true){
        while(c < n){
            if(!from_backtrack)
                q[c] = -1;
            from_backtrack = false;
            while(q[c] < n){
                q[c]++;
                if(q[c] == n) {
					c--;
					if(c==-1)
						{delete [] q; return counter;}
                continue;
                }
                if(ok(q,c)){
					break;
				}
            }
            c++;
        }
		++counter;
		c--;
		if(c==-1)
			{delete [] q; return counter;}
        from_backtrack = true;
    }
	/*FILL THIS IN*/
};

/*!!!DO NOT CHANGE ANYTHING IN MAIN()!!!*/
int main(){
	int n;
	cout << "How many queens? ";
	cin >> n;

	for (int i = 1; i <= n; ++i) {
		cout << "There is/are " << num_solutions(i) << " solution(s) to the " << i << " Queen(s) problem." << endl;
	}
	system("PAUSE");
	return 0;
}
