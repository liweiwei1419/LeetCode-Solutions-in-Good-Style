package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 5:44 PM
 */
public class InsertionSortOptimize implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "插入排序（优化）";
    }

    /**
     * 为了避免多次交换，采用逐个右移的策略实现相同的效果
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // 先暂存当前要插入的那个数
            int temp = arr[i];
            // 一开始假设就放在 i 位置
            int j = i;
            // 每次看前面的那个元素，因此边界是 j > 0
            // 只要索引 j 位置前面的那个数严格小，就把前面那个数向后覆盖一位，否则就把要插入的那个数放在索引 j 位置
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        // 1、验证正确性
        SortingUtil.testSortingAlgorithm(new InsertionSortOptimize(), new GenerateRandomArrayStrategy(10_0000));

        // 2、测试优化的插入排序的性能
//        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(1_0000),
//                new SelectionSort(),
//                new InsertionSort(),
//                new InsertionSortOptimize());


        // 3、比较"选择排序"与"插入排序"
//        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(10_0000),
//                new SelectionSort(),
//                new InsertionSortOptimize());

        // 4、"插入排序"对于"接近有序的数组"时间复杂度可以达到 O(N)
        // 有序程度越好，插入排序的就越可以尽快完成排序任务
//        SortingUtil.testSortingAlgorithm(new InsertionSortOptimize(),
//                // 接近随机
//                new GenerateNearlySortedArrayStrategy(10_0000, 0.1));
//        SortingUtil.testSortingAlgorithm(new InsertionSortOptimize(),
//                // 半随机
//                new GenerateNearlySortedArrayStrategy(10_0000, 0.5));
//        SortingUtil.testSortingAlgorithm(new InsertionSortOptimize(),
//                // 接近有序
//                new GenerateNearlySortedArrayStrategy(10_0000, 0.9));
    }
}