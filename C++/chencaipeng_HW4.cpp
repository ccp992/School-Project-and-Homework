#include  <iostream>
using namespace std;
int main (){
    int b[8][8]={0},r;
    int c = 0;
    b[0][0]=1;
    int imgCounter=1;

Nc:
    c++;
    if(c==8){
        goto print;
    }
    r=-1;
Nr:
    r++;
    if(r==8) goto backtrack;
    //row Test
    for (int i=0;i<c;i++){
        if(b[r][i]==1)goto Nr;
        }
    //upper diagonal Test
    for(int i=1;(r-i)>=0 && (c-i)>=0; i++){
        if (b[r-i][c-i] == 1) goto Nr;
    }
    //down diagonal Test
    for(int i=1;(r+i)<8 && (c-i)>=0; i++){
        if (b[r+i][c-i] == 1) goto Nr;
    }
    b[r][c]=1;
    goto Nc;

backtrack:
    c--;
    if (c==-1) return 0;
    r=0;
    while(b[r][c]==0)
        r++;
    b[r][c]=0;
    goto Nr;

print:

    cout << "Graph "<< imgCounter <<endl;
    for(int r = 0;r<8;r++){
        for(int c=0;c < 8; c++)
            cout<< b[r][c];
    cout << endl;
    }
    ++imgCounter;
    goto backtrack;
}
