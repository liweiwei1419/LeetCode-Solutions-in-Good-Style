/**
 * @author liweiwei1419
 * @date 2019/10/12 8:21 下午
 */
public class Solution5 {

    // 选择排序

    /**
     * 时间复杂度：O(N^2)，N 是数组的长度
     * 空间复杂度：O(1)，只使用了常数个变量
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            // 选择 [i, len - 1] 里最小的元素的索引
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
