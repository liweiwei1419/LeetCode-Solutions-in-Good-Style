public class CountingSort {

    public void sort(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        // 检验数据有效性
        // 找到数组中的最大值，以确定计数数组的长度
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            // 数据有效性校验，因为要将数值作为数组 count 的下标使用，因此 nums[i] 不能小于 0
            if (nums[i] < 0) {
                throw new IllegalArgumentException("该数组不适合使用计数排序");
            }
        }

        // 第 1 步：对原始数组进行计数，这里将原始数组的值，作为了计数数组的下标
        int[] count = new int[max + 1];
        // 遍历原始数组，完成计数
        for (int i = 0; i < len; i++) {
            count[nums[i]] += 1;
        }

        // 第 2 步：将 count 数组改造成前缀和数组，我们需要的是前缀和，在原地进行变换即可
        // 由前缀和数组就可以推出这个元素所在的位置
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // 为了写回去，需要对原始数组做一个拷贝
        int[] numsCopy = new int[len];
        for (int i = 0; i < len; i++) {
            numsCopy[i] = nums[i];
        }
        // 使用 Java 语言可以使用下面这一行代替
        // System.arraycopy(nums, 0, numsCopy, 0, len);

        // 第 3 步：从后向前扫描，依次把看到的数写回原始数组，从后向前是为了保证稳定性
        for (int i = len - 1; i >= 0; i--) {
            // 位置有一个偏移，在纸上写出来就很容易发现规律
            int position = count[numsCopy[i]] - 1;
            // 把看到的数覆盖回去
            nums[position] = numsCopy[i];
            // 前缀和减一，作为下一个看到的相同数存放位置的依据
            count[numsCopy[i]]--;

            // 以上三行，可以用下面这一行代替，但不建议这样写
            // nums[--count[numsCopy[i]]] = numsCopy[i];
        }
    }
}