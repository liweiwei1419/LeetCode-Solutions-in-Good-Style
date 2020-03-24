#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int size = s.size();
        if (size < 2) {
            return size;
        }

        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;
        int freq[128] = {0};
        while (right < size) {
            if (freq[s[right]] == 1) {
                count++;
            }
            freq[s[right]]++;
            right++;
            while (count > 0) {
                if (freq[s[left]] == 2) {
                    count--;
                }
                freq[s[left]]--;
                left++;
            }
            res = max(res, right - left);
        }
        return res;
    }
};

