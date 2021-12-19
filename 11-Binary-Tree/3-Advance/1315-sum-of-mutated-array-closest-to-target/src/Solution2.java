public class Solution2 {

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 10_0000;

        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int sum = calculateSum(arr, mid);
            // 计算最后一个严格小于 target 的阈值
            if (sum >= target) {
                // 大于等于的就不是解
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        // 比较阈值线分别定在 left 和 left + 1 的时候与 target 的接近程度
        int sum1 = calculateSum(arr, left);
        int sum2 = calculateSum(arr, left + 1);
        if (target - sum1 <= sum2 - target) {
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