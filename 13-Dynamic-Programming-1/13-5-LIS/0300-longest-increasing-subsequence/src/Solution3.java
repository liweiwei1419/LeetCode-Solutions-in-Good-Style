public class Solution3 {

    // 方法二：动态规划：二分 + 贪心

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        // tail[i]：所有长度为 i + 1 的上升子序列的结尾数字
        int[] tail = new int[len];
        tail[0] = nums[0];

        // 数组 tail 非空部分的最后一个数的下标（从 0 开始）
        int end = 0;
        for (int i = 1; i < len; i++) {
            int left = 0;
            int right = end + 1;
            // 找第 1 个大于等于 nums[i] 的位置，更新它
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 小于 nums[i] 一定不是解
                if (tail[mid] < nums[i]) {
                    // 下一轮搜索区间为 [mid + 1, right]
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tail[left] = nums[i];
            if (left == end + 1) {
                end++;
            }
        }
        return end + 1;
    }
}