import java.util.Arrays;
import java.util.Random;

public class QuickSortThreeWays {

    private static Random random = new Random();

    private void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    // 3, 4, 3, 6, 3, 2, 1, 8, 5, 7
    // [left + 1,l] 是小于 p 的部分
    // [l + 1, i) 是等于 p 的部分
    // [r,right] 是大于 p 的部分

    private void quickSort(int[] arr, int left, int right) {
        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }
        // [3,4,5]
        int randonIndex = left + random.nextInt(right - left + 1);
        swap(arr, randonIndex, left);

        int povit = arr[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (arr[i] < povit) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i] == povit) {
                i++;
            } else {
                gt--;
                swap(arr, i, gt);
            }
        }
        swap(arr, left, lt);
        // 注意这里，大大减少了分治的区间
        quickSort(arr, left, lt - 1);
        quickSort(arr, gt, right);
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
        if (index1 == index2) {
            return;
        }
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }


    public static void main(String[] args) {
        int[] nums = SortHelper.generateRandomArray(20, 1, 100);
        QuickSortThreeWays quickSortThreeWays = new QuickSortThreeWays();
        quickSortThreeWays.sort(nums);
        System.out.println(Arrays.toString(nums));
        SortHelper.checkSorted(nums);
    }
}
