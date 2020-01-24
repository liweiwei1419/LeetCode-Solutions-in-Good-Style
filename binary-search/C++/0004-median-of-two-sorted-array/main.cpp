#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    void printVec(const vector<int> &vec) {
        for (int e: vec)
            cout << e << " ";
        cout << endl;
    }

public:
    vector<int> merge(vector<int> &nums1, vector<int> &nums2) {
        vector<int> newV;
        int m = nums1.size();
        int n = nums2.size();

        // INT_MAX 是哨兵元素，不会加入到合并以后的数组中
        nums1.push_back(INT_MAX);
        nums2.push_back(INT_MAX);

        int i = 0, j = 0;
        for (int k = 0; k < n + m; k++) {
            if (nums1[i] < nums2[j]) {
                newV.push_back(nums1[i]);
                i++;
            } else {
                newV.push_back(nums2[j]);
                j++;
            }
        }
        return newV;
    }

    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
        // 应该在合并之前把 nums1 和 nums2 的长度取到
        // 因为在合并以后，nums1 和 nums2 的长度各自都加了 1
        int m = nums1.size();
        int n = nums2.size();
        vector<int> ans = merge(nums1, nums2);

        // printVec(ans);

        // 需要根据合并之后的长度的奇偶性决定中位数
        // 可以在纸上画出具体例子，得到数组长度是奇数时，中位数下标是哪个
        // 数组长度是偶数时，中位数下标是哪两个

        if ((m + n) & 1) {
            // 如果是奇数，中位数是一个数，下标是 (n + m - 1) / 2
            // 合并以后的数组的最后一位的下标是 n + m - 1
            return (double) ans[(n + m - 1) / 2];
        } else {
            return (ans[(n + m - 1) / 2] + ans[(n + m - 1) / 2 + 1]) * 0.5;
        }
    }
};

void printVec(const vector<int> &vec) {
    for (int e: vec)
        cout << e << " ";
    cout << endl;
}


int main() {
    const int nums1[] = {1, 2};
    const int nums2[] = {3, 4};
    vector<int> nums_vec1(nums1, nums1 + sizeof(nums1) / sizeof(int));
    vector<int> nums_vec2(nums2, nums2 + sizeof(nums2) / sizeof(int));
    Solution solution = Solution();
    double res = solution.findMedianSortedArrays(nums_vec1, nums_vec2);

    cout << res << endl;
    return 0;
}
