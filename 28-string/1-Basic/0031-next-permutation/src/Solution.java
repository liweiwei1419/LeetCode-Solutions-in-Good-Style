public class Solution {

    // 动画理解
    // https://pic.leetcode-cn.com/1df4ae7eb275ba4ab944521f99c84d782d17df804d5c15e249881bafcf106173-file_1555696082944


    // 索引的名字不知道叫什么好
    // 参考资料：七月的书里面有讲到"字典排序" https://blog.csdn.net/NoMasp/article/details/49913627

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // 从后向前数，第 1 个下降的索引
        int firstDownIndex = len - 2;
        // 注意这里是 >=
        while (firstDownIndex >= 0 && nums[firstDownIndex] >= nums[firstDownIndex + 1]) {
            firstDownIndex--;
        }
        // 注意这里的边界值
        if (firstDownIndex == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        // nums[index] <= nums[index + 1]
        // 比 nums[firstDownIndex] 值大的第 1 个数值，这里其实可以使用二分法
        int exchangeIndex = len - 1;
        while (exchangeIndex > firstDownIndex && nums[firstDownIndex] >= nums[exchangeIndex]) {
            exchangeIndex--;
        }
        swap(nums, firstDownIndex, exchangeIndex);
        // 不包括右边区间端点
        reverse(nums, firstDownIndex + 1, len - 1);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}