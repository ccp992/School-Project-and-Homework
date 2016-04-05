/*
	Assignment: Equivalent Arrays

	Notes:
	- You are permitted to make another function to assist your
	equivalent() function. If you do so, please don't forgot to add
	the function title line (prototype) above main().
*/
#include <iostream>

using namespace std;

bool equivalent(int a[], int b[], int n);
bool sequence_test(int a[], int b[], int n, int i, int target);

bool sequence_test(int a[], int b[], int n, int b_target, int a_target){
    for(int z = 0; z < n; z++){
        if(a[a_target] != b[b_target])
            return false;
        a_target++;
        b_target++;
        if(a_target == n)
            a_target = 0;
        if(b_target == n)
            b_target = 0;

    }
    return true;
}

bool equivalent(int a[], int b[], int n) {
    int b_target = 0;
    int a_target = 0;
	for(int i = 0; i < n; i++){
        for(int x = 0; x < n; x++){
            if(a[i] == b[x])
                b_target = x;
                a_target = i;
        if(sequence_test(a, b, n, b_target, a_target) == true)
            return true;
        }
	}
	return false;
}

int main() {
	cout << boolalpha; //to make cout print true/false instead of 1/0

	int a1[5] = {1, 2, 3, 4, 5};
	int a2[5] = {4, 5, 1, 2, 3};
	cout << "a1[] == a2[]? " << equivalent(a1, a2, 5) << endl;
	cout << "a2[] == a1[]? " << equivalent(a2, a1, 5) << endl;

	int a3[] = {4, 6, 3, -4, 5, 2, 5, 8};
	int a4[] = {2, 5, 8, 4, 6, 3, -4, 5};
	cout << "a3[] == a4[]? " << equivalent(a3, a4, 8) << endl;
	cout << "a4[] == a3[]? " << equivalent(a4, a3, 8) << endl;

	int a5[] = {5, 4, 2, 1};
	int a6[] = {1, 2, 4, 5};
	cout << "a5[] == a6[]? " << equivalent(a5, a6, 4) << endl;
	cout << "a6[] == a5[]? " << equivalent(a6, a5, 4) << endl;

	int a7[] = {4, 5, 4, 3, 2, 7};
	int a8[] = {5, 4, 3, 2, 7, 4};
	cout << "a7[] == a8[]? " << equivalent(a7, a8, 6) << endl;
	cout << "a8[] == a7[]? " << equivalent(a8, a7, 6) << endl;

	int a9[] = {1,2,1,2,1};
	int a10[] = {1,1,2,1,2};
	cout << "a9[] == a10[]? " << equivalent(a9, a10, 5) << endl;
	cout << "a10[] == a9[]? " << equivalent(a10, a9, 5) << endl;

	return 0;
}

