package cn.leetcode.sorting;

import cn.leetcode.utils.SortingUtil;

import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/9/8 2:15 AM
 */
public class ShellSort2 implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "希尔排序";
    }

    /**
     * 以有 9 个元素的数组为例，间隔依次为 4、2、1
     * [1]，2，3，4，[5]，6，7，8，[9]
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        int delta = len / 2;
        while (delta >= 1) {
            // 这一步要很小心
            for (int i = delta; i < len; i++) {
                insertionForDelta(arr, delta, i);
            }
            delta /= 2;
        }
    }

    /**
     * 将 arr[i] 插入到对应分组的正确位置上
     *
     * @param arr
     * @param detal
     * @param i
     */
    private void insertionForDelta(int[] arr, int detal, int i) {
        int temp = arr[i];
        int j = i;
        // 注意：这里 j >= deta 的原因
        while (j >= detal && arr[j - detal] > temp) {
            arr[j] = arr[j - detal];
            j -= detal;
        }
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int testTimes = 5;
        for (int i = 0; i < testTimes; i++) {
            // 应该多运行几次，避免我们编写的算法恰好"蒙混过关"
            int[] randomArray = SortingUtil.generateRandomArray(10, 1, 10);
            int[] randomArrayCopy = SortingUtil.copyFromArray(randomArray);

            ShellSort2 shellSort3 = new ShellSort2();
            shellSort3.sort(randomArray);
            Arrays.sort(randomArrayCopy);

            SortingUtil.judgeArrayEquals(randomArray, randomArrayCopy);
        }
    }
}