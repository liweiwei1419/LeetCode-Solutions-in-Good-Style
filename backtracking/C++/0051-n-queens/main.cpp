#include <iostream>
#include <vector>

using namespace std;


class Solution {

private:
    vector<bool> col;
    vector<bool> master; // 主对角线
    vector<bool> slave; // 副对角线
    vector<vector<string>> res;

    void backtracking(int row, int n, vector<int> &stack) {
        if (row == n) {

            res.push_back(convert2board(n, stack));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (!col[i] && !master[row + i] and !slave[row - i + n - 1]) {
                stack.push_back(i);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;

                backtracking(row + 1, n, stack);

                col[i] = false;
                slave[row - i + n - 1] = false;
                master[row + i] = false;
                stack.pop_back();
            }
        }
    }

    vector<string> convert2board(int n, vector<int> &stack) {
        vector<string> board(n, string(n, '.'));
        for (int i = 0; i < n; ++i) {
            board[i][stack[i]] = 'Q';
        }
        return board;
    }

public:
    vector<vector<string>> solveNQueens(int n) {
        for (int i = 0; i < n; ++i) {
            col.push_back(false);
        }

        // 对角线上的元素个数
        int diaNums = 2 * n - 1;
        for (int i = 0; i < diaNums; ++i) {
            master.push_back(false);
            slave.push_back(false);
        }

        vector<int> stack;
        backtracking(0, n, stack);
        return res;
    }
};

int main() {
    int n = 4;
    vector<vector<string>> res = Solution().solveNQueens(n);
    for (vector<string> board: res) {
        for (string row: board) {
            std::cout << row << std::endl;
        }
        std::cout << std::endl;
    }
}