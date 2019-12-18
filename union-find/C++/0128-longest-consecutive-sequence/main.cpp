#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int longestConsecutive(vector<int> &nums) {
        unordered_set<int> hashSet;

        // 哈希表起到了去重复的效果
        for (int num: nums) {
            hashSet.insert(num);
        }

        int res = 0;
        for (int num:hashSet) {
            if (num != INT_MIN && hashSet.count(num - 1)) {
                continue;
            }

            int count = 1;

            while (num != INT_MAX && hashSet.count(num + 1)) {
                count++;
                num++;
            }
            res = max(res, count);
        }
        return res;
    }
};