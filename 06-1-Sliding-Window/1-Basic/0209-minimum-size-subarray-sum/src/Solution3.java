public class Solution3 {

    // 方法三：构造前缀和数组，使用二分查找算法

    public int minSubArrayLen(int s, int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 由于 nums 全都是正整数，因此 preSum 严格单调增加
        // preSum 表示 sum(nums[0..i))
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // System.out.println(Arrays.toString(preSum));
        int minLen = len + 1;
        // 遍历一次，找到和大于等于 s 的最大下标
        for (int i = 0; i < len; i++) {
            // 对于前缀和数组来说，有 1 个位置的偏移，找使得区间和 sum[left..right] >= s 的最大的 left
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                // 什么时候解我们不需要呢，sum(nums[mid..i]) < s
                if (preSum[i + 1] - preSum[mid] < s) {
                    // 下一轮搜索区间在 [left, mid - 1]
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

            // 这里后处理
            // System.out.println("left = " + left);
            // System.out.println("区间和 = " + (preSum[i + 1] - preSum[left]));
            if (preSum[i + 1] - preSum[left] >= s) {
                minLen = Math.min(minLen, i - left + 1);
            }
        }

        if (minLen == len + 1) {
            return 0;
        }
        return minLen;
    }
}