import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    // 方法二：哈希表
    // 时间复杂度：O(N)，每一个数会被看 3 遍
    // 空间复杂度：O(N)

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        // 除了快速查找，还有去重的效果，如果有很多起点，会重复计算
        Set<Integer> hashSet = new HashSet<>(len);
        for (int num : nums) {
            hashSet.add(num);
        }

        // 最长连续子序列的长度
        int res = 0;
        for (int num : hashSet) {
            // 关键：保证连续序列的起点最小
            if (hashSet.contains(num - 1)) {
                continue;
            }

            int longestLen = 1;
            // 遍历找出以 num 为起点的间隔为 1 的最长连续子序列
            while (hashSet.contains(num + 1)) {
                longestLen++;
                num++;
            }

            res = Math.max(res, longestLen);
        }
        return res;
    }
}