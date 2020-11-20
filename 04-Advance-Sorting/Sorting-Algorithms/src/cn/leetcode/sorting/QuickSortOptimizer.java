package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateNearlySortedArrayStrategy;
import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/9 2:35 PM
 */
public class QuickSortOptimizer implements ISortingAlgorithm {

    public static final int INSERTION_SORT_THRESHOLD = 47;

    @Override
    public String toString() {
        return "快速排序优化";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    private int partition(int[] nums, int left, int right) {


        int p = nums[left];
        int k = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < p) {
                k++;
                SortingUtil.swap(nums, i, k);
            }
        }
        SortingUtil.swap(nums, left, k);
        return k;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 优化 2 ：小数组的时候，使用插入排序
        if (left >= right) {
            return;
        }
//        if (right - left <= INSERTION_SORT_THRESHOLD) {
//            insertionSort(nums, left, right);
//            return;
//        }
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    /**
     * @param nums
     * @param left
     * @param right
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        SortingUtil.testSortingAlgorithm(new QuickSortOptimizer(), new GenerateRandomArrayStrategy(100_0000));

        SortingUtil.compareSortingAlgorithms(new GenerateNearlySortedArrayStrategy(100_0000, 0.99),
                new QuickSort(),
                new QuickSortOptimizer());

        SortingUtil.compareSortingAlgorithms(new GenerateNearlySortedArrayStrategy(100_0000, 0.99),
                new MergeSortOptimize(),
                new QuickSortOptimizer());

//        SortingUtil.compareSortingAlgorithms(new GenerateNearlySortedArrayStrategy(1000_0000,0.95),
//                new QuickSort(),
//                new QuickSortOptimizer());
    }
}