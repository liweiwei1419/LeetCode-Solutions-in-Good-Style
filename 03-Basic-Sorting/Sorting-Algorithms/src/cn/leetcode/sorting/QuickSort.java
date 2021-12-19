package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateNearlySortedArrayStrategy;
import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.examples.GenerateReversedArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/9 1:53 PM
 */
public class QuickSort implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "快速排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    /**
     * @param arr
     * @param left  可以取到
     * @param right 可以取到
     */
    private void quickSort(int[] arr, int left, int right) {
        // 递归终止条件，一定要写，否则就变成死循环了
        // 待优化 2 ：小数组的时候，使用插入排序
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    /**
     * 将起始的元素作为标定点
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        // 优化 1 ：随机选择一个点作为标定点
        int randomIndex = left + SortingUtil.RANDOM.nextInt(right - left + 1);
        SortingUtil.swap(arr, randomIndex, left);
        // 待优化 1 ：随机选择一个点作为标定点
        int pivot = arr[left];
        // 循环不变式：
        // all in [left + 1, lt] < pivot，
        // all in [lt + 1, i) >= pivot
        int lt = left;
        // 注意，这里取等号
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                // 交换当前元素与 lt 的位置
                lt++;
                SortingUtil.swap(arr, i, lt);
            }
        }
        // 最后这一步要记得交换标定点位置
        SortingUtil.swap(arr, left, lt);
        return lt;
    }

    public static void main(String[] args) {
        // SortingUtil.testSortingAlgorithm(new QuickSort(), new GenerateRandomArrayStrategy(100_0000));

//        SortingUtil.compareSortingAlgorithms(
//                new GenerateRandomArrayStrategy(100_0000),
//                new MergeSortOptimize(),
//                new QuickSort());

        SortingUtil.compareSortingAlgorithms(
                new GenerateNearlySortedArrayStrategy(100_0000, 0.2),
                new MergeSortOptimize(),
                new QuickSort());

        SortingUtil.compareSortingAlgorithms(
                new GenerateNearlySortedArrayStrategy(100_0000, 0.99),
                new MergeSortOptimize(),
                new QuickSort());

        SortingUtil.compareSortingAlgorithms(
                new GenerateNearlySortedArrayStrategy(100_0000, 1.0),
                new MergeSortOptimize(),
                new QuickSort());
//
//        SortingUtil.compareSortingAlgorithms(
//                new GenerateReversedArrayStrategy(100_0000),
//                new MergeSortOptimize(),
//                new QuickSort());
    }
}