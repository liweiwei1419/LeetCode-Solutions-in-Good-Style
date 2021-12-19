import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    // 把 0 看成 -1，区间和等于 0 的最长长度就是题目要求的长度
    // 为什么用哈希表要解释清楚

    public int findMaxLength(int[] nums) {
        int len = nums.length;

        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        int preSum = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                preSum--;
            } else {
                preSum++;
            }

            if (!hashMap.containsKey(preSum)) {
                hashMap.put(preSum, i);
            } else {
                // 因为求的是最长的长度，只记录前缀和第一次出现的下标，
                // 注意：这里不需要加 1
                res = Math.max(res, i - hashMap.get(preSum));
            }
        }
        return res;
    }
}