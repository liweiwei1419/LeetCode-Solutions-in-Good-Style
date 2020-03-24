#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    int directions[4][2] = {{0,  1},
                            {1,  0},
                            {0,  -1},
                            {-1, 0}};

    bool inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    void dfs(vector<vector<char>> &grid, int i, int j, int m, int n, vector<vector<bool>> &marked) {
        marked[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY, m, n) && !marked[newX][newY] && grid[newX][newY] == '1'){
                dfs(grid, newX, newY, m, n, marked);
            }
        }
    }

public:
    int numIslands(vector<vector<char>> &grid) {
        int m = grid.size();
        if (m == 0) {
            return 0;
        }
        int n = grid[0].size();
        if (n == 0) {
            return 0;
        }
        vector<vector<bool>> marked;
        for (int i = 0; i < m; i++) {
            marked.push_back(vector<bool>(n, false));
        }

        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1' && !marked[i][j]) {
                    dfs(grid, i, j, m, n, marked);
                    res++;
                }
        return res;
    }
};

int main() {
    char g1[4][5] = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
    };
    vector<vector<char>> grid1;
    for (int i = 0; i < 4; i++) {
        grid1.push_back(vector<char>(g1[i], g1[i] + sizeof(g1[i]) / sizeof(char)));
    }

    Solution solution = Solution();
    cout << solution.numIslands(grid1) << endl;

    char g2[4][5] = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    vector<vector<char>> grid2;
    for (int i = 0; i < 4; i++) {
        grid2.push_back(vector<char>(g2[i], g2[i] + sizeof(g2[i]) / sizeof(char)));
    }

    cout << solution.numIslands(grid2) << endl;
}