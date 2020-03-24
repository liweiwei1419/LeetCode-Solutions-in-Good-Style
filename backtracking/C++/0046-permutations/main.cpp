#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    vector<vector<int>> res;
    vector<bool> used;

    void dfs(const vector<int> &nums, int size, int depth, vector<int> &path) {
        if (depth == size) {
            res.push_back(path);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (used[i]) {
                continue;
            }

            path.push_back(nums[i]);
            used[i] = true;
            dfs(nums, size, depth + 1, path);
            used[i] = false;
            path.pop_back();
        }
    }


public:
    vector<vector<int>> permute(vector<int> &nums) {
        res.clear();

        int size = nums.size();
        if (size == 0) {
            return res;
        }

        used = vector<bool>(size, false);
        vector<int> path;
        dfs(nums, size, 0, path);
        return res;
    }
};
