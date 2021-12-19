public class Solution {

    public int minTime(int[] time, int m) {
        int sum = 0;
        for (int num : time) {
            sum += num;
        }

        // 一天中做题的时间，搜索的范围是 [0, sum]
        int left = 0;
        int right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // mid 是 T 值的意思
            int days = split(time, mid);
            if (days > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * @param nums
     * @param maxSum 限制一天中做题的时间最多是 maxSum
     * @return 做完刷题计划中的题目需要多少天
     */
    private int split(int[] nums, long maxSum) {
        int len = nums.length;
        int days = 1;
        int curMax = nums[0];
        int tempSum = nums[0];
        for (int i = 1; i < len; i++) {
            // 当前区间里耗时最多的题目
            curMax = Math.max(curMax, nums[i]);
            // 即使耗时最多的题目留给小杨做，都超出了 maxSum，就还需要新的一天，做剩下的题目
            if (tempSum + nums[i] - curMax > maxSum) {
                // 新的一天，各种变量需要重置
                tempSum = 0;
                curMax = nums[i];
                days++;
            }
            tempSum += nums[i];
        }
        return days;
    }
}