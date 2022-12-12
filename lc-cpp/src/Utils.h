#include <iostream>
using namespace std;

class Utils
{
public:
    static void check(int left, int right)
    {
        cout << "left:" << left << ","
             << "right:" << right << endl;
        if (left == right)
        {
            cout << "success" << endl;
        }
        else
        {
            cout << "fail" << endl;
        }
    }
};
