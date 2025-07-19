#include<bits/stdc++.h>
using namespace std;
# define nl "\n"

//1. Compile time polymorphism

class A {
    public:
        int real, img;
        A(){}
        A(int r, int i): real(r), img(i){}
        // A. Function Overloading
        int add(int a, int b){
            return a+b;
        }
        double add(double a, double b){
            return a+b;
        }
        // B. Operator Overloading
        A operator+(const A& other){
            return A(real+other.real, img+other.img);
        }
        virtual void show(){
            cout << "In Parent Class" << nl;
        }
};

// 2. Runtime Polymorphism
class B: public A {
    public: 
        void show() override {
            cout << "In Child Class" << nl;
        }
};

int main(){
    // compile time
    A a;
    cout << "Integer Sum: " << a.add(2, 3) << nl;
    cout << "Float Sum: "<<a.add(5.3, 6.2) << nl;
    A c1(10, 5), c2(2, 4);
    A c3 = c1+c2;
    cout << "Operator Overloading Sum: " << c3.real << " + i"<<c3.img << nl;
    // runtime
    A* aptr;
    B b;
    aptr = &b;
    aptr->show();
}