package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 5:44 PM
 */
public class InsertionSortOptimize2 implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "插入排序（优化的等价写法）";
    }

    /**
     * 与 InsertionSortOptimize 等价的写法
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int j = i - 1;
            // 每次看当前的那个元素，所以边界是 j >= 0
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        // 因为与 InsertionSortOptimize 等价，所以只需验证正确性
        // 在 10 万这个规模下，1 秒左右就可以完成排序任务
        SortingUtil.testSortingAlgorithm(new InsertionSortOptimize2(), new GenerateRandomArrayStrategy(10_0000));
    }
}