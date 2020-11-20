import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        // 特判
        if (len < 3) {
            throw new IllegalArgumentException("参数错误");
        }
        // 初始化，因为找最小值，因此把初始值设置成实数的最大值
        int diff = Integer.MAX_VALUE;
        int res = nums[0] + nums[1] + nums[len - 1];
        // 排序是前提，很关键
        Arrays.sort(nums);
        // len - 3、len - 2、len - 1

        for (int i = 0; i < len - 2; i++) {
            // 常见的剪枝操作，这里可以排除重复的情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 双指针：指针对撞
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 不管是变小还是变大，尝试的作用是让 sum 与 target 更接近
                // 即 s 与 target 的绝对值之差越来越小
                if (sum > target) {
                    // 如果大了，尝试右边界收缩一格，让 target 变小
                    right--;
                } else if (sum < target) {
                    // 如果小了，尝试左边界收缩一格，让 target 变大
                    left++;
                } else {
                    // 如果已经等于 target 的话, 肯定是最接近的，根据题目要求，返回这三个数的和
                    assert sum == target;
                    return target;
                }

                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
            }
        }
        return res;
    }
}