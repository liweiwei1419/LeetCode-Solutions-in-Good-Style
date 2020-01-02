import java.util.Random;

/**
 * @author liweiwei1419
 * @date 2019/10/9 6:03 下午
 */
public class Solution12 {

    private static final Random RANDOM = new Random();

    public int findKthLargest(int[] nums, int k) {
        // 第 k 大，索引为 len - k
        // 第 1 大，索引为 len - 1
        // 第 2 大，索引为 len - 2
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int targetIndex = len - k;
        while (left <= right) {
            int pIndex = partition(nums, left, right);
            if (pIndex == targetIndex) {
                return nums[pIndex];
            } else if (pIndex < targetIndex) {
                // [pIndex + 1, right]
                left = pIndex + 1;
            } else {
                // pIndex > targetIndex，[left, pIndex - 1]
                right = pIndex - 1;
            }
        }
        throw new IllegalArgumentException("参数出错！");
    }


    /**
     * [left + 1, i) <= pivot，
     * (j, right] >= pivot
     * 初始的时候，i = left + 1，j = right
     * 终止的时候，i = j + 1
     * [left + 1, j + 1) = [left + 1, j]
     * (j, right]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
            // i 来到第 1 个大于等于 pivot 的地方
            while (i <= j && nums[j] > pivot) {
                j--;
            }
            // j 来到第 1 个小于等于 pivot 的地方

            if (i == j || i == j + 1) {
                break;
            }

            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {99, 99};
        int k = 1;
        Solution solution = new Solution();
        int res = solution.findKthLargest(nums, k);
        System.out.println(res);
    }
}
