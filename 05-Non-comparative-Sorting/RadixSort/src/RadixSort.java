public class RadixSort {

    public void sort(int[] nums) {
        int len = nums.length;
        // 第 1 步：找出最大的数字
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            // 数据有效性校验，因为要将数值作为 count 的索引用，因此 nums[i] 不能小于 0
            if (nums[i] < 0) {
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
            // 每一步都使用计数排序，保证排序结果是稳定的，这一步需要额外空间保存结果集，因此把结果保存在 temp 中
            countingSort(nums, temp, divisor, len, count);

            System.arraycopy(temp, 0, nums, 0, len);
            divisor *= 10;
        }
    }

    /**
     *
     * @param nums 原始数组
     * @param temp 在计数排序的过程中使用的辅助数组，这一次基于 divisor 关键字的排序结果存在这里
     * @param divisor
     * @param len 原始数组的长度（冗余变量）
     * @param count 计数数组
     */
    private void countingSort(int[] nums, int[] temp, int divisor, int len, int[] count) {
        // 内层循环得把数组从头到尾看一遍
        for (int j = 0; j < len; j++) {
            // 计算数位上的数是几，先取个位，再十位、百位
            int remainder = (nums[j] / divisor) % 10;
            count[remainder]++;
        }

        for (int j = 1; j < 10; j++) {
            count[j] += count[j - 1];
        }

        for (int j = len - 1; j >= 0; j--) {
            int remainder = (nums[j] / divisor) % 10;
            int index = count[remainder] - 1;
            temp[index] = nums[j];
            count[remainder]--;
        }

        // 重置数组 count，以便下次使用
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
}