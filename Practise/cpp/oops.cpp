#include<iostream>
using namespace std;
#define nl "\n"
int x = 10;
namespace N {
    int x = 20;
}
class Animal {
    private:
        int private_variable; // friend class can access
    protected:
        int protected_variable; // friend class can access
    public:
        string species;
        int age, name;
        int x = 3;
        static int y;
        Animal(){
            private_variable = 10;
            protected_variable = 20;
            cout << "Animal Constructer called" << endl;
        }
        virtual void eat(){
            cout << "Animal Eating" << endl;
        }
        void sleep(){
            cout << "Animal Sleeping" << endl;
        }
        void scopeResolutionOperator(){
            // :: this operator cannot be overloaded
            cout << "Local X: " << x << endl;
            cout << "Global X: " << ::x << endl;
            cout << "Namespace N's X: " << N::x << endl;
        }
        void outsideMethod();
        virtual ~Animal(){
            cout << "Animal Destructor Called" << endl;
        }
        friend class Fish;
        friend void friendFunction(Animal &a);
};
void friendFunction(Animal &a){
    // can access
    cout << "Private Variable: " 
         << a.private_variable << endl;
    // can manipulate
    a.protected_variable = 99;
    cout << "Protected Variable: " 
         << a.protected_variable << nl;
}
class Fish {
    public:
        void displayAnimalVariables(Animal &a){
            // Fish can access Animal's but Animal cannot access Fish
            // no mutual friendship (if and only if declared in one of the classes)
            cout << "The value of Private Variable = "
             << a.private_variable << endl;
            cout << "The value of Protected Variable = "
                << a.protected_variable << endl;
        }
};
class Dog: public Animal {
    public:
        Dog(){
            cout << "Animal Construtor Called" << endl;
        }
        void eat() override {
            cout << "Dog Eating" << endl;
        }
        ~Dog() override {
            cout << "Dog Destructor Called" << endl;
        }
};
// can define a method of class Animal outside it using scope Resolution operator
void Animal::outsideMethod(){
    cout << "Method Outside A" << endl;
}
// In C++, static members must 
// be explicitly defined  like this
int Animal::y = 1;

class A {
    private:
        int b;
    public:
        A(int x): b(x){}
        // move constructor
        int getValue(){
            return b;
        }
};

int main(){
    Animal someAnimal;
    someAnimal.eat();
    someAnimal.scopeResolutionOperator();
    someAnimal.outsideMethod();
    // static access
    cout << "static y: " << Animal::y << endl;
    Dog dog;
    dog.Animal::eat();
    dog.eat();
    Fish fish;
    cout << "Friend class: "<< nl;
    fish.displayAnimalVariables(someAnimal);
    cout << "Friend Function: " << endl;
    friendFunction(someAnimal);
    Animal* dog2 = new Dog();
    dog2->eat();
    delete dog2;
    A a(100);
    cout << "Using modern move constructor:" << a.getValue() << nl;
}