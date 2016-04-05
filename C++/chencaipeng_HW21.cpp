#include <iostream>
#include <cmath>
using namespace std;

class Rat
{
private:
    int n;
    int d;
public:

    //default constructor
    Rat()
    {
        n = 0;
        d = 1;
    }

    //2 parameter constructor
    Rat(int i, int j)
    {
        n = i;
        d = j;
    }

    //conversion constructor
    Rat(int i)
    {
        n = i;
        d = 1;
    }

    Rat operator+(Rat r)
    {
        Rat t;
        t.n=n*r.d+d*r.n;
        t.d=d*r.d;
        return t;
    }
        Rat operator*(Rat r)
    {
        Rat t;
        t.n = n*r.n;
        t.d = d*r.d;
        return t;
    }

    Rat operator/(Rat r)
    {
        Rat t;
        t.n = n*r.d;
        t.d = d*r.n;
        return t;
    }
    friend ostream& operator<<(ostream& os, Rat r);
    friend istream& operator>>(istream& is, Rat& r);
    friend Rat continued_frac_3(int a[], int i);

};

ostream& operator<<(ostream& os, Rat r)
{
    int t;
    int a,b,n,d;
    int improp_fract = 0;
    a = r.n;
    b = r.d;
    if(a == 0) //when numerator is equal to zero
    {
        os<<0<<endl;
        return os;
    }
    if(a == b) // when denominator and numerator are equal
    {
        os<<r.n/r.d<<endl;
        return os;
    }
    if (b>a) //when denominator is greater than numerator
    {
        while(b != 0)
        {
            t =b;
            b = a%b;
            a = t;
        }
        if(a > 0) // when gcd found
        {
            n = r.n/a;
            d = r.d/a;
            os<<n<<"/"<<d<<endl;
            return os;
        }
        else //when gcd is not found
        {
           os<<r.n<<"/"<<r.d<<endl;
           return os;
        }
    }
    if(a>b) //when numerator is greater than denominator
    {
        if(a%b == 0)
        {
            os<<a/b<<endl;
            return os;
        }
        while(a != 0) //when gcd found
        {
            t = a;
            a = b%a;
            b = t;
        }
        if(b > 0)
        {
            if(r.n/b > r.d/b)
            {

                improp_fract = (r.n/b)/(r.d/b); //having fraction form
                n = r.n/b -improp_fract*(r.d/b);
                d = r.d/b;
                os<<improp_fract<<" "<<n<<"/"<<d<<endl;
                return os;
            }
        }
        else
        {
            os<<r.n<<"/"<<r.d<<endl;
            return os;
        }
    }
}

istream& operator>>(istream& is, Rat& r)
{
    is>>r.n>>r.d;
    return is;
}

double continued_frac_1(int a[], int i)
{
    if(a[i+1] == -1) return a[i];
    return a[i]+(double)(1/continued_frac_1(a,i+1));
};

int* continued_frac_2(int a[], int i)
{
    if(a[i+1] == -1)
    {
        int *p = new int[2];
        p[0]=a[i];
        p[1]=1;
        return p;
        delete []p;
    }
    int *r = continued_frac_2(a, i+1);//pointer store the return array address
    int *frac = new int[2]; //new a array to store the fraction
    frac[0] = a[i]*r[0]+r[1];
    frac[1] = r[0];
    //reduce
    int x = frac[0];
    int y = frac[1];
    while(x != 0)
    {
        int t = x;
        x = y%x;
        y = t;
    }
    if(y > 0)
    {
        frac[0] = frac[0]/y;
        frac[1] = frac[1]/y;
    }
    return frac;

}
Rat continued_frac_3(int a[], int i)
{
    if(a[i+1] == -1)
    {
        return Rat(a[i],1); //return Rat object
    }

    Rat r = continued_frac_3(a, i+1); // assign the return Rat class to Rat class r
    return Rat(a[i]*r.n+r.d,r.n);

}


int main()
{
  	int array[] = {3, 7, 16, -1};
	cout << "Continued fractions function 1: " <<
		continued_frac_1(array, 0) << endl;

	int *a = continued_frac_2(array, 0);
	cout << "Continued fractions function 2: " <<
		a[0] << '/' << a[1] << endl;
	delete []a;

	cout << "Continued fractions function 3: " <<
		continued_frac_3(array, 0) << endl;

	return 0;
}
