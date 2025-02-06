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