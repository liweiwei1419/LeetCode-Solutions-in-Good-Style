import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxNonOverlapping(int[] nums, int target) {
        // 第 1 步：构造前缀和数组，以便快速计算区间和
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        // 意义：preSum[i] 表示下标 i 之前的元素之和
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 在当前下标的左边，与当前前缀和相差为 target 的下标
        int[] left = new int[len + 1];
        Arrays.fill(left, Integer.MAX_VALUE);

        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, 0);

        // 注意：下面所有的 i 的部分都看为 i + 1
        for (int i = 0; i < len; i++) {
            // 常见操作：last.containsKey(preSum[i + 1] - target 表示
            // 这一段的区间的和是 target
            if (last.containsKey(preSum[i + 1] - target)) {
                left[i + 1] = last.get(preSum[i + 1] - target);
            }
            last.put(preSum[i + 1], i + 1);
        }

        // 利用 left 数组找到最大值
        // dp[i] 到目前为止不重复子字符的最大长度
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            if (left[i + 1] < i + 1) {
                dp[i + 1] = Math.max(dp[i + 1], dp[left[i + 1]] + 1);
            }
        }
        return dp[len];
    }
}
