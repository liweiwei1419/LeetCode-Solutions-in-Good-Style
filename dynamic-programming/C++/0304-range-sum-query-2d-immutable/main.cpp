#include <iostream>
#include <vector>

using namespace std;

class NumMatrix {

private:
    vector<vector<int>> preSum;
public:
    NumMatrix(vector<vector<int>> &matrix) {
        int rows = matrix.size();
        if (rows == 0) {
            return;
        }

        int cols = matrix[0].size();
        if (cols == 0) {
            return;
        }

        preSum.resize(rows + 1, vector<int>(cols + 1, 0));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + matrix[i][j];
            }
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1]
               - preSum[row1][col2 + 1]
               - preSum[row2 + 1][col1]
               + preSum[row1][col1];
    }
};