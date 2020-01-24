#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {

private:
    void dfs(TreeNode *node, int level, vector<int> &res) {
        if (node == NULL) {
            return;
        }

        if (res.size() == level) {
            res.push_back(node->val);
        } else {
            res[level] = max(res[level], node->val);
        }
        dfs(node->left, level + 1, res);
        dfs(node->right, level + 1, res);
    }


public:
    vector<int> largestValues(TreeNode *root) {
        vector<int> res;
        dfs(root, 0, res);
        return res;
    }
};