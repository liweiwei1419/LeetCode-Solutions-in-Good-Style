import java.util.Arrays;

public class Solution {

    public int triangleNumber(int[] nums) {
        // 索引数组：[0, 1, 2, 3, 4]，size = 5
        // i 最多到倒数第 2 个索引
        int len = nums.length;
        // 思路 1：从前到后，先固定 i ，再固定 j ，最后确定 k 的范围
        // 首先不要忘记排序
        Arrays.sort(nums);
        int res = 0;
        // 注意边界，看上面那个索引数组知道 i 最多取到 2
        for (int i = 0; i < len - 2; i++) {
            // 要给 k 留一个位置，故 size - 1 是上限（取不到）
            for (int j = i + 1; j < len - 1; j++) {
                // 在区间 [j + 1, size - 1] 中找第 1 个不能构成三角形的数
                // k 与 j 之间的数的个数就是一票解
                // 等价于，在子区间 [j + 1, size - 1] 里找第 1 个大于等于 nums[i] + nums[j] 的数
                int k = findFirstCanNotTriangle(nums, j + 1, len - 1, nums[i] + nums[j]);
                if (k == -1) {
                    // 说明子区间 [j + 1, len - 1] 全部的数都可以构成三角形
                    // 其中的数的个数为 len - 1 - (j + 1) + 1
                    res += (len - j - 1);
                } else {
                    // 说明子区间 [j + 1, k) 全部的数可以构成三角形，注意：这里 k 取不到
                    // 其中的数的个数为 k - (j + 1)
                    res += (k - j - 1);
                }
            }
        }
        return res;
    }

    private int findFirstCanNotTriangle(int[] nums, int left, int right, int target) {
        // 在 nums 的子区间 [left, right] 里找第 1 个大于等于 target 的元素的索引
        // 如果不存在，返回 -1
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 后处理，因为很有可能找不到大于等于 target 的元素
        if (nums[left] < target) {
            return -1;
        }
        return left;
    }
}