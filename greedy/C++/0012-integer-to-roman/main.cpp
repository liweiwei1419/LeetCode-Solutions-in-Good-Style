#include <iostream>
#include <string>

using namespace std;


class Solution {
public:

    // 个位
    string bit1[10]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    // 十位
    string bit10[10]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    // 百位
    string bit100[10]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    // 千位
    string bit1000[4]{"", "M", "MM", "MMM"};

    string intToRoman(int num) {
        return bit1000[num / 1000] + bit100[num % 1000 / 100] + bit10[num % 100 / 10] + bit1[num % 10];
    }
};