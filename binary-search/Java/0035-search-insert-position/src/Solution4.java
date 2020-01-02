/**
 * @author liweiwei1419
 * @date 2019/11/19 4:21 下午
 */
public class Solution4 {
    public int searchInsert(int[] nums, int target) {
        // 建议：即使是相同类型的变量，也分行声明（非必需，是编码规范）
        int left = 0;
        int right = nums.length;
        // nums.length 不可能小于 0，当 nums.length == 0 成立的时候，插入的位置应该是 0
        // 建议：即使只有一行语句，也要加大括号，避免采用单行的编码方式（非必需，只是编码规范，仅供参考）
        if (nums.length == 0) {
            return 0;
        }
        while (left < right) {
            // 建议：mid 声明在循环体内，虽然多次使用，但是 mid 仅仅只需要在循环体内存在
            // 声明在外面，扩大了变量的作用域（这一条可讨论）
            int mid = left + (right - left) / 2;

            // 主要问题：当 nums[mid] == target 的时候，不应该被合并到 nums[mid] < target 的情况
            // 根据题意，返回任意一个 nums[mid] == target 的索引即可
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
