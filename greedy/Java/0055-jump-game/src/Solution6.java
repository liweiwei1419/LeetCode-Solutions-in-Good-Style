public class Solution6 {

    public boolean canJump(int[] nums) {
        boolean enable = true;
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (enable && nums[i] > 0) {
                last = i;
            } else if (i + nums[i] < last) {
                enable = false;
            } else {
                enable = true;
                last = i;
            }
        }
        return enable;
    }

}
