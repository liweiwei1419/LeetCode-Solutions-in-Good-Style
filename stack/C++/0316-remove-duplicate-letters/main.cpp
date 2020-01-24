#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
public:
    string removeDuplicateLetters(string s) {
        size_t size = s.size();
        if (size < 2) {
            return s;
        }

        bool used[26];
        for (bool &i : used) {
            i = false;
        }

        int lastAppearIndex[26];
        for (int i = 0; i < size; i++) {
            lastAppearIndex[s[i] - 'a'] = i;
        }

        stack<char> st;
        st.push('a');

        for (int i = 0; i < size; i++) {
            if (used[s[i] - 'a']) {
                continue;
            }

            while (st.top() > s[i] && lastAppearIndex[st.top() - 'a'] >= i) {
                char top = st.top();
                st.pop();
                used[top - 'a'] = false;
            }

            st.push(s[i]);
            used[s[i] - 'a'] = true;
        }

        string res;
        size_t stackSize = st.size();
        for (int i = 0; i < stackSize - 1; ++i) {
            res += st.top();
            st.pop();
        }

        reverse(res.begin(), res.end());
        return res;
    }
};

int main() {
    string s = "cbacdcbc";
    Solution solution = Solution();
    string res = solution.removeDuplicateLetters(s);
    cout << res << endl;
    return 0;
}