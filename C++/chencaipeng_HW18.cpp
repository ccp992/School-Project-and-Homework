#include <iostream>
#include <cmath>
using namespace std;

const int rows =5;
const int cols =6;
int cost[rows][cols];
int trace[rows][cols];

int minimun(int a, int b, int c)
    {
        return min(min(a,b),c);
    };

int main()
{
    int weight[rows][cols] =
    {
        {3,4,1,2,8,6},
        {6,1,8,2,7,4},
        {5,9,3,9,9,5},
        {8,4,1,3,2,6},
        {3,7,2,8,6,4}
    };
    int min_row = 0;
    int min_value = 0;
    int left = 0;
    int up = 0;
    int down = 0;
    int smallest = 0;
    int path[cols];
    
    for(int i = 0; i < rows; i++)
        cost[i][0] = weight[i][0];

    for(int c = 1; c < cols; c++)
    {
        for(int r = 0; r < rows; r++)
        {
            left =  cost[r][c-1];
            up = cost[(r-1+rows)%rows][c-1];
            down = cost[(r+1)%rows][c-1];
            smallest = minimun(left,up,down);
            //recording the trace table: indicate the smallest value of previous col;
            if(left == smallest)
                trace[r][c] = r;
            if(up == smallest)
                trace[r][c] = (r-1+rows)%rows;
            if(down == smallest)
                trace[r][c] = (r+1)%rows;
            //tie-breaking: pick left first, then pick upper one
            if(left == smallest && up == smallest)
                trace[r][c] = (r-1+rows)%rows;
            if(down == smallest && left == smallest)
                trace[r][c] = r;
            if(up == smallest && down == smallest)
                trace[r][c] = (r-1+rows)%rows;
            //record the cost table: adding current cell weight and the smallest weight from previous col
            cost[r][c] = weight[r][c] + smallest;

        }
    }
    //test trace table
    /*for(int r = 0; r < rows; r++)
    {
        for(int c = 1; c < cols; c++)
            cout<<trace[r][c]<<" ";
        cout<<endl;
    }
    cout<<endl;
    for(int r = 0; r < rows; r++)
    {
        for(int c = 1; c < cols; c++)
            cout<<cost[r][c]<<" ";
        cout<<endl;
    }
    cout<<endl;*/
    min_value = cost[0][cols-1];
    for(int i = 0; i < rows; i++)
    {
        if(cost[i][cols-1] < min_value)
        {
            min_value = cost[i][cols-1];
            min_row = i;
        }

    }
    for(int i =cols-1; i>=0; i--)
    {
        path[i]=min_row;
        min_row = trace[min_row][i];
    }
    for(int i = 0; i<=5; i++)
        cout<<path[i]<<" ";
    cout<<endl;
    cout<<"the shortest path is of length " <<min_value<<endl;
    return 0;

}
