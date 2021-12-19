import java.util.Arrays;

public class MergeSort1 {

    /**
     * 自顶向下的归并排序实现 1
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int len = arr.length;
        mergeSort(arr, 0, len - 1);
    }

    /**
     * 递归调用的函数的定义是：对 arr 在 [left,right] 这个区间范围内使用归并排序。
     * 即：对 arr 数组在索引 [left,right] 这个区间内的元素进行归并排序
     * 特别注意：区间的边界 left 和 right 都是可以取到的
     *
     * @param arr
     * @param left
     * @param right
     */
    private void mergeSort(int[] arr, int left, int right) {
        // 先处理递归到底的情况，即递归终止条件：
        // 1、不形成区间：left > right;
        // 2、形成的区间长度为 1 ：left = right，此时没有必要去"分"，也无法"分"
        if (left >= right) {
            return;
        }
        // 然后将区间二分（下面的这个写法有 bug，但不容易被发现）
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeOfTwoSortArray(arr, left, mid, right);
    }

    /**
     * 注意：我们要维护此时归并排序的定义
     * 把两个已经排好序的数组进行归并
     * arr[left, mid] 是排好序的
     * arr[mid+1, right] 是排好序的
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        // 要借助额外的辅助数组空间帮助排序（可不可以每次不 new 呢？）
        // right - left + 1 表示这个区间的长度
        // 这里是待优化的地方，每一次合并都要 new 一个数组，开销大
        int[] temp = new int[right - left + 1];
        for (int i = 0; i < right - left + 1; i++) {
            temp[i] = arr[left + i];
        }
        // 数组 temp 前面那个数组的起始位置
        int i = 0;
        // 数组 temp 后面那个数组的起始位置
        int j = mid - left + 1;
        // 循环遍历把 arr 在 [left,right] 这个区间重新赋值
        for (int k = 0; k < right - left + 1; k++) {
            if (i > mid - left) {
                arr[left + k] = temp[j];
                j++;
            } else if (j > right - left) {
                arr[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 取 i
                arr[left + k] = temp[i];
                i++;
            } else {
                arr[left + k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {8, 4, 3, 6, 5, 1, 7, 2};
        MergeSort1 mergeSort1 = new MergeSort1();
        mergeSort1.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
