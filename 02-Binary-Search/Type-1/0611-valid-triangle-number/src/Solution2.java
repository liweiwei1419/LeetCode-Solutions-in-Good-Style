import java.util.Arrays;

public class Solution2 {

    public int triangleNumber(int[] nums) {
        // 索引数组：[0, 1, 2, 3, 4]，size = 5
        // i 最多到倒数第 2 个索引
        int len = nums.length;
        // 思路 2：从后到前，先固定 k ，再固定 j ，最后确定 i 的范围
        // 首先不要忘记排序
        Arrays.sort(nums);
        int res = 0;
        // 注意边界，看上面那个索引数组知道 k 最小取到 2，不能再小了
        for (int k = len - 1; k > 1; k--) {
            // 要给 k 留一个位置，故 size - 1 是上限（取不到）
            for (int j = k - 1; j > 0; j--) {
                // 在区间 [0, j - 1] 中找第 1 个能构成三角形的数
                // i 与 j 之间的数的个数就是一票解
                // 等价于，在子区间 [0, j - 1] 里找第 1 个大于（不能等于） nums[k] - nums[j] 的数
                int i = findFirstCanTriangle(nums, 0, j - 1, nums[k] - nums[j]);
                if (i == -1) {
                    // 说明子区间 [0, j - 1] 全部的数都不能构成三角形
                    // 其中的数的个数为 0，
                    // 为了语义清晰，我还是写一下 + 0
                    res += 0;
                } else {
                    // 说明子区间 [i, j - 1] 全部的数可以构成三角形，注意：这里 k 取不到
                    // 其中的数的个数为 j - 1 - i + 1
                    res += (j - i);
                }
            }
        }
        return res;
    }

    private int findFirstCanTriangle(int[] nums, int left, int right, int target) {
        // 在 nums 的子区间 [left, right] 里找第 1 个大于（不能等于） target 的元素的索引
        // 如果不存在，返回 -1
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 后处理，因为很有可能找不到大于等于 target 的元素
        if (nums[left] <= target) {
            return -1;
        }
        return left;
    }
}