import java.util.Arrays;

public class MergeSort3 {

    private int[] temp;

    /**
     * 自底向上的归并排序
     * @param arr
     */
    public void sort(int[] arr) {
        int len = arr.length;
        temp = new int[len];
        // sz = 1, 2, 4, 8
        for (int sz = 1; sz < len; sz *= 2) {
            for (int left = 0; left < len; left += 2 * sz) {
                mergeOfTwoSortArray(arr, left, left + sz - 1, Integer.min(len - 1, left + 2 * sz - 1));
            }
        }
    }

    /**
     * 这一步与自顶向下的归并排序无异
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            // 闭区间，所以 right 这个索引也要赋值
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
        MergeSort3 mergeSort3 = new MergeSort3();
        mergeSort3.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
