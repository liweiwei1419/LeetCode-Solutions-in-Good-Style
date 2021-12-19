import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // 特殊用例判断
        if (len < 3) {
            return res;
        }

        // 排序是去重复的前提
        Arrays.sort(nums);
        // i 枚举到 len - 1 就可以，从 len - 2 开始凑不出 3 个数
        for (int i = 0; i < len - 2; i++) {
            // 因为有序，如果 nums[i] > 0，后面的数一定得不到三数之和为 0
            if (nums[i] > 0) {
                // 注意是 break 不是 continue
                break;
            }

            // 理解这个剪枝非常重要
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            // 注意：这里是严格小于，因为要找的是不重合的两个数，当 left 和 right 重合的时候，本轮搜索结束
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);

                    // 剪枝，避免 left 和 right 寻找的过程中出现重复
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum > 0) {
                    // 后面的数太大了，让 right 往左走一步试试看
                    right--;
                } else {
                    // sum < 0， 前面的数太小了，让 left 往右走一步试试看
                    left++;
                }
            }
        }
        return res;
    }
}