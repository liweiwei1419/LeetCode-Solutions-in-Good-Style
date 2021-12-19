import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        // key：区间 [0..i) 里所有元素的和 % k 的余数
        // value：下标 i
        Map<Integer, Integer> map = new HashMap<>();
        // 理解初始化的意义，-1 是下标，可以认为是哨兵
        map.put(0, -1);

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum)) {
                // 根据题目要求长度大于 2，才返回 true
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}