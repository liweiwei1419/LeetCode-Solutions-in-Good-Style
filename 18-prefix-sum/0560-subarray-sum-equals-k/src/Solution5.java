import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 区间 [i..j] 的和：preSum[i + 1] - preSum[j] = k

        // key: 前缀和 value：在下标 i 之前的前缀和的个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(preSum[i + 1] - k)) {
                res += map.get(preSum[i + 1] - k);
            }
            map.put(preSum[i + 1], map.getOrDefault(preSum[i + 1], 0) + 1);
            
        }
        return res;
    }
}