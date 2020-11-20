package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/8 4:32 AM
 */
public class MergeSortInPlace implements ISortingAlgorithm {

    /**
     * 列表大小等于或小于该大小，将优先于 mergesort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;


    @Override
    public String toString() {
        // 了解思想即可，不建议掌握
        return "归并排序（原地归并）";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        mergeSort(arr, 0, len - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }
        // int mid = left + (right - left) / 2;
        int mid = (left + right) >>> 1;
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

    /**
     * 注意：该实现编写繁琐，需要花很长时间调试，并且代码也没有技巧性，个人不建议花时间掌握，
     * 只需要知道原地排序虽然节约了空间，但是时间增加了，我们优化的方向通常是节约时间，用户也不太关心空间使用的效率
     *
     * @param arr
     * @param left
     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     */
    private void mergeOfTwoSortArray(int[] arr, int left, int mid, int right) {
        // 使用新变量 j，表示右有序区间的左端点，这个变量会变化
        int j = mid + 1;
        while (left < j && j <= right) {
            // 因为 j 指向了右有序区间的左端点，left == j 成立的时候，左区间没有元素，循环终止
            // 同理 j = right + 1 的时候，循环终止
            while (left < j && arr[left] <= arr[j]) {
                // <= 保证了稳定性
                left++;
            }
            // left 一旦移动，它前面的元素就确定了下来，即 left 是不回头的

            // 暂时存一下原来 j 的位置，rotate 的时候用
            int index = j;
            while (j <= right && arr[j] < arr[left]) {
                // [4, 5, 6, 10, 1, 2, 3, 11, 12]
                //           id           j
                j++;
            }
            rotate(arr, left, index, j - 1);
            left += (j - index);

            // 如果 j 前后正好有序，就退出循环
            if (j <= right && arr[j - 1] <= arr[j]) {
                break;
            }
        }
    }


    /**
     * 力扣第 189 题：旋转数组的思路，这里更直接，把旋转数组恢复成有序数组
     * 注意 mid 定义的位置
     *
     * @param arr
     * @param left
     * @param mid   [left, mid - 1] 有序，[mid, right] 有序
     * @param right
     */
    private void rotate(int[] arr, int left, int mid, int right) {
        reverse(arr, left, mid - 1);
        reverse(arr, mid, right);
        reverse(arr, left, right);
    }

    /**
     * 反转对数组在区间 [left, right] 内执行一次反转
     *
     * @param arr
     * @param left
     * @param right
     */
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        SortingUtil.testSortingAlgorithm(new MergeSortInPlace(), new GenerateRandomArrayStrategy(10_0000));

        // 明显非原地的归并排序要快很多
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(10_0000),
                new MergeSortOptimize(),
                new MergeSortInPlace());
    }
}