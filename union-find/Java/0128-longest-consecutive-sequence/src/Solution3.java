import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 时间复杂度：O(N)，只看了数组一遍
    // 空间复杂度：O(N)

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

        System.out.println(hashMap);
        return res;
    }

    // 100(1), 4(4),200(1),1(4),3(2),2(0)

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};

        // int[] nums = new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        // int[] nums = new int[]{1, 2, 0, 1};
        int res = solution3.longestConsecutive(nums);
        System.out.println(res);
    }
}
