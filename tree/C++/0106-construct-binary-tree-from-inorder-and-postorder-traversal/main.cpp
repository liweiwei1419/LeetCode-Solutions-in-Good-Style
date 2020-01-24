#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:

    unordered_map<int, int> hash;

    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        int size = inorder.size();
        for (int i = 0; i < size; i++) {
            hash[inorder[i]] = i;
        }
        // 中序遍历的信息都存在 hash 里了
        return dfs(postorder, 0, size - 1, 0, size - 1);
    }

    /**
     *
     * @param postorder 中序遍历序列
     * @param inLeft 当前子树在中序遍历序列的左边界
     * @param inRight 当前子树在中序遍历序列的右边界
     * @param postLeft 当前子树在后序遍历序列的左边界
     * @param postRight 当前子树在后序遍历序列的右边界
     * @return
     */
    TreeNode *dfs(vector<int> &postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return NULL;
        }
        int pivot = postorder[postRight];
        int pivotIndex = hash[pivot];

        TreeNode *root = new TreeNode(pivot);
        root->left = dfs(postorder, inLeft, pivotIndex - 1, postLeft, pivotIndex - 1 - inLeft + postLeft);
        root->right = dfs(postorder, pivotIndex + 1, inRight, pivotIndex - inLeft + postLeft, postRight - 1);
        return root;
    }
};

