#include<iostream>
using namespace std;

class Base {
    public: int value;
};
class Derived1: virtual public Base {
    public: Derived1(){value=1;}
};
class Derived2: virtual public Base {
    public: Derived2(){value=2;}
};
class Final: public Derived1, public Derived2 {
};
int main(){
    Final f;
    f.value = 100;
    cout << "Value: " << f.value << endl;
    // resolves ambiguity
    Derived1 d1;
    cout << d1.value;
}