package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 5:44 PM
 */
public class InsertionSort2 implements ISortingAlgorithm {

    @Override
    public String toString() {
        return "插入排序（等价写法）";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        // 第 1 轮的时候，索引为 0 的那个数认为是排好序的
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                SortingUtil.swap(arr, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        SortingUtil.testSortingAlgorithm(new InsertionSort2(), new GenerateRandomArrayStrategy(10_0000));
    }
}