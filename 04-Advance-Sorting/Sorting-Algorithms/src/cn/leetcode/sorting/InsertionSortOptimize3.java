package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 5:44 PM
 */
public class InsertionSortOptimize3 implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "插入排序（使用哨兵）";
    }

    /**
     * 与 InsertionSortOptimize 等价的写法
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;

        // 哨兵思想，把整个数组中最小的元素放置在数组的开头，
        // 可以去掉下面 while 循环中 j > 0 的判断
        // 哨兵思想是一种常见的编码技巧，恰当使用哨兵可以：
        // ① 避免边界条件的判断；②减少分类讨论的分支
        // 在单链表的问题中经常使用
        int minIndex = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        SortingUtil.swap(arr, 0, minIndex);
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        // 在 10 万这个规模下，1 秒左右就可以完成排序任务
        // SortingUtil.testSortingAlgorithm(new InsertionSortOptimize3(), new GenerateRandomArrayStrategy(10_0000));
        SortingUtil.compareSortingAlgorithms(
                new GenerateRandomArrayStrategy(10_0000),
                new InsertionSortOptimize(),
                new InsertionSortOptimize3());
    }
}