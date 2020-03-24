import java.util.TreeSet;

public class Solution2 {

    // 推荐的写法

    /**
     * 10             20     30   ,t = 3
     * 12   15  18
     * 15  18     21
     *
     * @param nums
     * @param k    k 是索引之间的最大差值
     * @param t    是两个数值之间的最大差值
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            // 向右扩展看地板
            Long floor = set.floor((long) nums[i] + t);
            if ((floor != null && floor >= nums[i])) {
                return true;
            }

            // 向左扩展看天花板

            Long ceiling = set.ceiling((long) nums[i] - t);
            if ((ceiling != null && ceiling <= nums[i])) {
                return true;
            }

            // 下面两步先后顺序无所谓
            set.add((long) nums[i]);
            if (set.size() == (k + 1)) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        // 极端条件判断
        int len = nums.length;
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Long floor = treeSet.floor((long) nums[i] + t);
            if ((floor != null && floor >= nums[i])) {
                return true;
            }

            Long ceiling = treeSet.ceiling((long) nums[i] - t);
            if ((ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            // 超过 k 的时候，就要移除之前的元素
            // k = 3
            // 0,1,2,3
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
            treeSet.add((long) nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        Solution2 solution2 = new Solution2();
        boolean containsNearbyAlmostDuplicate = solution2.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(containsNearbyAlmostDuplicate);
    }
}
