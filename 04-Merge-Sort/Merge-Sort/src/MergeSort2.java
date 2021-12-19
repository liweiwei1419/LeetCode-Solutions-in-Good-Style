import java.util.Arrays;

public class MergeSort2 {

    /**
     * 用于合并两个有序数组的辅助数组，使用它是为了避免每次归并都重复开辟空间
     * 它的长度，就是数组的长度，每次只用它的一部分，直到最后一次归并，使用它的全部
     */
    private int[] temp;


    /**
     * 自顶向下的归并排序实现 2
     * @param arr
     */
    public void sort(int[] arr) {
        int len = arr.length;
        temp = new int[len];
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        // 优化1：在小数组排序的时候，直接使用插入排序
        if (right - left <= 15) {
            insertSort(arr, left, right);
            return;
        }

        // 修复1：为了防止计算 int mid = (left + right) / 2; 整形溢出，应该像下面这样计算 mid
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // 优化2：如果 arr 数组已经前后有序（前面数组中的最后一个元素不大于后面数组中的第 1 个元素）
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }

        mergeOfTwoSortArray(arr, left, mid, right);
    }

    /**
     * 对数组给定的部分使用插入排序
     * 注意：这个插入排序算法的设计是要能实现在区间范围内的插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertSort(int[] arr, int left, int right) {
        // 第 1 遍不用插入，所以是总长度减去 1
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= left; j--) {
                if (arr[j] > temp) {
                    // 后移一位
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        // 优化3：使用一个全局的辅助数组，避免每次都开辟新的内存空间去优化，这样做反而编程实现更简单，不用考虑索引的偏移
        // 因为是闭区间，所以 right 这个索引也要赋值
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        // temp 的 [left,mid] 有序
        // temp 的 [mid+1,right] 有序，现在要将它们整理成有序，放回 arr 中，一个一个放就好了
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            // i 用完
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > right) {
                // j 用完
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {8, 4, 3, 6, 5, 1, 7, 2};
        MergeSort2 mergeSort2 = new MergeSort2();
        mergeSort2.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
