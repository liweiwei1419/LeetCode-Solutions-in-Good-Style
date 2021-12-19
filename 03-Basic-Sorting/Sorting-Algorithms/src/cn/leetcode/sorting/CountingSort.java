package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * 计数排序
 * 时间复杂度：O(N + K)，这里 N 是数组的长度，K 是输入数组的最大元素
 * 如果 K 很大，会占用很多空间，就不适合使用计数排序
 * 注意：计数排序是如何做到稳定的
 *
 * @author liweiwei1419
 * @date 2019/10/3 11:54 上午
 */
public class CountingSort implements ISortingAlgorithm {

    @Override
    public String toString() {
        return "计数排序";
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

        // 第 2 步：对原始数组进行计数，这里将原始数组的值，作为了计数数组的索引
        int[] count = new int[max + 1];
        // 遍历原始数组，计数
        for (int i = 0; i < len; i++) {
            count[arr[i]] += 1;
        }

        // 第 3 步：将 count 数组变换成前缀和数组，我们需要的是前缀和，在原地进行变换即可
        // 由前缀和数组就可以推出这个元素所在的位置
        for (int i = 1; i < max + 1; i++) {
            count[i] += count[i - 1];
        }

        // 第 4 步：为了写回去，需要对原始数组做一个拷贝
        int[] numsCopy = new int[len];
        for (int i = 0; i < len; i++) {
            numsCopy[i] = arr[i];
        }
        // 使用 Java 语言可以使用下面这一行代替
        // System.arraycopy(nums, 0, numsCopy, 0, len);


        // 第 5 步：从后向前扫描，依次把看到的数写回原始数组，从后向前是为了保证稳定性
        for (int i = len - 1; i >= 0; i--) {
            // 位置有一个偏移，在纸上写出来就很容易发现规律
            int position = count[numsCopy[i]] - 1;
            // 把看到的数覆盖回去
            arr[position] = numsCopy[i];
            // 前缀和减一，作为下一个看到的相同数存放位置的依据
            count[numsCopy[i]]--;

            // 以上三行，可以用下面这一行代替，但非常不建议这样写，可读性差
            // nums[--count[numsCopy[i]]] = numsCopy[i];
        }
    }

    public static void main(String[] args) {
        // 1、大数据测试用例
        SortingUtil.testSortingAlgorithm(new CountingSort(),
                new GenerateRandomArrayStrategy(100_0000, 0, 1_0000));

        // 2、O(N) 数量级理解
        SortingUtil.testSortingAlgorithm(new CountingSort(),
                new GenerateRandomArrayStrategy(10_0000, 0, 1_0000));

        SortingUtil.testSortingAlgorithm(new CountingSort(),
                new GenerateRandomArrayStrategy(100_0000, 0, 1_0000));

        SortingUtil.testSortingAlgorithm(new CountingSort(),
                new GenerateRandomArrayStrategy(1000_0000, 0, 1_0000));

    }
}