public class Solution5 {

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // 定义
        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len) = 2

        // 初始化
        int zero = 0;
        int i = 0;
        int two = len ;

        // 循环终止的条件是 i == two

        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, zero, i);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}