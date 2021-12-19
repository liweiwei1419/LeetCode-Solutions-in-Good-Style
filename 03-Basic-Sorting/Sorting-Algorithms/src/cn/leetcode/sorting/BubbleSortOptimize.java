package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 5:50 PM
 */
public class BubbleSortOptimize implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "冒泡排序的优化";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            // 我们先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较
            // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortingUtil.swap(arr, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // SortingUtil.testSortingAlgorithm(new BubbleSortOptimize(), new GenerateRandomArrayStrategy(1_0000));
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(1_0000),
                new SelectionSort(),
                new BubbleSort(),
                new BubbleSortOptimize());
    }
}