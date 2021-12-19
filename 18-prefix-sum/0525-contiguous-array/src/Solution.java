import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        // 下标 0 之前的位置是 -1，注意：可以理解为哨兵
        map.put(0, -1);

        int res = 0;
        int preSum = 0;

        // 把数组中的 0 都看成 -1
        for (int i = 0; i < len; i++) {
            // pre 是先加了，所以后面计算的时候是 i - map.get(preSum)
            if (nums[i] == 1) {
                preSum += 1;
            } else {
                preSum += -1;
            }

            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                // 注意：只记录这个数字第 1 次出现的下标
                map.put(preSum, i);
            }
        }
        return res;
    }
}