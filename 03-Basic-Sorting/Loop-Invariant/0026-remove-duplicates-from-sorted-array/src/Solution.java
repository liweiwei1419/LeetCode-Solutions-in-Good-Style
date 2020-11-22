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
                // 注意顺序：先更新值，再递增下标
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}