import java.util.HashMap;
import java.util.Map;

/**
 * @author liweiwei1419
 * @date 2019/11/3 3:18 下午
 */
public class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        if (k <= 0 || len == 0 || len < k) {
            return 0;
        }

        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] & 1);
        }
        // 最多只需要 len 个，因此最后一个位置不用记录
        // 创建哈希表的时候，不用指定哈希表的大小，但编码规范建议在知道的情况下指定
        Map<Integer, Integer> map = new HashMap<>(len);
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i < len + 1; i++) {
            // 如果 preSum[i] - k 是负值，也不会包含在 map 中
            if (map.containsKey(preSum[i] - k)) {
                res += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        Solution solution = new Solution();
        int k = 2;
        int res = solution.numberOfSubarrays(nums, k);
        System.out.println(res);
    }
}
