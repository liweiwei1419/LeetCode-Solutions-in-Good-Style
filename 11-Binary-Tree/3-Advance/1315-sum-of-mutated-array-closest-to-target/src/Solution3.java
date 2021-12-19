import javax.sound.midi.Soundbank;

public class Solution3 {

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 10_0000;

        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int sum = calculateSum(arr, mid);

            // 调试代码
            System.out.println("left = " + left + ", right = " + right + ", sum = " + sum);

            // 计算第 1 个严格大于 target 的阈值
            if (sum <= target) {
                // 小于等于就不是解
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        // 比较阈值线分别定在 left 和 left + 1 的时候与 target 的接近程度
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    private int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] arr = {2, 3, 5};
        int target = 10;
        int res = solution3.findBestValue(arr, target);
        System.out.println(res);
    }
}