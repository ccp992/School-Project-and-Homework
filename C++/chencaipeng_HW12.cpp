#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;



bool ok(int q[], int col){
 for(int i=0; i<col; i++)
    if(q[col]==q[i] || (col-i)==abs(q[col]-q[i])) return false;

 return true;
};
void backtrack(int &col){
    col--;
    if(col==-1)
        {system("PAUSE"); exit(1);}
};

void print(int q[]) {
	//copy and paste the code (from the first void main function)
	//from Dr. Waxman's handout and make changes so that the
	//board printout corresponds to the solution given in the q array

    static int count =0;
    cout<< ++ count<<endl<<endl;
	//feel free to use the code below, but do experiment with your own artwork!
	typedef char box[5][7];
    box bb,wb,*board[8][8];
    int i,j,k,l;
    char wc = char(219);

	// "drawing" the crown in black queen box
	box bq =
	{
		wc, wc, wc, wc, wc, wc, wc,
		wc, ' ', wc, ' ', wc, ' ', wc,
		wc, ' ', ' ', ' ', ' ', ' ', wc,
		wc, ' ', ' ', ' ', ' ', ' ', wc,
		wc, wc, wc, wc, wc, wc, wc
	};

	// "drawing" the crown in white queen box
	box wq =
	{
		' ', ' ', ' ', ' ', ' ', ' ', ' ',
		' ', wc, ' ', wc, ' ', wc, ' ',
		' ', wc, wc, wc, wc, wc, ' ',
		' ', wc, wc, wc, wc, wc, ' ',
		' ', ' ', ' ', ' ', ' ', ' ', ' '
	};
     //fill in bb=black box and wb = whitebox
        for(i = 0; i < 5; i++)
            for(j = 0; j < 7; j++){
                wb[i][j] = ' ';
                bb[i][j] = char(219);
            }

    //fill board with pointers to bb and wb in alternate positions
        for(i = 0; i< 8; i++)
            for(j = 0; j < 8; j++)
                if((i+j)%2 == 0)
                    board[i][j] = &wb;
                else
                    board[i][j] = &bb;

    for(int z = 0; z < 8; z++){
        int y = q[z];
        if((z+y)%2 == 0)
            board[y][z] = &bq;
        board[y][z] = &wq;
    }
    //print the board via the pointers in array board

    //first print upper boarder
    cout<<" ";
    for(int i = 0; i < 7*8; i++)
        cout<<'_';
    cout<<endl;
    //now print the board
    for(int i = 0; i < 8; i++)
        for(int k = 0; k < 5; k++){
            cout<<" "<<char(179); //print left boarder
            for(int j = 0; j < 8; j++)
                for(int l = 0; l < 7; l++)
                    cout<<(*board[i][j])[k][l];
            cout<<char(179)<<endl; //at end of line print bar and then newline
        }
    //before exiting print lower boarder
    cout<<" ";
    for(int i = 0; i < 7*8; i++)
        cout<<char(196);
    cout<<endl;
    return;
}

int main(){
    int q[8]; q[0]=0;
    int c=1;
    bool from_backtrack=false;

    while(true){

        while(c<8){
            if(!from_backtrack)
                q[c] = -1;

            from_backtrack = false;
            while(q[c]<8){
                q[c]++;
                if(q[c] == 8) {backtrack(c); continue;}
                if(ok(q,c))
                    break;
            }
            c++;
        }
    print(q);
    backtrack(c);
    from_backtrack = true;
    }

}
