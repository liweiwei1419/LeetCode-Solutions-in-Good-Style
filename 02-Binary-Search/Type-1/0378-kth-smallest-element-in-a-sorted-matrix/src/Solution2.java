public class Solution2 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            // 从头到尾，数一下小于等于 mid 的个数
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                    } else {
                        break;
                    }
                }
            }

            // 小于等于 mid 的元素个数严格小于 k 个，说明 mid 不是第 k 小的元素的值，
            // 真正第 k 小的数值比 mid 严格大
            if (count < k) {
                // 下一轮搜索区间 [mid + 1..right]
                left = mid + 1;
            } else if (count == k) {
                // 下一轮搜索区间 [left..mid]
                right = mid;
            } else {
                // 小于等于 mid 的元素个数严格大于 k 个，说明 mid 太大了，下一轮要缩小
                // 下一轮搜索区间 [left..mid - 1]
                right = mid - 1;
            }
        }
        return left;
    }
}