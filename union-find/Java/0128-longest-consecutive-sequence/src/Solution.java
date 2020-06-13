import java.util.Arrays;

public class Solution {

    // 暴力解法
    // 时间复杂度：O(\N \logN + N)
    // 空间复杂度：O(1)

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(nums);

        int longestLen = 1;
        int res = 1;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                // 重复元素要去掉
                continue;
            } else if (nums[i] == (pre + 1)) {
                longestLen++;
                res = Math.max(res, longestLen);
            } else {
                longestLen = 1;
            }
            pre = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums = new int[]{1, 2, 0, 1};
        int res = solution.longestConsecutive(nums);
        System.out.println(res);
    }
}
