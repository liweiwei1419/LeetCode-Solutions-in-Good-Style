import java.util.Random;

public class Solution2 {

    /**
     * 静态常量命名的时候全部使用大写字母
     */
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] arr, int left, int right) {
        // 注意：这里包括 > 的情况，与归并排序不同，请通过调试理解这件事情
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        // 随机选择一个点作为标定点
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(arr, randomIndex, left);

        int pivot = arr[left];
        // 循环不变量： lt 意即 less than
        // [left + 1, lt] < pivot，
        // [lt + 1, i) >= pivot
        int lt = left;
        // 注意，这里取等号
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                // 交换当前元素与 lt 的位置
                lt++;
                swap(arr, i, lt);
            }
        }
        // 最后这一步要记得交换标定点位置
        swap(arr, left, lt);
        return lt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}