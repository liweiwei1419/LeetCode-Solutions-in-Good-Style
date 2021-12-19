public class Solution2 {

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // all in [0, p0] == 0
        // all in (p0, i) == 1
        // all in [p2, len - 1] == 2
        int p0 = -1;
        int i = 0;
        int p2 = len;

        while (i < p2) {
            if (nums[i] == 0) {
                p0++;
                swap(nums, i, p0);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 2
                p2--;
                swap(nums, i , p2);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}