#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    vector<int> parent;

    int getIndex(int n, int row, int col) {
        return row * (n + 1) + col;
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    int merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return 1;
        }

        parent[rootY] = rootX;
        return 0;
    }

public:
    int regionsBySlashes(vector<string> &grid) {
        int n = grid.size();
        parent = vector<int>((n + 1) * (n + 1));

        for (int row = 0; row < n + 1; ++row) {
            for (int col = 0; col < n + 1; ++col) {
                parent[getIndex(n, row, col)] =
                        (row == 0 || row == n ||
                         col == 0 || col == n) ? 0 : getIndex(n, row, col);
            }
        }

        int res = 1;
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                if (grid[row][col] == ' ') {
                    continue;
                }
                if (grid[row][col] == '/') {
                    res += merge(getIndex(n, row, col + 1),
                                 getIndex(n, row + 1, col));
                } else {
                    res += merge(getIndex(n, row, col),
                                 getIndex(n, row + 1, col + 1));
                }

            }

        }
        return res;
    }
};

