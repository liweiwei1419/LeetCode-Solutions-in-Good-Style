package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 5:44 PM
 */
public class InsertionSort implements ISortingAlgorithm {

    @Override
    public String toString() {
        return "插入排序";
    }

    @Override
    public void sort(int[] arr) {
        // 把数组的长度暂存起来
        int len = arr.length;
        // 注意边界值，从索引 1 开始，逐个插入到之前的有序数组
        for (int i = 1; i < len; i++) {
            // 从当前位置向前看，看到严格小的时候才交换
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    // 只要前面的元素严格小就交换，否则退出循环，这里的 break 很重要
                    SortingUtil.swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 验证插入排序算法的正确性
        SortingUtil.testSortingAlgorithm(new InsertionSort());

        // 一点一点增大
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(100),
                new SelectionSort(),
                new InsertionSort());

        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(1000),
                new SelectionSort(),
                new InsertionSort());


        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(10000),
                new SelectionSort(),
                new InsertionSort());
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(10_0000),
                new SelectionSort(),
                new InsertionSort());
    }
}
