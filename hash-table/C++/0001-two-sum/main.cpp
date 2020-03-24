#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> hash;
        for (int i = 0; i < nums.size(); ++i) {
            if (hash.count(target - nums[i])) {
                return {hash[target - nums[i]], i};
            }
            hash[nums[i]] = i;
        }
        // 这一行一定要加上，否则不能通过
        return {-1, -1};
    }
};