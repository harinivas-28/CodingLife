#include<iostream>
using namespace std;

class IRemoteControl {
    public:
        // pure virtual functions make this an abstract class
        // pure functions must be implemented when any other class inherits this class
        virtual void powerOn() = 0;
        virtual void changeChannel(int channel) = 0;
        virtual void adjustVolume(int level) = 0;
        virtual ~IRemoteControl(){}
};
class Tv: public IRemoteControl {
    private: string company;
    public:
        Tv(string name): company(name){}
        void powerOn() override {
            cout << company<<": Powering on..." << endl;
        }
        void changeChannel(int channel) override {
            cout << company<<": Channel changed to " << channel << endl;
        }
        void adjustVolume(int level) override{
            cout << company<<": Volume set to " << level << endl;
        }
};
int main(){
    IRemoteControl* remote = new Tv("Samsung Tv");
    remote->powerOn();
    remote->changeChannel(101);
    remote->adjustVolume(25);
    delete remote;
}