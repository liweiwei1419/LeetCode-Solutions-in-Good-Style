import java.util.Random;

public class Solution14 {

    private Random random = new Random(System.currentTimeMillis());


    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、[left + 1, j] < nums[left]
     * 2、(j, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点

        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);


        int lp = left;
        int rp = right;
        int pivot = nums[left];
        while (lp < rp) {
            while (nums[rp] >= pivot && lp < rp) {
                rp--;
            }
            while (nums[lp] <= pivot && lp < rp) {
                lp++;
            }

            swap(nums, lp, rp);
        }
        swap(nums, lp, left);
        return lp;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
