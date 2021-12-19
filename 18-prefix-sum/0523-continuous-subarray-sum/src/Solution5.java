import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    // 转换为连续子区间的元素总和为 k 的倍数
    // 前缀和对 k 同余，那么子区间的和就是 k 的倍数
    // 前缀和 1：ak + d
    // 前缀和 2：bk + d
    // 区间和：（b - a）k

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        int preSum = 0;
        for (int i = 0; i < len; i++) {
            preSum = (preSum + nums[i]) % k;
            if (hashMap.containsKey(preSum)) {
                if (i - hashMap.get(preSum) > 1) {
                    return true;
                }
            } else {
                hashMap.put(preSum, i);
            }
        }
        return false;
    }
}