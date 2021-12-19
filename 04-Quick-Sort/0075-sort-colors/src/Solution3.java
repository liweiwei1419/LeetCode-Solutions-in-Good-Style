public class Solution3 {

    /**
     * 循环不变量：
     * all in [0, zero] = 0
     * all in (zero, i) = 1
     * all in (two, len - 1] = 2
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int zero = -1;
        int two = len - 1;
        // 循环结束的时候 i = two + 1
        for (int i = 0; i <= two; ) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // assert nums[i] == 2;
                swap(nums, i, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}