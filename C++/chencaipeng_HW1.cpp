#include <iostream>
using namespace std;


int main(){
	int i = 1;
	int target = 0;
	while(true){
        target = i*i;
        if((target%10)%2 != 0 && ((target/10)%10)%2 != 0)
            cout<<target<<endl;
        ++i;
	}
return 0;
}
