#include <iostream>
#include <vector>

using namespace std;


class Solution {

private:
    int dx[4] = {0, 0, -1, 1};
    int dy[4] = {-1, 1, 0, 0};
    int rows;
    int cols;

    bool inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    void dfs(int x, int y, vector<vector<char>> &grid) {
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';

        for (int i = 0; i < 4; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (inArea(newX, newY) && grid[newX][newY] == '1') {
                dfs(newX, newY, grid);
            }
        }
    }

public:
    int numIslands(vector<vector<char>> &grid) {
        rows = grid.size();
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].size();
        if (cols == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }
};