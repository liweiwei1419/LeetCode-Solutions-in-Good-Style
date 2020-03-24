#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        if (p.empty()) {
            return s.empty();
        }
        bool firstMacth = !s.empty() && (s[0] == p[0] || p[0] == '.');
        if (p.size() > 1 && p[1] == '*') {
            if (isMatch(s, p.substr(2))) {
                return true;
            }
            return firstMacth && isMatch(s.substr(1), p);
        }
        return firstMacth && isMatch(s.substr(1), p.substr(1));
    }
};