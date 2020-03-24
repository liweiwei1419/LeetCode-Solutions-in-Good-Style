import java.util.HashSet;
import java.util.Set;

/**
 * 使用 hash 表进行检查
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean success = set.add(num);
            if (!success) {
                // 如果没有添加成功，表示有重复元素，直接返回就可以了
                return true;
            }
        }
        return false;
    }
}
