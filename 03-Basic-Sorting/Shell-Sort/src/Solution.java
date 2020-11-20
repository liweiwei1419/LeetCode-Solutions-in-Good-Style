import java.util.Arrays;

public class Solution {

    // 「力扣」第 912 题：排序数组：https://leetcode-cn.com/problems/sort-an-array/
    // 希尔排序，使用 Shell 建议的序列 N/2,N/4,...,2,1

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int h = 1;

        int gap = len / 2;
        while (gap >= 1) {
            // 缩小增量的插入排序
            for (int i = h; i < len; i++) {
                insertionForDelta(nums, h, i);
            }
            gap /= 2;
        }
        return nums;
    }

    /**
     * 将 nums[end] 插入到对应分组的正确位置上，其实就是将原来 1 的部分改成 gap
     *
     * @param nums
     * @param gap  间隔
     * @param end
     */
    private void insertionForDelta(int[] nums, int gap, int end) {
        int temp = nums[end];
        int j = end;
        while (j >= gap && nums[j - gap] > temp) {
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{8, 6, 10, 9, 5, 1, 4, 2, 7, 3};
        solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}