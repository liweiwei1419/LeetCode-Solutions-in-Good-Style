import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

    // 双指针

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }

        // 预处理
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            // 剪枝 2
            if (nums[i] > 0) {
                break;
            }

            // 剪枝 3
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 在 [i + 1, len - 1] 区间里查找两数之和为 -nums[i]
            // 因为有序，因此可以可以把 j 和 k 分别从区间的两端向中间靠拢
            // 由此省去一个循环
            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    List<Integer> cur = new ArrayList<>(3);
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);

                    // 剪枝 1: 找到了一个解以后
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}