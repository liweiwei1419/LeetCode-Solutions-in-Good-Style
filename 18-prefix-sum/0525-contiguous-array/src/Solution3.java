import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 这个问题看文档要好好整理一下，找相同的量
    // 把下标和值的关系放在一个哈希表里
    // 这个 想不明白

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(len);
        // 初始化 -1 的情况
        hashMap.put(1, -1);

        int res = 0;
        int preSum = 0;

        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            // 满足关系式 i + j = 2 * preSum
            int j = 2 * preSum - i;
            if (hashMap.containsKey(j)) {
                res = Math.max(res, i - hashMap.get(j));
            } else {
                // value 是下标，key 是什么不知道
                hashMap.put(j, i);
            }
        }
        // System.out.println(hashMap);
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = new int[]{1, 1, 1, 0, 1, 0, 1};
        int res = solution3.findMaxLength(nums);
        System.out.println(res);
    }
}