package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 5:47 PM
 */
public class BubbleSort implements ISortingAlgorithm {

    @Override
    public String toString() {
        return "冒泡排序";
    }

    /**
     * 冒泡排序是可以提前终止
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            // 在区间 [0, i] 中两两比较，如果遇到一个逆序对，交换它们
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortingUtil.swap(arr, j, j + 1);
                }
                // 变量 j 始终指向 [0, j] ，即当前循环中看到的最大者
            }
            // 内层循环结束以后，区间 [i, len - 1] 有序
        }
    }

    public static void main(String[] args) {
        // 面对数组长度为 10 万的排序任务，冒泡排序的时间是秒级的
        // 在我的机子上每一次的运行时间大概是 18 秒
        // 越大规模的排序任务，交换的次数越多，因此整体不如选择排序效果好
        // SortingUtil.testSortingAlgorithm(new BubbleSort(), new GenerateRandomArrayStrategy(10_0000));

        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(10000),
                new SelectionSort(),
                new BubbleSort());
    }
}