public class Solution2 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // j 是刚刚赋值完的索引
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}