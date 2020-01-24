#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
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
        // 新字符串的长度
        int strSize = 2 * size + 1;
        // 数组 p 记录了扫描过的回文子串的信息
        vector<int> p(strSize, 0);

        // 双指针，它们是一一对应的，须同时更新
        int maxRight = 0;
        int center = 0;

        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;
        // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
        int start = 0;

        for (int i = 0; i < strSize; ++i) {
            if (i < maxRight) {
                int mirror = (2 * center) - i;
                // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                p[i] = min(maxRight - i, p[mirror]);
            }

            // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);

            // left >= 0 && right < sLen 保证不越界
            // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
            while (left >= 0 && right < strSize && str[left] == str[right]) {
                p[i]++;
                left--;
                right++;

            }

            // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > maxRight) {
                // maxRight 和 center 需要同时更新
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen) {
                // 记录最长回文子串的长度和相应它在原始字符串中的起点
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substr(start, maxLen);
    }
};
