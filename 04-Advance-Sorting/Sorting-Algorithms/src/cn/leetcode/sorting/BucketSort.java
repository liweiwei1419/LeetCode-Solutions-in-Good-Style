package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/10/3 2:10 下午
 */
public class BucketSort implements ISortingAlgorithm {

    @Override
    public String toString() {
        return "桶排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        int max = arr[0];
        // 第 1 步：找到数组中的最大值，以确定计数数组的长度
        for (int i = 1; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            // 数据有效性校验，因为要将数值作为 count 的索引用，因此 nums[i] 不能小于 0
            if (arr[i] < 0) {
                throw new IllegalArgumentException("该数组不适合使用计数排序");
            }
        }

        // 第 2 步：计算出最大的数字有几位，这个数值决定了桶的个数
        int maxLen = getMaxLen(max);
        // 步长
        int step = 1000;
        // 决定设置几个桶
        if (maxLen < 5) {
            // 如果最大数小于 10000
            // 3 位数就设置 100 个桶
            // 2 位数就设置 10 个桶
            step = (int) Math.pow(10, maxLen);
        }
        // System.out.println("步长：" + step);

        // 桶的个数
        int bucketLen = max / step;
        // System.out.println("桶的个数：" + bucketLen);

        // 因为不能确定每个桶存放的数据量，因此每个桶的长度都设置为 len
        int[][] temp = new int[bucketLen + 1][len];
        int[] next = new int[bucketLen + 1];

        // 第 3 步：分桶
        for (int i = 0; i < len; i++) {
            // 找到所在的桶的索引
            int bucketIndex = arr[i] / step;
            // 在该桶中放入元素
            temp[bucketIndex][next[bucketIndex]] = arr[i];
            // 该桶存放的元素个数 + 1
            next[bucketIndex]++;
        }

        // 第 4 步：对于每个桶执行插入排序
        for (int i = 0; i < bucketLen + 1; i++) {
            insertionSort(temp[i], next[i] - 1);
        }

        // 第 5 步：从桶里依次取出来
        int index = 0;
        for (int i = 0; i < bucketLen + 1; i++) {
            int curLen = next[i];
            for (int j = 0; j < curLen; j++) {
                arr[index] = temp[i][j];
                index++;
            }
        }
    }

    private void insertionSort(int[] arr, int endIndex) {
        for (int i = 1; i <= endIndex; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
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
        SortingUtil.testSortingAlgorithm(new BucketSort(), new GenerateRandomArrayStrategy(1_0000));
        // 2、O(N) 数量级理解
        SortingUtil.testSortingAlgorithm(new BucketSort(), new GenerateRandomArrayStrategy(10_0000));

        // 越平均越好
        SortingUtil.testSortingAlgorithm(new BucketSort(), new GenerateRandomArrayStrategy(100_0000));
    }
}