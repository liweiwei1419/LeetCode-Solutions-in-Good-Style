import java.util.Arrays;

public class Solution3 {

    // 方法一：动态规划，分类讨论，注意题目中的条件 1 <= target（目标位置） <= 10000

    public int racecar(int target) {
        // 要考虑 0 ，所以是 target + 1
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 每一个状态
        for (int i = 1; i <= target; i++) {

            // 先向前走 forward 步
            for (int forward = 1; ; forward++) {
                // 向前走了 forwardDistance，整数倍
                int forwardDistance = (1 << forward) - 1;

                if (forwardDistance >= 2 * i) { // 2 * i 这个怎么计算出来的 ？
                    break;
                }

                // 对应第一种情况，走了forward步直接到达i
                if (forwardDistance == i) {
                    dp[i] = forward;
                } else if (forwardDistance > i) {
                    // 对应第二种情况，越过了 i，+ 1 是因为回头需要一个 R 指令
                    dp[i] = Math.min(dp[i], forward + 1 + dp[forwardDistance - i]);

                    // 到这里都很容易理解

                } else {
                    // 枚举，难点
                    // 对应第三种情况，没有越过 i，先朝着负的方向走 backward 步，枚举
                    for (int backward = 0; backward < forward; backward++) {
                        int backwardDistance = (1 << backward) - 1;
                        // 第一个 + 1 是还没到达 i，先回头，使用一个 R
                        // 第二个 + 1 是回头走了 backwardDistance，再使用 R 回头走向 i
                        dp[i] = Math.min(dp[i], forward + 1 + backward + 1 + dp[i - forwardDistance + backwardDistance]);
                    }
                }
            }
        }
        return dp[target];
    }
}
