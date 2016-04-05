#include <iostream>
#include <cmath>
using namespace std;

int main (){
    int q[8], c = 0;
    q[0] = 0;
Nc:
    c++;
    if(c == 8) goto print;
    q[c] = -1;
Nr:
    q[c]++;
    if(q[c] == 8) goto backtrace;
    for(int i = 0; i < c; i++)
        if(q[i] == q[c] || c-i == abs(q[c] - q[i]))
        goto Nr;
    goto Nc;
backtrace:
    c--;
    if(c == -1) return 0;
    goto Nr;
print:
    for(int i = 0; i < 8; i++)
        cout<<q[i];
    cout<<endl;
    goto backtrace;

}
