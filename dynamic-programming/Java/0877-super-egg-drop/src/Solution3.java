import java.util.Arrays;

public class Solution3 {

    // 最优值 k 的优化

    public int superEggDrop(int K, int N) {
        // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
        int[][] dp = new int[N + 1][K + 1];

        // 初始化全部值，一定不会超过楼层的层数
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        // 初始化第 0 行
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }
        // 初始化第 1 行
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }
        // 初始化第 0 列、第 1 列
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 调换了顺序
        for (int j = 2; j <= K; j++) {
            int optK = 1;
            for (int i = 2; i <= N; i++) {
                // 最优楼层 optimizationK 是一个单调的值，线性去搜索
                while (optK <= i) {
                    int breakCount = dp[optK - 1][j - 1];
                    int notBreakCount = dp[i - optK][j];
                    if (breakCount < notBreakCount) {
                        optK++;
                    } else {
                        break;
                    }
                }
                // Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[optK - 1][j - 1], dp[i - optK][j])) + 1;
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
//        int K = 1;
//        int N = 2;

//        int K = 2;
//        int N = 6;

        int K = 3;
        int N = 14;


//        int K = 8;
//        int N = 5000;

//        int K = 8;
//        int N = 10000;

//        int K = 9;
//        int N = 5000;

//        int K = 9;
//        int N = 10000;


//        int K = 10;
//        int N = 5000;


//        int K = 10;
//        int N = 10000;

//        int K = 13;
//        int N = 8192;

        int res = solution.superEggDrop(K, N);
        System.out.println(res);
    }
}
