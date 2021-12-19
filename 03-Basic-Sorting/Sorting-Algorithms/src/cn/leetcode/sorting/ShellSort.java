package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.examples.GenerateReversedArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/8 2:15 AM
 */
public class ShellSort implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "希尔排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        int h = 1;

        // 使用 Knuth 增量序列
        // 找增量的最大值
        while (3 * h + 1 < len) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                insertionForDelta(arr, h, i);
            }
            h = h / 3;
        }
    }

    /**
     * 将 arr[i] 插入到对应分组的正确位置上，其实就是将原来 1 的部分改成 gap
     *
     * @param arr
     * @param gap
     * @param i
     */
    private void insertionForDelta(int[] arr, int gap, int i) {
        int temp = arr[i];
        int j = i;
        // 注意：这里 j >= deta 的原因
        while (j >= gap && arr[j - gap] > temp) {
            arr[j] = arr[j - gap];
            j -= gap;
        }
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 1、有效性测试
        SortingUtil.testSortingAlgorithm(new ShellSort(), new GenerateRandomArrayStrategy(88573));

//        // 2、对比测试
//        SortingUtil.compareSortingAlgorithms(new GenerateReversedArrayStrategy(10_0000),
//                new InsertionSortOptimize2(),
//                new ShellSort());

    }
}