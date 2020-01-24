public class Solution {

    // dp[i]：代表以 i 结尾能取到的最长摆动序列的长度
    // 取 dp[i][0] 代表以 i 为结尾且 i - 1 到 i 为升
    // dp[i][1] 代表以 i 为结尾且 i - 1 到 i 为降

    // 如果当前 nums[i] 严格大于 nums[j]，则可以取从 j 到 i 上升，因此可以取 dp[j][i] + 1，
    //  因为 j 需要与之前的值是下降关系所以取的是 dp[j][1]

    // dp[i][0] = Math.max(if(nums[i] > nums[j]) dp[j][1] + 1), j:[0, i - 1]
    // dp[i][1] = Math.max(if(nums[i] < nums[j]) dp[j][0] + 1), j:[0, i - 1]

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < len; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else if (nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < len; i++) {
            int nowmax = Math.max(dp[i][0], dp[i][1]);
            max = Math.max(max, nowmax);
        }
        return max;
    }

}
