#include <iostream>
using namespace std;
class Solution {
public:
    	bool isPalindrome(int x) {
 		if (x < 0)
		{
			return false;
		}
		int dig = 1;
		while (x/dig > 9)
		{
			dig *= 10;
		}
		while (x != 0)
		{
			if (x/dig != x%10)
			{
				return false;
			}
			x %= dig;
			x /= 10;
			dig /= 100;
		}
		return true;
	}
};
int main()
{
	Solution s;
	cout<<"1: " <<s.isPalindrome(1)<<endl;
	cout<<"-121: " <<s.isPalindrome(-121)<<endl;
	cout<<"121: " <<s.isPalindrome(121)<<endl;
	cout<<"1221: " <<s.isPalindrome(1221)<<endl;
	cout<<"12211: " <<s.isPalindrome(12211)<<endl;
	cout<<"1001: " <<s.isPalindrome(1001)<<endl;
	return 0;
}
