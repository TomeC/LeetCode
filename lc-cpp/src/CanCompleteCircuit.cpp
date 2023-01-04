#include <vector>
#include "Utils.h"
using namespace std;

class Solution
{
public:
    int canCompleteCircuit(vector<int> gas, vector<int> cost)
    {
        int pos = 0;
        bool flag = true;
        while (pos < gas.size())
        {
            int sum = 0;
            for (int i = 0; i < gas.size(); i++)
            {
                int tpos = (pos + i) % gas.size();
                sum += (gas[tpos] - cost[tpos]);
                if (sum < 0)
                {
                    pos = pos + i + 1;
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                return pos;
            }
            flag = true;
        }

        return pos >= gas.size() ? -1 : pos;
    }
};
int main(int argc, char const *argv[])
{
    Solution s;
    Utils::check(s.canCompleteCircuit(vector<int>{5, 8, 2, 8}, vector<int>{6, 5, 6, 6}), 3);
    Utils::check(s.canCompleteCircuit(vector<int>{2, 3, 4}, vector<int>{3, 4, 3}), -1);
    Utils::check(s.canCompleteCircuit(vector<int>{1, 2, 3, 4, 5}, vector<int>{3, 4, 5, 1, 2}), 3);
    Utils::check(s.canCompleteCircuit(vector<int>{5, 1, 2, 3, 4}, vector<int>{4, 4, 1, 5, 1}), 4);
    Utils::check(s.canCompleteCircuit(vector<int>{11, 4, 7, 1, 0}, vector<int>{2, 5, 5, 9, 1}), 0);
    Utils::check(s.canCompleteCircuit(vector<int>{3, 1, 1}, vector<int>{1, 2, 2}), 0);

    return 0;
}
