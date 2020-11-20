package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/9/9 2:35 PM
 */
public class QuickSortTwoWays implements ISortingAlgorithm {

    public static final int INSERTION_SORT_THRESHOLD = 15;

    @Override
    public String toString() {
        return "双路快排";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        quickSort(arr, 0, len - 1);
    }

    /**
     * 目标：与切分元素相等的元素均匀地分布在切分元素最终所在位置的两侧
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
        int randomIndex = left + SortingUtil.RANDOM.nextInt(right - left + 1);
        SortingUtil.swap(arr, randomIndex, left);

        // 循环不变量，le = less equals，ge = great equals
        // all in [left + 1, le) <= pivot
        // all in (ge, right] >= pivot
        // le > ge 的时候终止
        int pivot = arr[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            // 注意：这里一定是 arr[le] < pivot，等于 pivot 的元素是被交换过来得到的
            while (le <= ge && arr[le] < pivot) {
                le++;
            }
            // 此时 le 来到第 1 个大于等于 pivot 的位置
            while (le <= ge && arr[ge] > pivot) {
                ge--;
            }
            // 此时 ge 来到第 1 个小于等于 pivot 的位置
            if (le > ge) {
                break;
            }

            SortingUtil.swap(arr, le, ge);
            le++;
            ge--;
        }
        SortingUtil.swap(arr, left, ge);
        return ge;
    }


    private void quickSort(int[] arr, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }
        int pIndex = partition(arr, left, right);
        quickSort(arr, left, pIndex - 1);
        quickSort(arr, pIndex + 1, right);
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    private void insertionSort(int[] arr, int left, int right) {
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

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 8, 1, 3, 2, 6};

        QuickSortTwoWays quickSortTwoWays = new QuickSortTwoWays();
        int ge = quickSortTwoWays.partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(ge);

        System.out.println("---");

        SortingUtil.testSortingAlgorithm(new QuickSortTwoWays());
        // 随机化这个技巧在有一种情况下是失效的

        // 针对有大量重复元素的排序任务，双路快排效果显著
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(1_00000, 1, 10),
                new QuickSortTwoWays(),
                new QuickSortThreeWays());
    }
}