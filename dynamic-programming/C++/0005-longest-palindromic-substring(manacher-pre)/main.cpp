#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {

private:

    int centerSpread(string s, int center) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int len = s.size();
        int i = center - 1;
        int j = center + 1;
        int step = 0;
        while (i >= 0 && j < len && s[i] == s[j]) {
            i--;
            j++;
            step++;
        }
        return step;
    }

public:


    string longestPalindrome(string s) {
        // 特判
        int size = s.size();
        if (size < 2) {
            return s;
        }

        // 得到预处理字符串
        string str = "#";
        for (int i = 0; i < s.size(); ++i) {
            str += s[i];
            str += "#";
        }
        int sSize = 2 * size + 1;
        int maxLen = 1;

        int start = 0;
        for (int i = 0; i < sSize; i++) {
            int curLen = centerSpread(str, i);
            if (curLen > maxLen) {
                maxLen = curLen;
                start = (i - maxLen) / 2;
            }
        }
        return s.substr(start, maxLen);
    }
};

