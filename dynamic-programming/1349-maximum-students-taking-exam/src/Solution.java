public class Solution {

    // 状态压缩：把状态用一个整数来表示，通常是与位运算，这样在比较状态的时候，就不需要遍历了

    // 1 个整数可以表示 2^32 种状态，一般情况下 n 不会很大
    // 前 m - 1 横排的最大人数加上第 m 排满足条件的最大人数就得到整个教室所能参加的最大人数

    public int maxStudents(char[][] seats) {
        int rows = seats.length;
        int cols = seats[0].length;
        // validity 数组用于记录每一横排位置是否能坐，所以数组的长度是 rows
        int[] validity = new int[rows];

        // 每一横排可由学生排布的方式有 2^cols 种
        int stateSize = 1 << cols;
        int[][] dp = new int[rows][stateSize];
        int res = 0;

        // 初始化 validity 数组（表示是否可以座下）
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (seats[i][j] == '.') {
                    validity[i] = (validity[i] << 1) + 1;
                } else {
                    validity[i] = (validity[i] << 1);
                }
            }
        }

        // 初始化 dp 数组，表示没有被计算出来
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < stateSize; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < stateSize; j++) {
                // j & validity[i] == j 判断 j 的状态下能否坐下第 i 横排
                // (j & (j >> 1) == 0) 判断 j 模式左右是否没人
                if (((j & validity[i]) == j) && ((j & (j >> 1)) == 0)) {
                    if (i == 0) {
                        // 第一排
                        dp[i][j] = Integer.bitCount(j);
                    } else {
                        // 不是第一排，就要遍历前一排，从而取得当前排的最大值。
                        for (int k = 0; k < stateSize; k++) {

                            // 如果左上角和右上角没有学生
                            if ((j & (k >> 1)) == 0 && ((j >> 1) & k) == 0 && (dp[i - 1][k] != -1)) {

                                // 计算状态 j 表示的人数 Integer.bitCount(j)
                                dp[i][j] = Math.max(dp[i - 1][k] + Integer.bitCount(j), dp[i][j]);
                            }
                        }
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    // 官方题解可以参考一下
    // https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/can-jia-kao-shi-de-zui-da-xue-sheng-shu-by-leetcod/
    // https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/xiang-jie-ya-suo-zhuang-tai-dong-tai-gui-hua-jie-f/
    // https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/can-jia-kao-shi-de-zui-da-xue-sheng-shu-ya-suo-zhu/
    // https://leetcode-cn.com/problems/maximum-students-taking-exam/solution/zhuang-tai-ya-suo-dp-by-lucifer1004/
}
