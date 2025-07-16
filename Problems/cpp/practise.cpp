#include<iostream>
using namespace std;

// NOTE:
/*
When to Use Each:
Use &:
When you need a reference parameter in a function to avoid copying large objects.
When you want to get the address of a variable (e.g., passing a pointer to a function).
Use *:
When you need to declare a pointer.
When you need to dereference a pointer to access or modify the value it points to.
*/

int main(){
    int x = 10;
    int& ref = x; // reference to x
    cout << "X Before Changing Reference: " << x << endl;
    ref += 10;
    cout << "X After changing Reference: " << x << endl;
    int* ptr = &x; // ptr stores the address of x;
    cout << "X before changing the pointer: " <<x << endl;
    cout << "ptr before changing the pointer: " << ptr << endl;
    *ptr += 10;
    cout << "X After changing the pointer: " << x << endl;
    cout << "ptr After changing the pointer: " << ptr << endl;
}