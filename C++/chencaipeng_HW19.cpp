#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;
bool ok(int, int);


bool ok(int q[], int c, int n){
 for(int i=0; i<c; i++)
    if(q[c]<q[i] || abs(q[c]/n - q[i]/n) == abs(q[c]%n - q[i]%n)) return false;

 return true;
};

int num_solutions(int k, int n) {
    int* q = new int[k];
    q[0]=0;
    int c=1;
    int counter = 0;
    bool from_backtrack=false;
    while(true){
        while(c < k){
            if(!from_backtrack)
                q[c] = -1;
            from_backtrack = false;
            while(q[c] < n*n){
                q[c]++;
                if(q[c] == n*n) {
					c--;
					if(c==-1)
						{delete [] q; return counter;}
                continue;
                }
                if(ok(q,c,n)){
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
};

int main(){

	int k;
	int n;
	while(true)
    {
        cout << "How large the cheeseboard is(nxn)? ";
        cin >> n;
        if(n == -1) return 0;
        cout << "How many bishops are ";
        cin >> k;
        if(k>n) return 0;
        for (int i = 1; i <= k; ++i) {
            cout << "There is/are " << num_solutions(i,n) << " solution(s) to the " << k << " bishops in "<<n<<"x"<<n<<" cheeseboard" << endl;
	}
    }

	system("PAUSE");
	return 0;
}
