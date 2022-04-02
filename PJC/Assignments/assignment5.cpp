#include <iostream>
#include<ostream>

template <typename F, typename S>
class Pair {
    F fst;
    S scn;
public:
    Pair<F,S>() {
        fst = nullptr;
        scn = nullptr;
    }
    Pair<F,S>(F& first, S& second) {
        fst = first;
        scn = second;
    }
    Pair(Pair& other): fst(other.first()), scn(other.second()){}

    Pair& operator=(const Pair& other) {
        if (this != other) {
            fst = other.first;
            scn = other.second;
        }
        return *this;
    }
    F first() const {
        return this->fst;
    }
    S second() const {
        return this->scn;
    }

    ostream& operator<<(ostream& s) {
        return cout << "[ " + fst + ", " + scn + " ]" << endl;
    }
};

template<typename F, typename S>
bool operator<(Pair<F,S>& a, Pair<F,S>& b) {
    bool res = false;
    if (a.first < b.first) {
        res = true;
    }
    else if(a.first == b.first){
        if (a.second < b.second) {
            res = true;
        }
    }
    return res;
}

template<typename F, typename S>
bool operator>(Pair<F, S>& a, Pair<F, S>& b) {
    bool res;
    if (a.first > b.first) {
        res = true;
    }
    else if(a.first == b.first){
        if (a.second > b.second) {
            res = true;
        }
    }
    return res;
}

template<typename F, typename S>
bool operator==(Pair<F, S>& a, Pair<F, S>& b) {
    return !(a < b) && !(a > b);
}

template<typename F, typename S>
bool operator!=(Pair<F, S>& a, Pair<F, S>& b) {
        return (a<b || a>b);
}

template<typename F, typename S>
bool operator<=(Pair<F, S>& a, Pair<F, S>& b) {
    return (a < b || a == b);
}

template<typename F, typename S>
bool operator>=(Pair<F, S>& a, Pair<F, S>& b) {
    return (a > b || a == b);
}


template <typename PAIR>
void check(const PAIR& lhs, const PAIR& rhs) {
    using std::cout; using std::endl;
    auto flags = cout.flags();
    cout << std::boolalpha;
    cout << "\nLHS=" << lhs << "  RHS=" << rhs << endl;
    cout << "lhs <  rhs: " << (lhs < rhs) << endl;
    cout << "lhs <= rhs: " << (lhs <= rhs) << endl;
    cout << "lhs >  rhs: " << (lhs > rhs) << endl;
    cout << "lhs >= rhs: " << (lhs >= rhs) << endl;
    cout << "lhs == rhs: " << (lhs == rhs) << endl;
    cout << "lhs != rhs: " << (lhs != rhs) << endl;
    cout.flags(flags);
}

int main() {
    check(Pair<int, int>(3, 3), Pair<int, int>(4, 2));
    check(Pair<int, int>(3, 3), Pair<int, int>(3, 2));
    check(Pair<int, int>(4, 3), Pair<int, int>(4, 3));

    Pair<int, int> pia{ 3,4 };
    Pair<int, int> pib{ 4,5 };
    Pair<double, double> pd(pia);
    std::cout << pia << std::endl;
    std::cout << pd << std::endl;
    pd = pib;
    std::cout << pd << std::endl;
}
