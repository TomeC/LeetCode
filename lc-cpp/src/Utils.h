#include <iostream>
#include <algorithm>
#include "ListNode.h"

using namespace std;
#ifndef UTILS_H_
#define UTILS_H_
class Utils
{
public:
    static void check(int left, int right)
    {
        cout << "left:" << left << ","
             << "right:" << right << " -> ";
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
    static void check(ListNode *la, ListNode *lb)
    {
        if (la == lb)
        {
            cout << "success: la == lb" << endl;
        }
        else
        {
            cout << "fail:" << la->val << "!=" << lb->val << endl;
        }
    }
    static void check(bool flag)
    {
        if (flag)
        {
            cout << "success" << endl;
        }
        else
        {
            cout << "fail" << endl;
        }
    }
};

#endif