import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 方法三：
    // 时间复杂度：O(N)，只看了数组一遍
    // 空间复杂度：O(N)
    // 100(1), 4(4),200(1),1(4),3(2),2(0)

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        // key：nums[i] 中的数值
        // value：以 nums[i] 为边界的「连续」数组的长度，只有边界才有意义
        Map<Integer, Integer> hashMap = new HashMap<>(len);

        int res = 1;
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                continue;
            }

            Integer leftBound = hashMap.get(num - 1);
            Integer rightBound = hashMap.get(num + 1);

            if (leftBound == null && rightBound == null) {
                hashMap.put(num, 1);
            } else if (leftBound != null && rightBound != null) {
                int longestLen = leftBound + rightBound + 1;
                res = Math.max(res, longestLen);

                // num 只需要占一个位置即可，num - leftBound 和 num + rightBound 的定义需要准确
                hashMap.put(num, 0);
                hashMap.put(num - leftBound, longestLen);
                hashMap.put(num + rightBound, longestLen);
            } else if (leftBound == null) {
                int longestLen = rightBound + 1;
                res = Math.max(res, longestLen);

                hashMap.put(num, longestLen);
                hashMap.put(num + rightBound, longestLen);
            } else {
                // rightBound == null
                int longestLen = leftBound + 1;
                res = Math.max(res, longestLen);

                hashMap.put(num, longestLen);
                hashMap.put(num - leftBound, longestLen);
            }
        }
        return res;
    }
}