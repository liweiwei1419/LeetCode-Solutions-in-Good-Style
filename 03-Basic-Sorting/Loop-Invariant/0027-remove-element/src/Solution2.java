public class Solution2 {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int next = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[next] = nums[i];
                next++;
            }
        }
        return next;
    }
}