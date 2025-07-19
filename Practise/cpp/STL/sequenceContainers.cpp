#include<iostream>
#include<array>
using namespace std;
#define nl "\n"

int main(){
    // ARRAY
    array<int, 6> arr = {1,2, 3,4, 5, 6};
    // using at
    for(int i=0;i<6;i++)
        cout << arr.at(i) << " ";
    cout << nl;
    // using get();
    cout << get<0>(arr) << nl;
    cout << get<3>(arr) << nl; 
    // using operator []
    cout << arr[5] << nl;
    // front() and back() returns references
    int &a = arr.front();
    cout << a << nl;
    a = 19;
    cout << a << nl;
    // size, max_size
    cout << arr.size() << nl;
    cout << arr.max_size() << nl;
    array<int, 6> arr2 = {7, 8, 9, 10, 11};
    arr.swap(arr2);
    // after swapping
    for(int i=0;i<6;i++)
        cout << arr.at(i) << " ";
    cout << nl;
    // empty, fill
    cout << arr2.empty() <<nl;
    arr2.fill(-1);
    // multi dimensional array
    int arr3[2][4] = {-1}; // fills with -1
    int arr4[2][4] = {0, 1, 2, 3, 4, 5, 6, 7}; // initialized sequentially

    // VECTOR
    

}