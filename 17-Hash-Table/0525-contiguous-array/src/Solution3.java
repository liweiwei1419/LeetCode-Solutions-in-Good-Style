import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 这个问题看文档要好好整理一下，找相同的量
    // 把下标和值的关系放在一个哈希表里

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(len);

        // 初始化 -1 的情况
        hashMap.put(2 * 0 + 1, -1);

        int res = 0;
        int countOne = 0;

        for (int i = 0; i < len; i++) {
            countOne += nums[i];

            // 满足关系式 i + j = 2 * countOne
            int j = 2 * countOne - i;
            if (hashMap.containsKey(j)) {
                res = Math.max(res, i - hashMap.get(j));
            } else {
                hashMap.put(j, i);
            }
        }
        return res;
    }
}