package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/28 9:49 下午
 */
public class MergeSortBottomUp implements ISortingAlgorithm {

    /**
     * 列表大小等于或小于该大小，将优先于 mergesort 使用插入排序
     */
    private static final int INSERTIONSORT_THRESHOLD = 7;

    private int[] temp;

    @Override
    public String toString() {
        return "自底向上的归并排序";
    }

    /**
     * 自底向上的归并排序没有了递归的栈调用
     * 要特别注意边界值的选取
     * [0,1,2,3,4,5,6,7]
     *
     * @param arr 待排序数组
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        temp = new int[len];
        // sz = 1, 2, 4, 8
        for (int sz = 1; sz < len; sz *= 2) {
            // left = 0, 2, 4, 6
            for (int left = 0; left < len - sz; left += 2 * sz) {
                mergeOfTwoSortArray(arr, left, left + sz - 1, Integer.min(left + sz + sz - 1, len - 1));
            }
        }
    }

    /**
     * 这一步与自顶向下的归并排序无异
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        if (right - left <= INSERTIONSORT_THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                arr[k] = temp[j];
                j++;
            } else if (j == right + 1) {
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

    public static void main(String[] args) {
        // SortingUtil.testSortingAlgorithm(new MergeSortBottomUp());
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(1000_0000),
                new MergeSortBottomUp(),
                new MergeSortOptimize());
    }
}