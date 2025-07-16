#include<iostream>

using namespace std;

class Point {
    public:
    int x, y;
    Point(int x=0, int y=0): x(x), y(y) {};

    Point operator+(const Point& other) const {
        return Point(x + other.x, y+other.y);
    }
    Point operator-(const Point& other) const {
        return Point(x - other.x, y-other.y);
    }
};

// Array wrapper
class Array {
    private:
    int* data;
    public:
    Array(int n): data(new int[n]) {};

    int& operator[](int index){
        return data[index];
    }
};

// Counter
class Counter {
    private:
    int cnt;
    public:
    Counter(int cnt=0): cnt(cnt) {};

    Counter& operator++(){
        ++cnt;
        return *this;
    }
    Counter operator++(int){
        Counter temp = *this;
        ++cnt;
        return temp;
    }
    friend ostream& operator<<(ostream& os, const Counter &c){
        os << c.cnt;
        return os;
    }
};

class Student {
    public:
    string name;
    int age;
    Student(string name, int age): name(name), age(age) {};

    // toString()
    friend ostream& operator<<(ostream &os, const Student& s){
        os << "name: " << s.name << endl << "age: " << s.age << endl;
        return os;
    }
};


int main() {
    Point p1(1, 2);
    Point p2(3, 5);
    Point p3 = p1 + p2;
    cout << "(" << p3.x << ", " << p3.y << ")" << endl;
    Point p4 = p1 - p2;
    cout << "(" << p4.x << ", " << p4.y << ")\n" << endl;
    cout << "-----------------------" << endl;
    cout << "Students: " << endl;
    Student s1("Alice", 30);
    Student s2("Bob", 30);
    cout << "Student 1:\n" << s1;
    cout << "Student 2:\n" << s2 << endl;
    cout << "-----------------------" << endl;
    Array arr(4);
    arr[0] = 10;
    cout << "arr[0]: " << arr[0] << endl; 
    cout << "-----------------------" << endl;
    Counter c(5);
    cout << "Initial counter: " << c << endl;
    cout << "Post-increment: " << c++ << endl;  // Shows old value
    cout << "After post-increment: " << c << endl; // Shows incremented value
    cout << "Pre-increment: " << ++c << endl;  // Increments first, then shows value
    cout << "-----------------------" << endl;
    return 0;
}