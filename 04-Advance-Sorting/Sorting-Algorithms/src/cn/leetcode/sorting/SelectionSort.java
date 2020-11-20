package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/7 2:13 PM
 */
public class SelectionSort implements ISortingAlgorithm {

    @Override
    public String toString() {
        return "选择排序";
    }

    @Override
    public void sort(int[] arr) {
        // 循环中多次用到的变量，先存一下
        int len = arr.length;
        // 外层循环：枚举扫描区间的左边界
        for (int i = 0; i < len - 1; i++) {
            // 假设修正法（打擂台法）
            int minIndex = i;
            for (int j = i + 1; j <= len - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换数组中两个位置上的元素
            SortingUtil.swap(arr, i, minIndex);
        }
        // 循环不变式：区间 [0, i) 有序，并且它们中的元素都放在了最终应该在的位置
    }

    /**
     * 更规范的做法应该是在单元测试里编写测试代码
     *
     * @param args
     */
    public static void main(String[] args) {
        // JDK7 引入的带下划线的数组常量 1_0000 等价于 10000，加下划线在 0 较多的时候可以增加可读性

        // 记住结论：1 秒之内，平方级别的时间复杂度可以处理 10^4 级别的数据
        SortingUtil.testSortingAlgorithm(new SelectionSort(), new GenerateRandomArrayStrategy(1_0000));
        SortingUtil.testSortingAlgorithm(new SelectionSort(), new GenerateRandomArrayStrategy(2_0000));
        SortingUtil.testSortingAlgorithm(new SelectionSort(), new GenerateRandomArrayStrategy(4_0000));
        SortingUtil.testSortingAlgorithm(new SelectionSort(), new GenerateRandomArrayStrategy(8_0000));
    }
}