public class Solution4 {

    public int findRepeatNumber(int[] nums) {
        int len = nums.length;


        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    swap(nums,i,nums[i]);
                }
            }

        }

        throw new IllegalArgumentException("数组中不存在重复数字！");

    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
