#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

const int rows =5;
const int cols =6;
int trace[rows][cols];

int minimun(int a, int b, int c)
    {
        return min(min(a,b),c);
    };

int cost(int i, int j) //i is row, j is column
{
    int weight[rows][cols] =
    {
        {3,4,1,2,8,6},
        {6,1,8,2,7,4},
        {5,9,3,9,9,5},
        {8,4,1,3,2,6},
        {3,7,2,8,6,4}
    };
    //base case
    if(j==0)
        return weight[i][0];

    ///recursive call
    int left = weight[i][j] + cost(i,j-1);
    int up = weight[i][j] + cost((i-1+rows)%rows, j-1);
    int down = weight[i][j] + cost((i+1)%rows, j-1);

    //find the value of the shortest path through cell(i,j)
    int shortest = minimun(left,up,down);
    if(left == shortest)
        trace[i][j] = i;
    if(up == shortest)
        trace[i][j] = (i-1+rows)%rows;
    if(down == shortest)
        trace[i][j] = (i+1)%rows;

    return shortest;

}

int main()
{
    int ex[rows];
    int path[cols]; //collect row number from trace table
    int min_row = 0;

    for(int i=0; i<rows; i++)
        ex[i]=cost(i,cols-1); //ex[i] consist the smallest total weight for starting at each row in the last column

    int smallest = ex[0];
    for(int i=0; i<rows; i++)
    {
        if(ex[i]<smallest){
            smallest = ex[i]; //get the minimum total weight
            min_row = i; //get the minimum row from far right column
        }
    }
    for(int i =cols-1; i>=0; i--)
    {
        path[i]=min_row;
        min_row = trace[min_row][i]; //transfer the minimum weight of row for i-1 column
    }
    for(int i = 0; i<=5; i++)
        cout<<path[i]<<" ";
    cout<<endl;
    cout<<"the shortest path is of length " <<smallest<<endl;
    return 0;

}
