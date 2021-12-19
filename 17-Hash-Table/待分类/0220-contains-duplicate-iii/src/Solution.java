import java.util.TreeSet;

public class Solution {

    // 滑动窗口

    // |nums[i] - nums[j]| <= k <=>
    // nums[i] - nums[j] <= k && nums[i] - nums[j] >= -k
    // nums[i] <= k + nums[j]
    // nums[i] >= nums[j] - k

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {

            // 地板函数，找大于等于 nums[i] - t 的那个数
            Long ceiling = treeSet.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }

            treeSet.add((long) nums[i]);

            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}