import java.util.Arrays;

public class Solution2 {

    // 希尔排序

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int h = 1;

        // 使用 Knuth 增量序列，找增量的最大值
        while (3 * h + 1 < len) {
            h = 3 * h + 1;
        }

        System.out.println(h);

        while (h >= 1) {
            // insertion sort
            for (int i = h; i < len; i++) {
                insertionForDelta(nums, h, i);
            }
            h = h / 3;
        }
        return nums;
    }

    /**
     * 将 nums[i] 插入到对应分组的正确位置上，其实就是将原来 1 的部分改成 gap
     *
     * @param nums
     * @param gap
     * @param i
     */
    private void insertionForDelta(int[] nums, int gap, int i) {
        int temp = nums[i];
        int j = i;
        // 注意：这里 j >= deta 的原因
        while (j >= gap && nums[j - gap] > temp) {
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{8,6,10,9,5,1,4,2,7,3};
        solution.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}

