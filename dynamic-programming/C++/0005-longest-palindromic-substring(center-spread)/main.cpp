#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {

private:

    string centerSpread(string s, int left, int right) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int size = s.size();
        int i = left;
        int j = right;
        while (i >= 0 && j < size) {
            if (s[i] == s[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substr(i + 1, j - i - 1);
    }

public:


    string longestPalindrome(string s) {
        // 特判
        int size = s.size();
        if (size < 2) {
            return s;
        }

        int maxLen = 1;
        string res = s.substr(0, 1);

        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < size - 1; i++) {
            string oddStr = centerSpread(s, i, i);
            string evenStr = centerSpread(s, i, i + 1);
            string maxLenStr = oddStr.size() > evenStr.size() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.size();
                res = maxLenStr;
            }
        }
        return res;
    }
};

