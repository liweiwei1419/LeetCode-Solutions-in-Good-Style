#include <iostream>
#include <vector>

using namespace std;


class Solution {

private:
    vector<vector<int>> res;
    vector<int> candidates;
    vector<int> path;
    long len;

    void dfs(int start, int residue) {
        if (residue == 0) {
            res.push_back(path);
            return;
        }

        for (int i = start; i < len; ++i) {
            if (residue - candidates[i] < 0) {
                break;
            }
            path.push_back(candidates[i]);
            dfs(i, residue - candidates[i]);
            path.pop_back();
        }
    }

public:
    vector<vector<int>> combinationSum(vector<int> &candidates, int target) {
        this->candidates = candidates;
        sort(this->candidates.begin(), this->candidates.end());
        this->len = candidates.size();
        dfs(0, target);
        return res;
    }
};

int main() {
    Solution solution = Solution();
    vector<int> candidates;
    candidates.push_back(2);
    candidates.push_back(3);
    candidates.push_back(6);
    candidates.push_back(7);

    vector<vector<int>> res = solution.combinationSum(candidates, 7);

    // 使用索引遍历
    int i, j;
    cout << "Use index : " << endl;
    for (i = 0; i < res.size(); i++) {
        for (j = 0; j < res[0].size(); j++)
            cout << res[i][j] << " ";
        cout << endl;
    }

    // 使用迭代器遍历
    vector<int>::iterator it;
    vector<vector<int>>::iterator iter;
    vector<int> vec_tmp;

    cout << "Use iterator : " << endl;
    for (iter = res.begin(); iter != res.end(); iter++) {
        vec_tmp = *iter;
        for (it = vec_tmp.begin(); it != vec_tmp.end(); it++)
            cout << *it << " ";
        cout << endl;
    }

    return 0;
}