#include <iostream>
#include <algorithm>
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
    static void check(vector<int> lv, vector<int> rv)
    {
        if (lv.size() != rv.size())
        {
            cout << left << " != " << right << endl;
            for_each(lv.begin(), lv.end(), [](int &x)
                     { cout << x << " "; });
            cout << endl;
            for_each(rv.begin(), rv.end(), [](int &x)
                     { cout << x << " "; });
            cout << endl;
            return;
        }
        for (size_t i = 0; i < lv.size(); i++)
        {
            if (lv[i] != rv[i])
            {
                cout << "index:" << i << " " << lv[i] << "!=" << rv[i] << endl;
                return;
            }
        }
    }
};
