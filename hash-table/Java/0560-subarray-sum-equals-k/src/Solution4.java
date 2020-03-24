import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        // 剩余值为 0 的时候设置为 1 ，这是因为 1 是乘法的单位元
        hash.put(0, 1);

        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            if (hash.containsKey(sum - k)) {
                res += hash.get(sum - k);
            }
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
