#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string toHexspeak(string num) {
        string strHex;
        long long llNum = std::strtoll(num.c_str(), 0, 10);
        while (llNum > 0) {
            size_t nMod = llNum % 16;
            if (nMod > 1 && nMod < 10)
                return strHex = string("ERROR");
            else if (nMod == 0)
                strHex.push_back('O');
            else if (nMod == 1)
                strHex.push_back('I');
            else
                strHex.push_back(char('A' + nMod - 10));

            llNum /= 16;
        }

        std::reverse(strHex.begin(), strHex.end());
        return strHex;
    }
};

