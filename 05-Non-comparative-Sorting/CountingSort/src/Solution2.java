public class Solution2 {

    // 计数排序（非稳定）

    private static final int OFFSET = 50000;

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int size = 10_0000;

        // 计数数组
        int[] count = new int[size];
        count[0] = 0;
        // 计算计数数组
        for (int num : nums) {
            count[num + OFFSET]++;
        }

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index] = i - OFFSET;
                index++;
            }
        }
        return nums;
    }
}