import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // 方法：三数之和的推广，理解这道题需要先做「力扣」第 15 题：三数之和
    // 时间复杂度：O(n^3);
    // 空间复杂度：O(n);

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }

        Arrays.sort(nums);
        // len-4 len-3 len-2 len-1
        for (int i = 0; i < len - 3; i++) {
            // 跳过重复的解 1（以排序为前提）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // len-3 len-2 len-1
            for (int j = i + 1; j < len - 2; j++) {
                // 跳过重复的解 2（以排序为前提）
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 接下来使用双指针
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> oneSolution = new ArrayList<>();
                        oneSolution.add(nums[i]);
                        oneSolution.add(nums[j]);
                        oneSolution.add(nums[left]);
                        oneSolution.add(nums[right]);
                        res.add(oneSolution);
                        // 跳过重复的解 3（以排序为前提）
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // 这一步不要忘记了
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}