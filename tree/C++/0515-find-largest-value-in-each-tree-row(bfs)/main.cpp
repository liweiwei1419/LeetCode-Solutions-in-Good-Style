#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {


public:
    vector<int> largestValues(TreeNode *root) {
        vector<int> res;
        if (root == NULL) {
            return res;
        }

        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty()) {
            int maxVal = INT_MIN;
            size_t size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode *node = q.front();
                q.pop();

                maxVal = max(maxVal, node->val);
                if (node->left) {
                    q.push(node->left);
                }
                if (node->right) {
                    q.push(node->right);
                }
            }
            res.push_back(maxVal);
        }
        return res;
    }
};

