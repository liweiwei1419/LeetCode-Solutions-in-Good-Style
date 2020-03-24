import java.util.TreeSet;

/**
 * @author liwei
 * @date 2019/7/11 9:34 AM
 */
public class Solution4 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        // 特判
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }

        // 泛型类型为 Long 是提交失败以后看到测试用例以后改的
        TreeSet<Long> set = new TreeSet<>();

        // 一个一个加进去
        for (int i = 0; i < len; i++) {
            // 检测逻辑：
            // 以当前数为中心，向左边扩展，看看 set 里有没有大于等于 nums[i] - t 的元素
            // 大于等于 nums[i] - t ，在这个数上面，故使用天花板函数 ceiling

            Long ceiling = set.ceiling((long) nums[i] - t);
            // 在 nums[i] 为中心，半径为 t 的左边有元素
            // 因此直接返回 true 即可
            if (ceiling != null && ceiling <= nums[i]) {
                return true;
            }

            // 以当前数为中心，向左边扩展，看看 set 里有没有小于等于 nums[i] + t 的元素
            // 小于等于 nums[i] + t ，在这个数下面，故使用地板函数 floor
            Long floor = set.floor((long) nums[i] + t);
            // 在 nums[i] 为中心，半径为 t 的右边有元素
            // 因此直接返回 true 即可
            if (floor != null && nums[i] <= floor) {
                return true;
            }

            // 加进去的逻辑
            set.add((long) nums[i]);
            // 当 k = 3 时，[0,1,2,3,4]，i = 3 的时候就要把 i = 0 删掉了
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        // 遍历以后都找不到符合题意的数据对，就只能返回 False
        return false;
    }
}
