public class Solution2 {

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        // 注意：
        for (int num : arr) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int sum = calculateSum(arr, mid);
            // 计算最后 1 个使得转变以后数组的和小于等于 target 的阈值 threshold
            if (sum > target) {
                // 大于等于的就不是解，threshold 太大了，下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid, right]
                left = mid;
            }
        }

        // 比较阈值线分别定在 left 和 left + 1 的时候与 target 的接近程度
        int sum1 = calculateSum(arr, left);
        int sum2 = calculateSum(arr, left + 1);
        // 注意：这里必须加绝对值，因为有可能出现 sum1 == sum2 < target 的情况
        if (Math.abs(target - sum1) <= Math.abs(sum2 - target)) {
            return left;
        }
        return left + 1;
    }

    private int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }
}