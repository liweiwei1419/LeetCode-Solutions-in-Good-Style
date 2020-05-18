import java.util.Random;

public class Solution13 {

    private static Random RANDOM = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;
        while (true) {
            int[] pIndex = partition(nums, left, right);

            int index1 = pIndex[0];
            int index2 = pIndex[1];

            if (target < index1) {
                // 下一轮搜索区间 [left, index1 - 1]
                right = index1 - 1;
            } else if (target == index1) {
                return nums[index1];
            } else if (target < index2) {
                left = index1 + 1;
                right = index2 - 1;
            } else if (target == index2) {
                return nums[index2];
            } else {
                // pIndex > target
                // 下一轮搜索区间 [index2 + 1, right]
                left = index2 + 1;
            }
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        // 循环不变量：
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) = pivot
        // all in [gt, right] > pivot
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, left, lt);
        // 这里要特别小心
        return new int[]{lt, gt - 1};
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
