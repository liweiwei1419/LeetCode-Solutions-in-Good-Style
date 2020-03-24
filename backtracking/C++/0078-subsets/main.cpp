#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int> &nums) {
        // 输出要求有序
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        vector<int> path;
        subsets(nums, path, 0, result);
        return result;
    }

private:
    void subsets(const vector<int> &nums, vector<int> &path, int step,
                 vector<vector<int>> &result) {
        if (step == nums.size()) {
            result.push_back(path);
            return;
        }
        // 不选择 nums[step]
        subsets(nums, path, step + 1, result);
        path.push_back(nums[step]);

        // 选择 nums[step]
        subsets(nums, path, step + 1, result);
        path.pop_back();
    }
};