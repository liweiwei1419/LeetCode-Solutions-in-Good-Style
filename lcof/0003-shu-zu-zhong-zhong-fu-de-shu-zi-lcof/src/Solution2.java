public class Solution2 {

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = nums[i] % len;
            nums[index] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 2 * len) {
                return i;
            }
        }
        return -1;
    }
}
