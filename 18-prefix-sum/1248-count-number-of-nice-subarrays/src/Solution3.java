import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 连续子区间恰好有 k 个奇数
    // 把奇数当作 1 ，偶数当作 0
    // 区间和为 k
    // 每一个前缀和与之前前缀和为 preSum - k 的数构成了区间和为 k 的连续子数组

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int preSum = 0;
        // key：前缀和，value：次数
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            preSum += nums[i] & 1;
            if (preSum >= k) {
                res += hashMap.getOrDefault(preSum - k, 0);
            }
            hashMap.put(preSum, hashMap.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}