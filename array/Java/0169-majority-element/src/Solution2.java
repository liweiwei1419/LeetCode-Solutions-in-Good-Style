import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liwei
 * @date 18/6/29 下午4:50
 */
public class Solution2 {
    /**
     * [0,1,2,3]
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int half = len / 2;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                // 反正都是要 + 1 的
                if (count + 1 > half) {
                    return num;
                }
                map.put(num, count + 1);
            }
        }
        throw new RuntimeException("数组中不存在众数！");
    }
}
