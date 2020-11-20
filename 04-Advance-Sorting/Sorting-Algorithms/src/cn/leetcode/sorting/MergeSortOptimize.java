package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/8 4:32 AM
 */
public class MergeSortOptimize implements ISortingAlgorithm {

    /**
     * 列表大小等于或小于该大小，将优先于 mergesort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;


    /**
     * 全局使用一个数组用于归并
     */
    private int[] temp;

    @Override
    public String toString() {
        return "归并排序（优化）";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        temp = new int[len];
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }
        // int mid = left + (right - left) / 2;
        int mid = (left + right) >>> 1;

        // 定义 [left, mid] 有序，[mid + 1, right] 有序
        // mid 是前有序区间的右端点，这个定义就决定了 mergeOfTwoSortArray 方法的编写
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        mergeOfTwoSortArray(arr, left, mid, right);
    }

    /**
     * 对数组给定的部分使用插入排序
     *
     * @param arr   给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] arr, int left, int right) {
        // 第 1 遍不用插入，所以是总长度减去 1
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i;
            while (j > left && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private void mergeOfTwoSortArray(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        // System.arraycopy(nums, left, buff, left, len);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里严格上说应该写成 <=，否则就变成了非稳定排序
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        SortingUtil.testSortingAlgorithm(new MergeSortOptimize(), new GenerateRandomArrayStrategy(100_0000));

        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(100_0000),
                new MergeSort(),
                new MergeSortOptimize());
    }
}