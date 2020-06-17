import java.util.Arrays;

public class Solution4 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int len = arr.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = arr[i] + preSum[i];
        }

        // 边界情况，提前处理。可以去掉，对后续逻辑没有影响
        if (preSum[len] <= target) {
            return arr[len - 1];
        }

        // 取值的左边界
        int left = target / len;
        // 取值的右边界
        int right = arr[len - 1];
        // 记录结果
        int[] res = new int[2];
        // 初始化。res[0]表示结果，res[1]表示与目标值的差值的绝对值
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MAX_VALUE;

        // 开始二分查找
        while (left < right) {
            // 根据题意，应该要找左边界
            int mid = (left + right) >>> 1;
            // 找到arr中，最右边的小于等于mid的下标（右边界）
            int index = findRightMost(arr, mid);
            // 计算和
            int total = preSum[index + 1] + mid * (len - 1 - index);
            // 计算差值的绝对值
            int delta = Math.abs(total - target);
            // 记录绝对差值最小时，对应的结果
            if (delta < res[1] || (delta == res[1] && mid < res[0])) {
                res[0] = mid;
                res[1] = delta;
            }
            // 左边界，排除。total值应该随mid单调递增
            if (total < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 后处理
        // return Math.min(res[0], left);
        return res[0];
    }

    // 找到小于等于 target 时的右边界
    int findRightMost(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // 右边界
            int mid = (left + right + 1) >>> 1;
            // 右边界，排除
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 需要做后处理
        if (arr[left] <= target) {
            return left;
        }
        // 说明 arr 中所有值都大于 target
        return -1;
    }
}
