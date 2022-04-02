#include <iostream>

using namespace std;

int GCD(int n, int d) {
	int rem;
	while (d != 0) {
		rem = n % d;
		n = d;
		d = rem;
	}
	return n;
};

class Frac {
public:
	int numerator;
	int denominator;


	Frac() {
		numerator = 0;
		denominator = 1;
	}
	Frac(int n) {
		numerator = n;
		denominator = 1;
	}
	Frac(int n, int d) {
		numerator = n;
		if (d == 0)
		{
			cout << "invalid input" << endl;
			exit(0);
		}
		else
			denominator = d;
	}

	Frac(const Frac& f);

	Frac& operator=(Frac& f);

	Frac operator+(const Frac& second) {
		int n = numerator * second.denominator + denominator * second.numerator;
		int d = denominator * second.denominator;
		return Frac(n/GCD(n,d), d/GCD(n,d));
	}
	
	
	Frac operator-(const Frac& second) {
		int n = numerator * second.denominator - second.numerator * denominator;
		int d = denominator * second.denominator;
		return Frac(n / GCD(n, d), d / GCD(n, d));
	}
	Frac operator*(const Frac& second) {
		int n = numerator * second.numerator;
		int d = denominator * second.denominator;
		return Frac(n / GCD(n, d), d / GCD(n, d));
	}
	Frac operator/(const Frac& second) {
		int n = numerator * second.denominator;
		int d = denominator * second.numerator;
		return Frac(n / GCD(n, d), d / GCD(n, d));
	}

};



Frac operator+(const int& i, const Frac& f) {
	int n = i * f.numerator + f.numerator;
	int d = f.denominator;
	return Frac(n / GCD(n, d), d / GCD(n, d));
};
Frac operator*(const int& i, const Frac& f) {
	int n = i * f.numerator;
	int d = f.denominator;
	return Frac(n / GCD(n, d), d / GCD(n, d));
};
Frac operator/(const int& i, const Frac& f) {
	int n = i * f.denominator;
	int d = f.numerator;
	return Frac(n / GCD(n, d), d / GCD(n, d));
};


ostream& operator<<(ostream& os, const Frac& f) {
	if (f.denominator == 1)
		 return cout << f.numerator << endl;
	else
		return cout << f.numerator << "/" << f.denominator << endl;
};

int main() {
	Frac a(2), b(4, 10), c(24, -15), x(1, -3), y(2, 6);

	std::cout << -2 * ((a + b) * 5 - 4) / c << " "
		<< (7 + x + y * 1114 / 111) << std::endl;
}
