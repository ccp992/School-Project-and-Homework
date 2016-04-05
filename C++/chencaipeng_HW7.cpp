#include <iostream>
#include <cmath>
using namespace std;


bool ok(int q[][8]){
	for(int r = 0; r < 8; r++){
		for(int c = 7; c >= 0; c--){
			if(q[r][c] == 1){
                //row test
				for (int i = c-1;i >= 0;i--)
					if(q[r][i]==1) return false;
				for(int i=1;(r-i)>=0 && (c-i)>=0; i++)
					if (q[r-i][c-i] == 1) return false;
                for(int i=1;(r+i)<8 && (c-i)>=0; i++)
                    if (q[r+i][c-i] == 1) return false;
			}
		}
	}
	return true;
		//find queen row
		//1.row check
		//2.up diagonal test
		//3.down diagonal test
		//fail any test above return false
		//pass all test above return true

};
void print(int q[][8], int counter){
    cout<<counter<<endl;
	for(int r = 0; r < 8; r++){
        for(int c = 0; c < 8; c++)
            cout<<q[r][c];
        cout<<endl;
	}
};

int main( ){
 int q[8][8]={0};
 int counter = 0;
 for(int i0 =0; i0 <8; i0 ++)
	for(int i1 =0; i1 <8; i1 ++)
		for(int i2 =0; i2 <8; i2 ++)
			for(int i3 =0; i3 <8; i3 ++)
				for(int i4 =0; i4 <8; i4 ++)
					for(int i5 =0; i5 <8; i5 ++)
						for(int i6 =0; i6 <8; i6 ++)
							for(int i7 =0; i7 <8; i7 ++){
								q[i0][0]=1;
								q[i1][1]=1;
								q[i2][2]=1;
								q[i3][3]=1;
								q[i4][4]=1;
								q[i5][5]=1;
								q[i6][6]=1;
								q[i7][7]=1;
                                if(ok(q)){
                                    print(q, ++counter);
                                }
								q[i0][0]=0;
								q[i1][1]=0;
								q[i2][2]=0;
								q[i3][3]=0;
								q[i4][4]=0;
								q[i5][5]=0;
								q[i6][6]=0;
								q[i7][7]=0;

                            }
 return 0;
}
