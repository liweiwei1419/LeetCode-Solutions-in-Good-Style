#include <iostream>
#include <vector>


using namespace std;

class Solution {
private:
    class UnionFind {
    private:
        vector<int> parent;
    public:
        UnionFind(int n) : parent(n) {
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void merge(int x, int y) {
            parent[find(x)] = find(y);
        }
    };

public:
    int regionsBySlashes(vector<string> &grid) {
        int size = grid.size();
        int total = 4 * size * size;
        UnionFind unionFind(total);

        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                int index = 4 * (row * size + col);

                switch (grid[row][col]) {
                    case '/':
                        unionFind.merge(index + 0, index + 3);
                        unionFind.merge(index + 1, index + 2);
                        break;
                    case '\\':
                        unionFind.merge(index + 0, index + 1);
                        unionFind.merge(index + 2, index + 3);
                        break;
                    case ' ':
                        unionFind.merge(index + 0, index + 1);
                        unionFind.merge(index + 1, index + 2);
                        unionFind.merge(index + 2, index + 3);
                        break;
                    default:
                        break;
                }

                if (row + 1 < size) {
                    unionFind.merge(index + 2, index + 4 * size + 0);

                }
                if (col + 1 < size) {
                    unionFind.merge(index + 1, index + 4 + 3);
                }

            }

        }

        int res = 0;
        for (int i = 0; i < total; ++i) {
            if (unionFind.find(i) == i) {
                res++;
            }
        }
        return res;
    }
};

