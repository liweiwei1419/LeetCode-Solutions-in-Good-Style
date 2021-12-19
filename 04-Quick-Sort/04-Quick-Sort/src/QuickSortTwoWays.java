import java.util.Arrays;
import java.util.Random;

/**
 * 指针对撞的双路快速排序：将与标定点相等的元素等概率分散到递归函数的两边
 * 当有很多重复值的时候，避免递归树倾斜
 */
public class QuickSortTwoWays {

    private static final Random RANDOM = new Random();

    private void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    // 3, 4, 6, 2, 1, 8, 5, 7
    // 3, 1, 6, 2, 4, 8, 5, 7
    // 3, 1, 2, 6, 4, 8, 5, 7
    // 2, 1, 3, 6, 4, 8, 5, 7

    /**
     * 这个定义非常重要，直接影响我们的算法初始值定义
     * [left + 1, i) 全部小于标定点
     * (j, right] 全部大于标定点
     * 在指针对撞的过程中，和标定点相同的元素就被挤到了中间
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] arr, int left, int right) {
        int randonIndex = left + RANDOM.nextInt(right - left + 1);
        swap(arr, randonIndex, left);

        int povit = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && arr[i] < povit) {
                i++;
            }
            while (j >= left && arr[j] > povit) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, left, j);
        return j;
    }


    private void quickSort(int[] arr, int left, int right) {
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
        QuickSortTwoWays quickSortTwoWays = new QuickSortTwoWays();
        quickSortTwoWays.sort(nums);
        System.out.println(Arrays.toString(nums));
        SortHelper.checkSorted(nums);
    }
}
