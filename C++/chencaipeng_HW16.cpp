#include <iostream>
#include <cmath>
using namespace std;

//eight number across recursive

bool ok(int *q, int c)
{
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

};

void print(int *cross)
{
    static int slns = 0;

	cout << "Solution #" << ++slns << "\n  "
		 << cross[1] << ' ' << cross[2] << '\n'
		 << cross[0] << ' ' << cross[3] << ' ' << cross[4] << ' ' << cross[5] << "\n  "
		 << cross[6] << ' ' << cross[7] << endl;
};

void move(int *q, int i)
{
    if(i==8)
    {
        print(q);
        return;
    }
    for(int j=1;j<9;j++)
    {
        q[i]=j;
        if(ok(q,i))
        {
            move(q,i+1);
        }

    }
};

int main()
{
    int q[8] = {0};
    move(q,0);
    return 0;
}
