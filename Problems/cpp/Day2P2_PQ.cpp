#include <iostream>
#include <queue>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Student {
public:
    string name;
    int score;

    Student(string name, int score) : name(name), score(score) {}

    // Overload the < operator for priority_queue
    bool operator<(const Student& other) const {
        if (score == other.score) {
            return name > other.name; // Lexicographical order for names
        }
        return score < other.score; // Higher score comes first
    }
    /*
    Here's what each part means:

    bool:
    This indicates that the function returns a boolean value (true or false). The returned value tells whether the current Student object is considered "less than" the other Student object according to the criteria defined in the function.

    operator<:
    This is the name of the function. In C++, you can overload operators so that they work with your custom classes. By defining operator<, you're specifying how the < operator should work when comparing two Student objects.

    (const Student& other):
    This is the parameter list. It means the function takes one parameter named other which is a reference to a Student object. The const qualifier means that this parameter will not be modified by the function. This parameter represents the Student object being compared to the current object.

    const at the end:
    This means that the operator function will not modify any member variables of the current Student object (the one on the left-hand side of the < operator). It promises that calling this function is safe and does not change the object’s state.
    */

    // Overload the << operator for easy printing
    friend ostream& operator<<(ostream& os, const Student& student) {
        os << "(" << student.name << ", " << student.score << ")";
        return os;
    }
};

int main() {
    int n;
    cin >> n;

    // Priority queue using a max-heap based on the < operator overload
    priority_queue<Student> pq;

    for (int i = 0; i < n; i++) {
        string name;
        int score;
        cin >> name >> score;
        pq.push(Student(name, score));
    }

    // Print the students in order
    while (!pq.empty()) {
        cout << pq.top() << endl;
        pq.pop();
    }

    return 0;
}