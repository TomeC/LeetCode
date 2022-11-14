/*
* 8. String to Integer (atoi)
* Implement atoi to convert a string to an integer.
*/
#include <iostream>
using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        const int MAX_INT = 2147483647;
        const int MIN_INT = (-2147483647-1);
        if (str.size() == 0)
        {
            return 0;
        }
        int dig = 0;
        int tmp = 0;
        bool negFlag = false;
        bool isHead = true;
        for (int i = 0; i < str.length(); ++i)
        {
            if (str[i] >= '0' && str[i] <= '9')
            {
                tmp = str[i]-'0';
                if (negFlag == true && -dig < (MIN_INT+tmp)/10)
                {
                    return MIN_INT;
                } else if (negFlag == false && dig > (MAX_INT-tmp)/10)
                {
                    return MAX_INT;
                }
                dig = dig*10 + tmp;
                isHead = false;
            } else if (str[i] == '-' && isHead == true)
            {
                negFlag = true;
                isHead = false;
            } else if (str[i] == '+' && isHead == true)
            {
                isHead = false;
                continue;
            }else if (str[i] == ' ')
            {
                if (isHead == true)
                {
                    continue;
                } 
                else
                {
                    break;
                }
            }
            else
            {
                break;
            }
        }
        return negFlag ? -dig: dig;
    }
};

int main()
{
    Solution s;
    cout<<s.myAtoi("1")<<endl;
    cout<<s.myAtoi("+05530")<<endl;
    cout<<s.myAtoi("-05530")<<endl;
    cout<<s.myAtoi("  +05530")<<endl;
    cout<<s.myAtoi("  -05530")<<endl;
    cout<<s.myAtoi("=5530")<<endl;
    cout<<s.myAtoi("-5530")<<endl;
    cout<<s.myAtoi("  -0012a42")<<endl;
    cout<<s.myAtoi("   +0 123")<<endl;
    cout<<s.myAtoi("2147483648")<<endl;
    cout<<s.myAtoi("-2147483649")<<endl;
    cout<<s.myAtoi("-2147483649")<<endl;
    return 0;
}