#include<iostream>
using namespace std;

class Person {
    int socialId;
    string name;
    public:
        Person(string n, int id): name(n), socialId(id){}
        string getName(){ return name;}
        bool validateID(){return socialId<=1001 && socialId>=0;}
};
int main(){
    Person p1("Shubham", 503);
    if(!p1.validateID()){
        cout << "Invalid Social Id" << endl;
    }
    cout << p1.getName() << endl;
}