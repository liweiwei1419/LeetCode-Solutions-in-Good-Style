import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>(len);
        for (int num : nums) {
            hashSet.add(num);
        }

        int res = 0;

        for (int num : hashSet) {
            if (hashSet.contains(num - 1)) {
                continue;
            }

            int cnt = 1;

            while (hashSet.contains(num + 1)) {
                cnt++;
                num++;
            }

            res = Math.max(res, cnt);
        }
        return res;
    }
}
