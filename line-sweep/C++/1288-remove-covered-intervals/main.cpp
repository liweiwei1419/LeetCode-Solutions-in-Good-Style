#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    // 当区间左端点相同的时候，按照右端点降序排序
    static bool cmp(vector<int> &a, vector<int> &b) {
        if (a[0] == b[0]) {
            return a[1] > b[1];
        }
        return a[0] < b[0];
    }

public:
    int removeCoveredIntervals(vector<vector<int>> &intervals) {
        int size = intervals.size();
        sort(intervals.begin(), intervals.end(), cmp);
        int maxRight = intervals[0][1];
        int remove = 0;
        for (int i = 1; i < size; ++i) {
            if (intervals[i][1] <= maxRight) {
                remove++;
            } else {
                maxRight = intervals[i][1];
            }
        }
        return size - remove;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}