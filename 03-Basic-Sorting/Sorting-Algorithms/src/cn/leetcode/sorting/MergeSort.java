package cn.leetcode.sorting;

import cn.leetcode.examples.GenerateNearlySortedArrayStrategy;
import cn.leetcode.examples.GenerateRandomArrayStrategy;
import cn.leetcode.utils.SortingUtil;

/**
 * @author liweiwei1419
 * @date 2019/9/8 3:07 AM
 */
public class MergeSort implements ISortingAlgorithm {
    @Override
    public String toString() {
        return "归并排序";
    }

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        mergeSort(arr, 0, len - 1);
    }

    /**
     * 对数组 nums 在区间 [left, right] 内进行归并排序
     *
     * @param nums
     * @param left  左边界，可以取到
     * @param right 右边界，可以取到
     */
    private void mergeSort(int[] nums, int left, int right) {
        // 先写递归到底的情况，即递归终止条件：
        // 1、不形成区间：left == right;
        // 2、形成的区间长度为 1，此时有 left = right，此时没有必要"分"，也无法"分"
        if (left == right) {
            return;
        }
        // 将区间二分（下面的这个写法有 bug，但不容易被发现，在优化版本中更改）
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeOfTwoArray(nums, left, mid, right);
    }


    /**
     * 将两个有序数组合并成为一个有序数组
     * 数组 nums 在区间 [left, mid] 是有序的
     * 数组 nums 在区间 [mid + 1, right] 是有序的
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    private void mergeOfTwoArray(int[] nums, int left, int mid, int right) {
        // 每做一次合并，都 new 数组用于归并，开销大
        int len = right - left + 1;
        int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            temp[i] = nums[left + i];
        }

        // nums 表示源数组
        // left 表示源数组要复制的起始位置
        // temp 表示目标数组
        // 0 表示目标数组被赋值的起始位置
        // len 表示要复制的长度
        // 其它语言可以使用 for 循环代替
        // System.arraycopy(nums, left, temp, 0, len);

        // i 和 j 分别指向前有序数组和后有序数组的起始位置
        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            // 先写 i 和 j 越界的情况
            if (i == mid + 1 - left) {
                nums[left + k] = temp[j];
                j++;
            } else if (j == right + 1 - left) {
                nums[left + k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里严格上说应该写成 <=，否则就变成了非稳定排序
                nums[left + k] = temp[i];
                i++;
            } else {
                nums[left + k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(21_4748_3647);
//        System.out.println((11_0000_0000 + 11_0000_0000) >>> 1);

        // 1、测试"归并排序"的有效性
//        SortingUtil.testSortingAlgorithm(new MergeSort(), new GenerateRandomArrayStrategy(100_0000));
//        SortingUtil.testSortingAlgorithm(new MergeSort(), new GenerateRandomArrayStrategy(400_0000));

        // 2、比较"归并排序"与"插入排序"
        SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(10_0000),
                new InsertionSortOptimize(),
                new MergeSort());

        // 即使是还没有优化过的归并排序，都比插入排序的优化版本要快

        // 3、几乎有序的数组，结论依然还是归并排序要快
        SortingUtil.compareSortingAlgorithms(new GenerateNearlySortedArrayStrategy(10_0000, 0.99),
                new InsertionSortOptimize(),
                new MergeSort());
    }
}