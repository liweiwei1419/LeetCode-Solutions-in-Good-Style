public class Solution {

    // 问题转化为：是否能够拿出一部分元素，使得它们的和恰好等于 nums / 2
    // 转换为 0-1 背包问题


    // dp[i][j]：子区间 [0, i] 内可以拿出一部分元素，其值恰好等于 nums / 2
    // 状态转移方程：（分类讨论：nums[i] 这个数选还是不选）
    // dp[i][j] = dp[i - 1][j] or dp[i][j - nums[i]]

    // 初始化：dp[0][0] = true (注意：这个值的设置得根据状态转移方程而来)
    // 对于所有的 i，dp[i][0] = true
    // 输出：dp[len - 1][nums / 2]

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }


        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j]) {
                    System.out.print('1');
                } else {
                    System.out.print('0');
                }
                System.out.print(' ');
            }
            System.out.println();
        }

        return dp[len - 1][target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        Solution solution = new Solution();

        boolean res = solution.canPartition(nums);
        System.out.println(res);

    }
}
