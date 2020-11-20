package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

import java.util.Arrays;

/**
 * 基数排序：按照关键字排序
 * 时间复杂度：
 * 空间复杂度：O(N * K)，这里 K = 10，N 表示数组的长度
 *
 * @author liweiwei1419
 * @date 2019/10/3 11:53 上午
 */
public class RadixSort implements ISortingAlgorithm {

    @Override
    public String toString() {
        return "基数排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        // 第 1 步：找出最大的数字
        int max = arr[0];
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            // 数据有效性校验，因为要将数值作为 count 的索引用，因此 nums[i] 不能小于 0
            if (arr[i] < 0) {
                throw new IllegalArgumentException("该数组不适合使用计数排序");
            }
        }

        // 第 2 步：计算出最大的数字有几位，这个数值决定了我们要将整个数组看几遍
        int maxLen = getMaxLen(max);

        // 第 3 步：每一趟都使用计数排序
        int[] count = new int[10];
        int[] temp = new int[len];

        int divisor = 1;
        // 有几位数，外层循环就得执行几次
        for (int i = 0; i < maxLen; i++) {
            // 每一步都使用计数排序，保证排序结果是稳定的
            // 这一步需要额外空间保存结果集，因此把结果保存在 temp 中
            countingSort(arr, temp, divisor, len, count);

            System.arraycopy(temp, 0, arr, 0, len);
            divisor *= 10;
        }
    }

    private void countingSort(int[] arr, int[] temp, int divisor, int len, int[] count) {
        // 内层循环得把数组从头到尾看一遍
        for (int j = 0; j < len; j++) {
            // 计算数位上的数是几，先取个位，再十位、百位
            int remainder = (arr[j] / divisor) % 10;
            count[remainder]++;
        }

        for (int j = 1; j < 10; j++) {
            count[j] += count[j - 1];
        }

        for (int j = len - 1; j >= 0; j--) {
            int remainder = (arr[j] / divisor) % 10;
            int index = count[remainder] - 1;
            temp[index] = arr[j];
            count[remainder]--;
        }

        for (int j = 0; j < 10; j++) {
            count[j] = 0;
        }
    }

    /**
     * 获取一个整数的最大位数
     *
     * @param num
     * @return
     */
    private int getMaxLen(int num) {
        int maxLen = 0;
        while (num > 0) {
            num /= 10;
            maxLen++;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        // 1、大数据测试用例
        // SortingUtil.testSortingAlgorithm(new RadixSort(), new GenerateRandomArrayStrategy(10_0000));
//
        // 2、O(N) 数量级理解
        SortingUtil.testSortingAlgorithm(new RadixSort(),
                new GenerateRandomArrayStrategy(10_0000));

        SortingUtil.testSortingAlgorithm(new RadixSort(),
                new GenerateRandomArrayStrategy(100_0000));

        SortingUtil.testSortingAlgorithm(new RadixSort(),
                new GenerateRandomArrayStrategy(1000_0000));
    }
}