package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/9 2:35 PM
 */
public class QuickSortThreeWays implements ISortingAlgorithm {

    public static final int INSERTION_SORT_THRESHOLD = 47;

    @Override
    public String toString() {
        return "三路快排";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertSort(arr, left, right);
            return;
        }
        int randomIndex = left + SortingUtil.RANDOM.nextInt(right - left + 1);
        SortingUtil.swap(arr, randomIndex, left);

        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) = pivot
        // all in [gt, right] > pivot
        int pivot = arr[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            if (arr[i] < pivot) {
                lt++;
                SortingUtil.swap(arr, i, lt);
                i++;
            } else if (arr[i] == pivot) {
                i++;
            } else {
                gt--;
                SortingUtil.swap(arr, i, gt);
            }
        }
        SortingUtil.swap(arr, left, lt);
        // 注意这里，大大减少了分治的区间
        quickSort(arr, left, lt - 1);
        quickSort(arr, gt, right);
    }


    /**
     * @param nums
     * @param left
     * @param right
     */
    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                // 后移一位
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        SortingUtil.testSortingAlgorithm(new QuickSortThreeWays());

        SortingUtil.testSortingAlgorithm(new QuickSortTwoWays());

        // 针对有大量重复元素的排序任务，三路快排效果显著
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(1000_0000, 1, 10),
                // new QuickSortOptimizer(),
                new QuickSortTwoWays(),
                new QuickSortThreeWays());
    }
}