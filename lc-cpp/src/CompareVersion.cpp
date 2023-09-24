#include "Utils.h"
#include <iostream>
using namespace std;

class Solution
{
public:
    int compareVersion(string version1, string version2)
    {
        vector<string> vs1 = split(version1, '.');
        for_each(vs1.begin(), vs1.end(), [&](auto item)
                 { cout << item << endl; });

        return 0;
    }
    vector<string> split(string src, char x)
    {
        int start = 0, end = 0;
        vector<string> vs;
        while (true)
        {
            end = src.find(x, start);
            if (end == -1)
            {
                break;
            }
            vs.push_back(src.substr(start, end - start));
            start = end;
        }
        return vs;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.compareVersion("1.01", "1.001"), 0);
    Utils::check(s.compareVersion("1.01", "1.001.00"), 0);
    Utils::check(s.compareVersion("1.01", "2.001.00"), -1);
    Utils::check(s.compareVersion("1.01.01", "1.001.00"), 1);
    return 0;
}
