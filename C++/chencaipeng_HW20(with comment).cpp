#include <iostream>

using namespace std;

class Rat{
	private:
		int n;
		int d;
		int frac;
	public:
		//constructors
		Rat(){
			n = 0;
			d = 1;
		}

		Rat(int i, int j){
            n = i;
            d = j;
		}

		Rat(int i){
			n = i;
			d = 1;
		}

		int getN(){return n;}
		int getD(){return d;}

		void setN(int i){n = i;}
		void setD(int i){d = i;}

		Rat operator+(Rat r){
			Rat t;
			t.n = n*r.d+d*r.n;
			t.d = d*r.d;
			return t;
		}

		Rat operator-(Rat r)
		{
		    Rat t;
		    t.n = (n*r.d)-(r.n*d);
		    t.d = d*r.d;
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

int main() {
	Rat r1(5, 2), r2(3, 2);

	cout << "r1: " << r1 << endl;
	cout << "r2: " << r2 << endl;
	cout << "r1 + r2: " << r1 + r2 << endl;
	cout << "r1 - r2: " << r1 - r2 << endl;
	cout << "r1 * r2: " << r1 * r2 << endl;
	cout << "r1 / r2: " << r1 / r2 << endl;
	cout << endl;

	r1 = r2;
	r2 = r1 * r2;

	cout << "r1: " << r1 << endl;
	cout << "r2: " << r2 << endl;
	cout << "r1 + r2: " << r1 + r2 << endl;
	cout << "r1 - r2: " << r1 - r2 << endl;
	cout << "r1 * r2: " << r1 * r2 << endl;
	cout << "r1 / r2: " << r1 / r2 << endl;
	cout << endl;

	r1 = r2 + r1 * r2 / r1;
	r2 = r2 + r1 * r2 / r1;

	cout << "r1: " << r1 << endl;
	cout << "r2: " << r2 << endl;
	cout << "r1 + r2: " << r1 + r2 << endl;
	cout << "r1 - r2: " << r1 - r2 << endl;
	cout << "r1 * r2: " << r1 * r2 << endl;
	cout << "r1 / r2: " << r1 / r2 << endl;

	return 0;
}
