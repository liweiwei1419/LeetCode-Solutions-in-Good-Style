import java.util.Arrays;
import java.util.Random;

public class QuickSortOptimize {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    private int partition(int[] arr, int left, int right) {
        // 优化 1 ：随机选择一个点作为标定点
        int randonIndex = left + RANDOM.nextInt(right - left + 1);
        swap(arr, randonIndex, left);

        int p = arr[left];
        int k = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < p) {
                k++;
                swap(arr, i, k);
            }
        }
        swap(arr, left, k);
        return k;
    }

    private void quickSort(int[] arr, int left, int right) {
        // 优化 2 ：小数组的时候，使用插入排序
        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    private void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (arr[i - 1] <= arr[i]) {
                continue;
            }
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp) {
                // 后移一位
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20, 1, 100);
        QuickSortOptimize quickSortOptimize = new QuickSortOptimize();
        quickSortOptimize.sort(nums);
        System.out.println(Arrays.toString(nums));
        SortHelper.checkSorted(nums);
    }
}
