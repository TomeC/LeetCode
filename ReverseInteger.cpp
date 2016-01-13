/************************************************************************
*  7.Reverse Integer
*  Reverse digits of an integer.
*  Example1: x = 123, return 321
*  Example2: x = -123, return -321
************************************************************************/
#include <iostream>
using namespace std;

#define INT_MAX     2147483647
#define INT_MIN     (-INT_MAX-1)
class Solution {
public:
    int reverse(int x) {
        int tmp = 0;
        while (x != 0)
        {
            if (tmp > INT_MAX/10 || tmp < INT_MIN/10)
            {
                return 0;
            }
            tmp = tmp*10 + x%10;
            x /= 10;
        }
        return tmp;
    }
};

int main() 
{
    Solution s;
    cout<<s.reverse(-2147483412)<<endl;
    cout<<s.reverse(-100)<<endl;
    cout<<s.reverse(10)<<endl;
    return 0;
}