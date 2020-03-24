import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/description/
 * 参考资料：https://www.jianshu.com/p/45d7c879f4bf
 *
 * 使用了红黑树（一种特殊的二分查找树）的功能：查询天花板和地板，解决了这个问题。
 *
 */
public class Solution {

    // 这个解法不好理解

    /**
     * 要考虑到整型越界问题，所以要使用长整型
     *
     * @param nums
     * @param k    索引差：使用 TreeSet，使得 TreeSet 一共就存 k 个元素
     * @param t    数值的差
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        // 这里是或者
        if (len <= 1 || k <= 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        int i = 0;
        while (i < len) {
            // 找不符合题目要求的情况
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            boolean hasFloor = floor != null && nums[i] - floor <= t;
            boolean hasCeiling = ceiling != null && ceiling - nums[i] <= t;

            if (hasFloor || hasCeiling) {
                return true;
            }
            // 注意，这里应该取等号，因为前面在判断的时候，就相当于已经把元素加进去了
            // 而且从 nums[i - k] 表达式中也可以看出
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
            // 每一次都加入元素
            set.add((long) nums[i]);
            System.out.println("集合" + set);
            i++;
        }
        return false;
    }

    // 这个解法最好理解

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int len = nums.length;
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Integer ceiling = treeSet.ceiling(nums[i]);
            if (ceiling != null && (long) ceiling - (long) nums[i] <= t) {
                return true;
            }
            Integer floor = treeSet.floor(nums[i]);
            if (floor != null && (long) nums[i] - (long) floor <= t) {
                return true;
            }
            treeSet.add(nums[i]);
            if (i >= k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,0,2};
        int k = 2;
        int t = 2;
        Solution solution = new Solution();
        boolean containsNearbyAlmostDuplicate = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(containsNearbyAlmostDuplicate);

        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        System.out.println((low + high) / 2);
        System.out.println((low + high) >>> 1);

    }
}
