public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // j 是马上要赋值的那个索引
        int j = 1;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] != pre) {
                nums[j] = nums[i];
                pre = nums[j];
                j++;
            }
        }
        return j;
    }
}