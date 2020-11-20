public class Solution {

    // 基数排序：低位优先的实现

    private static final int OFFSET = 50000;

    public int[] sortArray(int[] nums) {
        int len = nums.length;

        // 预处理，让所有的数都大于等于 0，这样才可以使用基数排序
        for (int i = 0; i < len; i++) {
            nums[i] += OFFSET;
        }

        // 第 1 步：找出最大的数字
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        // 第 2 步：计算出最大的数字有几位，这个数值决定了我们要将整个数组看几遍
        int maxLen = getMaxLen(max);

        // 计数排序需要使用的计数数组和临时数组
        int[] count = new int[10];
        int[] temp = new int[len];

        // 表征关键字的量：除数
        // 1 表示按照个位关键字排序
        // 10 表示按照十位关键字排序
        // 100 表示按照百位关键字排序
        // 1000 表示按照千位关键字排序
        int divisor = 1;
        // 有几位数，外层循环就得执行几次
        for (int i = 0; i < maxLen; i++) {

            // 每一步都使用计数排序，保证排序结果是稳定的
            // 这一步需要额外空间保存结果集，因此把结果保存在 temp 中
            countingSort(nums, temp, divisor, len, count);

            // 交换 nums 和 temp 的引用，下一轮还是按照 nums 做计数排序
            int[] t = nums;
            nums = temp;
            temp = t;

            // divisor 自增，表示采用低位优先的基数排序
            divisor *= 10;
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[i] - OFFSET;
        }
        return res;
    }

    private void countingSort(int[] nums, int[] res, int divisor, int len, int[] count) {
        // 1、计算计数数组
        for (int i = 0; i < len; i++) {
            // 计算数位上的数是几，先取个位，再十位、百位
            int remainder = (nums[i] / divisor) % 10;
            count[remainder]++;
        }

        // 2、变成前缀和数组
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 3、从后向前赋值
        for (int i = len - 1; i >= 0; i--) {
            int remainder = (nums[i] / divisor) % 10;
            int index = count[remainder] - 1;
            res[index] = nums[i];
            count[remainder]--;
        }

        // 4、count 数组需要设置为 0 ，以免干扰下一次排序使用
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
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
}