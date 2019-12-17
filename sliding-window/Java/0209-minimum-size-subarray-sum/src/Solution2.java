/**
 * @author liwei
 */
public class Solution2 {

    public int minSubArrayLen(int s, int[] nums) {
        // 构造前缀和数组，使用二分查找算法
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 构造前缀和数组
        // 因为 nums 全都是正整数，因此 preSum 严格单调增加
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        // 因为前缀和数组严格单调增加，因此我们可以使用二分查找算法
        // 最后一位没有下一位了，所以外层遍历到最后一位的前一位就可以了
        int minLen = len + 1;
        for (int i = 0; i < len - 1; i++) {
            // 计算区间和
            int l = i;
            int r = len - 1;
            // 设置成一个比较大的数，但是这个数有下界
            // i 的最大值是 len-2,
            // curTarget - i + 1 >= len + 1
            // curTarget >= i + len = 2 * len -2
            int curTarget = 2 * len - 2;
            // int curTarget = 2 * len - 1; 能通过
            // int curTarget = 2 * len - 3; 不能通过
            // 退出循环的条件是 l > r
            while (l <= r) {
                int mid = l + (r - l) / 2;
                // 计算一下区间和，找一个位置，使得这个位置到索引 i 的区间和为 s
                // 13 14 15 17 19 20
                int segmentSum = preSum[mid] - (i == 0 ? 0 : preSum[i - 1]);
                if (segmentSum >= s) {
                    curTarget = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            minLen = Math.min(minLen, curTarget - i + 1);
        }
        // 如果不存在符合条件的连续子数组，返回 0。
        if (minLen == len + 1) {
            return 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        Solution2 solution2 = new Solution2();
        int minSubArrayLen = solution2.minSubArrayLen(s, nums);
        System.out.println(minSubArrayLen);
    }
}
