import java.util.Arrays;


public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // 循环不变量：[0, j）是移除重复元素以后的数组
        int j = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j - 1]) {
                // 注意顺序：先更新值，再递增脚标
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        Solution solution = new Solution();
        int ret = solution.removeDuplicates(nums);
        System.out.println(ret);
        System.out.println(Arrays.toString(nums));
    }
}
