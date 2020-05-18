import java.util.Arrays;
import java.util.Random;

public class Solution8 {

    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        int target = len - k;

        int left = 0;
        int right = len - 1;
        while (true) {
            int pIndex = partition(nums, left, right);

            if (pIndex == target) {
                return nums[pIndex];
            } else if (pIndex < target) {
                // 下一轮搜索区间 [pIndex + 1, right]
                left = pIndex + 1;
            } else {
                // pIndex > target
                // 下一轮搜索区间 [left, pIndex - 1]
                right = pIndex - 1;
            }
        }

    }

    private int partition(int[] nums, int left, int right) {
        // 注意点 2：必须随机化
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int pivot = nums[left];
        // [left + 1 .. le] <= pivot
        // (le, i] > pivot
        // 注意点 1：一定要设置成 left ，否则交换会出错
        int le = left;
        for (int i = left + 1; i <= right; i++) {
            // 这里写 < 或者 <= 都可以
            if (nums[i] <= pivot) {
                le++;
                swap(nums, le, i);
            }
        }

        swap(nums, left, le);
        return le;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
